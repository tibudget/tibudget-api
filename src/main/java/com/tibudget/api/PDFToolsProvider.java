package com.tibudget.api;

import java.io.File;
import java.io.IOException;

/**
 * Provides PDF processing tools to collector plugins, including text extraction.
 * <p>
 * Collectors are strongly encouraged to use this provider when parsing PDF files,
 * such as invoices, to extract information from their contents. Bundling a
 * dedicated PDF parsing library in a collector will very likely result in that
 * collector being rejected by Tibu.
 * <p>
 * If the available tools do not cover a collector's needs, contact the Tibu team
 * to discuss possible enhancements. Suggestions and requests for additional PDF
 * processing capabilities are welcome.
 */
public interface PDFToolsProvider {

    /**
     * Extracts text from a PDF file so the collector can parse its contents.
     *
     * @param pdf the PDF file to read
     * @return the text extracted from the PDF
     * @throws IOException if the PDF cannot be read or text extraction fails
     */
    String extractText(File pdf) throws IOException;
}
