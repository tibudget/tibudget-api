package com.tibudget.dto;

import java.io.*;
import java.util.Objects;

/**
 * Represents a file to be transmitted between the collector and the Android app.
 *
 * <p>The content must be provided as a temporary file, created either by downloading via InternetProvider
 * or by loading a resource from the classpath.</p>
 *
 * <p>The maximum file size is limited to {@link #MAX_SIZE_BYTES}.</p>
 */
public class FileDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /** Maximum allowed file size */
    private static final int MAX_SIZE_BYTES = 52_428_800;

    /**
     * Defines the type of a file, determining how the app should handle it.
     */
    public enum FileDtoType {
        IMAGE, INVOICE, RECEIPT, CONTRACT, NOTICE, OTHER
    }

    /** Type of file so the app knows how to process it */
    private FileDtoType type;

    /** A human-readable label for this file */
    private String label;

    /** The MIME type of the file (e.g. "image/png", "application/pdf") */
    private String contentType;

    /** The actual file, must be a temporary file */
    private File file;

    // Constructors

    /** Default constructor, useful for testing or deserialization */
    public FileDto() {
        super();
    }

    /**
     * Full constructor with MIME type.
     */
    public FileDto(FileDtoType type, String label, String contentType, File file) {
        this();
        this.type = type;
        this.label = label;
        this.contentType = contentType;
        this.file = file;
    }

    /**
     * Constructor that infers the MIME type from the file extension.
     */
    public FileDto(FileDtoType type, String label, File file) {
        this(type, label, detectMimeTypeFromExtension(file.getPath()), file);
    }

    /**
     * Constructs a FileDto by loading a resource from the classpath
     * and writing it to a temporary file.
     *
     * @param type         Type of the file (IMAGE, INVOICE, etc.)
     * @param label        Label for the file
     * @param contentType  MIME type (e.g. "image/png")
     * @param resourcePath Path to the resource in the classpath (e.g. "/images/logo.png")
     * @throws IOException If the resource is not found, unreadable, or too large
     */
    public FileDto(FileDtoType type, String label, String contentType, String resourcePath) throws IOException {
        this();
        this.type = type;
        this.label = label;
        this.contentType = contentType;

        try (InputStream inputStream = FileDto.class.getClassLoader().getResourceAsStream(resourcePath)) {
            if (inputStream == null) {
                throw new FileNotFoundException("Resource not found: " + resourcePath);
            }

            // Create a temp file with correct extension
            String extension = resourcePath.contains(".") ?
                    resourcePath.substring(resourcePath.lastIndexOf(".")) : ".tmp";
            File tempFile = File.createTempFile("tibu_stubbed_", extension);

            try (FileOutputStream outputStream = new FileOutputStream(tempFile)) {
                byte[] buffer = new byte[1024];
                int totalBytes = 0;
                int length;

                while ((length = inputStream.read(buffer)) > 0) {
                    totalBytes += length;
                    if (totalBytes > MAX_SIZE_BYTES) {
                        throw new IOException("Resource " + resourcePath + " exceeds max allowed size of " + MAX_SIZE_BYTES + " bytes");
                    }
                    outputStream.write(buffer, 0, length);
                }
            }

            this.file = tempFile;
        }
    }

    /**
     * Constructs a FileDto from a resource, inferring its MIME type.
     *
     * @param type         Type of the file
     * @param label        Label for the file
     * @param resourcePath Path to the resource in the classpath
     * @throws IOException If the resource cannot be read or exceeds allowed size
     */
    public FileDto(FileDtoType type, String label, String resourcePath) throws IOException {
        this(type, label, detectMimeTypeFromExtension(resourcePath), resourcePath);
    }

    /**
     * Tries to guess the MIME type from the file extension.
     */
    private static String detectMimeTypeFromExtension(String resourcePath) {
        String lower = resourcePath.toLowerCase();
        if (lower.endsWith(".png")) return "image/png";
        if (lower.endsWith(".jpg") || lower.endsWith(".jpeg")) return "image/jpeg";
        if (lower.endsWith(".webp")) return "image/webp";
        if (lower.endsWith(".avif")) return "image/avif";
        if (lower.endsWith(".svg")) return "image/svg+xml";
        if (lower.endsWith(".pdf")) return "application/pdf";
        if (lower.endsWith(".txt")) return "text/plain";
        if (lower.endsWith(".zip")) return "application/zip";
        return "application/octet-stream"; // fallback
    }

    // Getters and Setters

    /** @return the file type */
    public FileDtoType getType() {
        return type;
    }

    public void setType(FileDtoType type) {
        this.type = type;
    }

    /** @return the label */
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    /** @return the temporary file */
    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    /** @return the MIME content type */
    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    // Object overrides

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof FileDto)) return false;
        FileDto fileDto = (FileDto) o;
        return type == fileDto.type &&
                Objects.equals(label, fileDto.label) &&
                Objects.equals(file, fileDto.file) &&
                Objects.equals(contentType, fileDto.contentType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, label, file, contentType);
    }

    @Override
    public String toString() {
        return "FileDto{" +
                "type=" + type +
                ", label='" + label + '\'' +
                ", file=" + (file != null ? file.getAbsolutePath() : "null") +
                ", contentType='" + contentType + '\'' +
                '}';
    }
}
