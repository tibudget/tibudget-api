package com.tibudget.api;

import java.io.File;
import java.io.IOException;

/**
 * Interface that provides PDF tools like a text extractor, very usefull to extract informations from an invoice
 * for exemple.
 */
public interface PDFToolsProvider {

    String extractText(File pdf) throws IOException;
}
