package org.automation.services;

import org.automation.services.placeholder.JsonPlaceHolderApi;

public class Services {

    private Services() {
        // default private constructor
    }

    public static JsonPlaceHolderApi placeholderApi() {
        return new JsonPlaceHolderApi();
    }

}
