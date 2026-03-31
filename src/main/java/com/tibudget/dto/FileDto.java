package com.tibudget.dto;

import java.io.*;
import java.util.Objects;

/**
 * Represents a file transferred between the collector and the Android app.
 * <p>
 * The content must be provided as a temporary file, created either by downloading it
 * through {@code InternetProvider} or by creating it with {@code File.createTempFile()}.
 * <p>
 * The maximum file size is limited to {@link #MAX_SIZE_BYTES}.
 */
public class FileDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /** Maximum allowed file size in bytes. */
    private static final int MAX_SIZE_BYTES = 52_428_800;

    /**
     * Defines the functional type of a file and how it should be handled by the application.
     */
    public enum FileDtoType {
        /** A generic image file, such as a photo or scan. */
        IMAGE,
        /** A formal invoice document, usually including legal and tax details. */
        INVOICE,
        /** A payment receipt, such as a card terminal or bank payment receipt. */
        RECEIPT_PAYMENT,
        /** A cashier receipt, also known as a sales receipt or till receipt, typically listing purchased items. */
        RECEIPT_CASHIER,
        /** A contract or legally binding agreement. */
        CONTRACT,
        /** An informational or administrative notice. */
        NOTICE,
        /** Any file that does not fit into the predefined categories. */
        OTHER
    }

    /** Type of file so the app knows how to process it. */
    private FileDtoType type;

    /** A human-readable label for this file. */
    private String label;

    /** The MIME type of the file, for example {@code image/png} or {@code application/pdf}. */
    private String contentType;

    /** The actual file; it must be a temporary file. */
    private File file;

    /**
     * Creates an empty {@code FileDto}.
     */
    public FileDto() {
        super();
    }

    /**
     * Creates a file DTO with an explicit MIME type.
     *
     * @param type the file type
     * @param label the human-readable file label
     * @param contentType the MIME type
     * @param file the temporary file
     */
    public FileDto(FileDtoType type, String label, String contentType, File file) {
        this();
        this.type = type;
        this.label = label;
        this.contentType = contentType;
        this.file = file;
    }

    /**
     * Creates a file DTO and infers the MIME type from the file extension.
     *
     * @param type the file type
     * @param label the human-readable file label
     * @param file the temporary file
     */
    public FileDto(FileDtoType type, String label, File file) {
        this(type, label, detectMimeTypeFromExtension(file.getPath()), file);
    }

    /**
     * Tries to guess the MIME type from the file extension.
     *
     * @param filePath the file path
     * @return the detected MIME type, or {@code application/octet-stream} if unknown
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
        return "application/octet-stream";
    }

    /**
     * Returns the file type.
     *
     * @return the file type
     */
    public FileDtoType getType() {
        return type;
    }

    /**
     * Sets the file type.
     *
     * @param type the file type
     */
    public void setType(FileDtoType type) {
        this.type = type;
    }

    /**
     * Returns the file label.
     *
     * @return the file label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the file label.
     *
     * @param label the file label
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Returns the temporary file.
     *
     * @return the temporary file
     */
    public File getFile() {
        return file;
    }

    /**
     * Sets the temporary file.
     *
     * @param file the temporary file
     */
    public void setFile(File file) {
        this.file = file;
    }

    /**
     * Returns the MIME content type.
     *
     * @return the MIME content type
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * Sets the MIME content type.
     *
     * @param contentType the MIME content type
     */
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
