package org.automation.services.placeholder;

import io.restassured.specification.RequestSpecification;
import org.automation.services.common.AbstractWebService;
import org.automation.services.placeholder.endpoints.UserEndpoint;

public class JsonPlaceHolderApi extends AbstractWebService {

    private static final String API_KEY = "placeholderService";
    private RequestSpecification requestSpecification;

    public JsonPlaceHolderApi() {
        super(API_KEY);
        initRequestSpecification();
    }


    protected void initRequestSpecification() {
        requestSpecification = getDefaultSpecification();
    }

    public UserEndpoint user() {
        return new UserEndpoint(requestSpecification);
    }



}
