package com.tibudget.api;

import com.tibudget.api.exceptions.AccessDeny;
import com.tibudget.api.exceptions.ConnectionFailure;
import com.tibudget.api.exceptions.ParameterError;
import com.tibudget.api.exceptions.TemporaryUnavailable;

public interface OpenIdAuthenticator {

    void setConfiguration(String jsonConfiguration);

    String getConfiguration();

    void authenticate() throws AccessDeny, TemporaryUnavailable, ConnectionFailure, ParameterError;

    String getParameter(String key);

}
