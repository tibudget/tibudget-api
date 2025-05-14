package com.tibudget.api;

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
     * @return The response including body, headers, and cookies.
     * @throws IOException on failure (network error, unauthorized domain, etc.)
     */
    Response get(String url, Map<String, String> headers, Map<String, String> cookies) throws IOException;

    /**
     * Performs an HTTP POST request with a text payload.
     *
     * @param url     Full URL to post to.
     * @param body    The request body, typically a JSON or form string.
     * @param headers Optional HTTP headers.
     * @param cookies Optional HTTP cookies (name → value).
     * @return The response including body, headers, and cookies.
     * @throws IOException on failure.
     */
    Response post(String url, String body, Map<String, String> headers, Map<String, String> cookies) throws IOException;

    /**
     * Downloads a file from a URL and saves it to a destination given in the response body. The type of file will be automatically determined.
     *
     * @param url         The URL of the file to download.
     * @param headers     Optional headers to include in the request.
     * @param cookies     Optional cookies to include in the request.
     * @return The response including body (the full path where the file has been stored), headers, and cookies.
     * @throws IOException on failure (invalid destination, network error, etc.)
     */
    Response downloadFile(String url, Map<String, String> headers, Map<String, String> cookies) throws IOException;

    /**
     * Represents an HTTP response including body, headers, and cookies.
     */
    class Response {
        public final String body;
        public final Map<String, String> headers;
        public final Map<String, String> cookies;

        public Response(String body, Map<String, String> headers, Map<String, String> cookies) {
            this.body = body;
            this.headers = headers;
            this.cookies = cookies;
        }
    }
}
