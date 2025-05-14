package com.tibudget.api;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Interface defining a secure and controlled HTTP communication bridge
 * for dynamically loaded collector plugins.
 * <p>
 * Implementations may modify the provided headers and cookies maps
 * to reflect changes based on the HTTP response (e.g. setting new cookies,
 * tracking headers, etc.). Therefore, callers must ensure these maps are
 * mutable (e.g. HashMap).
 */
public interface InternetProvider {

    /**
     * Performs an HTTP GET request.
     *
     * @param url     Full URL to request.
     * @param headers Modifiable map of headers. Will be read and may be updated.
     * @param cookies Modifiable map of cookies. Will be sent and may be updated from response.
     * @return The response body as a raw String.
     * @throws IOException on failure (network error, unauthorized domain, etc.)
     */
    String get(String url, Map<String, String> headers, Map<String, String> cookies) throws IOException;

    /**
     * Performs an HTTP POST request with a text payload.
     *
     * @param url     Full URL to post to.
     * @param body    The request body, typically a JSON or form string.
     * @param headers Modifiable map of headers. Will be read and may be updated.
     * @param cookies Modifiable map of cookies. Will be sent and may be updated from response.
     * @return The response body as a raw String.
     * @throws IOException on failure.
     */
    String post(String url, String body, Map<String, String> headers, Map<String, String> cookies) throws IOException;

    /**
     * Downloads a file from a URL and saves it to the specified destination.
     *
     * @param url         The URL of the file to download.
     * @param destination The destination file to write the content into.
     * @param headers     Modifiable map of headers. Will be read and may be updated.
     * @param cookies     Modifiable map of cookies. Will be sent and may be updated from response.
     * @throws IOException on failure (invalid destination, network error, etc.)
     */
    void downloadFile(String url, File destination, Map<String, String> headers, Map<String, String> cookies) throws IOException;
}
