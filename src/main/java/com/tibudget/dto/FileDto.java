package com.tibudget.dto;

import java.io.File;
import java.io.Serializable;

public class FileDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Defines the type of a file, determining how it will be used.
     */
    public enum FileDtoType {
        IMAGE,
        INVOICE,
        CONTRACT,
        NOTICE,
        OTHER
    }

    /**
     * Type of file so the app know how to deal with it
     */
    private FileDtoType type;

    /**
     * A label for this file
     */
    private String label;

    /**
     * The file content. Your collector must download the file in a temporary file.
     */
    private File file;

    /**
     * This empty constructor can be usefull for tests
     */
    public FileDto() {
        super();
    }

    public FileDto(FileDtoType type, String label, File file) {
        this();
        this.type = type;
        this.label = label;
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    public String getLabel() {
        return label;
    }

    public FileDtoType getType() {
        return type;
    }

    public void setType(FileDtoType type) {
        this.type = type;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
