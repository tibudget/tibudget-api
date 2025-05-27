package com.tibudget.dto;

import java.io.*;
import java.util.Objects;

/**
 * Represents a file to be transmitted between the collector and the Android app.
 *
 * <p>The content must be provided as a temporary file, created either by downloading via InternetProvider
 * or by creating it with File.createTempFile().</p>
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
     * Tries to guess the MIME type from the file extension.
     */
    private static String detectMimeTypeFromExtension(String filePath) {
        String lower = filePath.toLowerCase();
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
