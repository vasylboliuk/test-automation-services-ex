package org.automation.services.common;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.StringUtils;
import org.automation.config.EnvironmentProvider;
import org.automation.models.configuration.EnvironmentConfigDto;

public abstract class AbstractWebService {

    protected String apiSetting;
    protected EnvironmentConfigDto apiConfig;

    protected AbstractWebService(String apiSetting) {
        this.apiSetting = apiSetting;
        loadApiConfig();
    }

    protected abstract void initRequestSpecification();

    private void loadApiConfig() {
        apiConfig = EnvironmentProvider
            .provideEnvironment().getSettings(apiSetting);
    }

    protected RequestSpecification getDefaultSpecification() {
        RequestSpecBuilder specBuilder = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .setBaseUri(apiConfig.getApiUrl())
            .setPort(apiConfig.getApiPort());
        if (!StringUtils.isEmpty(apiConfig.getApiBasePath())) {
            specBuilder.setBasePath(apiConfig.getApiBasePath());
        }
        return specBuilder.build();
    }


}
