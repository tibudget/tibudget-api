package com.tibudget.api;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Interface defining a secure and controlled HTTP communication bridge
 * for dynamically loaded collector plugins.
 * <p>
 * All requests are subject to domain whitelisting and logging, and are executed
 * outside of the plugin sandbox process to ensure network isolation and security.
 */
public interface InternetProvider {

    /**
     * Performs an HTTP GET request.
     *
     * @param url     Full URL to request.
     * @param headers Optional HTTP headers.
     * @param cookies Optional HTTP cookies (name → value).
     * @return The response body as a raw String.
     * @throws IOException on failure (network error, unauthorized domain, etc.)
     */
    String get(String url, Map<String, String> headers, Map<String, String> cookies) throws IOException;

    /**
     * Performs an HTTP POST request with a text payload.
     *
     * @param url     Full URL to post to.
     * @param body    The request body, typically a JSON or form string.
     * @param headers Optional HTTP headers.
     * @param cookies Optional HTTP cookies (name → value).
     * @return The response body as a raw String.
     * @throws IOException on failure.
     */
    String post(String url, String body, Map<String, String> headers, Map<String, String> cookies) throws IOException;

    /**
     * Downloads a file from a URL and saves it to the specified destination.
     *
     * @param url         The URL of the file to download.
     * @param destination The destination file to write the content into.
     * @param headers     Optional headers to include in the request.
     * @param cookies     Optional cookies to include in the request.
     * @throws IOException on failure (invalid destination, network error, etc.)
     */
    void downloadFile(String url, File destination, Map<String, String> headers, Map<String, String> cookies) throws IOException;
}
