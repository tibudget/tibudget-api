package com.tibudget.api;

import java.io.IOException;
import java.io.Serializable;
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
     * @param contentType Content type of the body
     * @param headers Optional HTTP headers.
     * @param cookies Optional HTTP cookies (name → value).
     * @return The response including body, headers, and cookies.
     * @throws IOException on failure.
     */
    Response post(String url, String body, String contentType, Map<String, String> headers, Map<String, String> cookies) throws IOException;

    /**
     * Downloads a file from a URL and saves it to a destination given in the response body. The type of file will be automatically determined.
     *
     * @param url         The URL of the file to download.
     * @param headers     Optional headers to include in the request.
     * @param cookies     Optional cookies to include in the request.
     * @param forceContentType Expected mime type of the document, e.g. "application/pdf". It is highly recommanded to
     *                         define it but if you don't the app will try to guess it (maybe wrong).
     * @return The response including body (the full path where the file has been stored), headers, and cookies.
     * @throws IOException on failure (invalid destination, network error, etc.)
     */
    Response downloadFile(String url, Map<String, String> headers, Map<String, String> cookies, String forceContentType) throws IOException;

    /**
     * Represents an HTTP response including body, headers, and cookies.
     */
    class Response implements Serializable {
        public final int code;
        public final String message;
        public final String method;
        public final String location;
        public final String protocol;
        public final String body;
        public final Map<String, String> headers;
        public final Map<String, String> cookies;

        public Response(int code, String message, String method, String location, String protocol, String body, Map<String, String> headers, Map<String, String> cookies) {
            this.code = code;
            this.message = message;
            this.method = method;
            this.location = location;
            this.protocol = protocol;
            this.body = body;
            this.headers = headers;
            this.cookies = cookies;
        }
    }
}
