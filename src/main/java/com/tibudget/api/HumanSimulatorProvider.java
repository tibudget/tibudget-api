package com.tibudget.api;

import java.net.URL;
import java.util.Map;

/**
 * Interface for retrieving human simulator.
 */
public interface HumanSimulatorProvider {

    /**
     * Open a WebView to simulate a human browsing the given URL. Once the page is fully loaded it returns after having
     * added cookies and headers
     * @param url URL to browse
     * @param cookies An empty map you provide so cookies can be added into it
     * @param headers An empty map you provide so headers can be added into it
     */
    void simulateHuman(URL url, Map<String, String> cookies, Map<String, String> headers);
}
