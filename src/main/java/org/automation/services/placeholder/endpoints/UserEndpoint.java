package org.automation.services.placeholder.endpoints;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import java.util.List;
import org.automation.models.enums.HttpStatus;
import org.automation.models.placeholder.UserDto;
import org.automation.services.common.AbstractWebEndpoint;

public class UserEndpoint extends AbstractWebEndpoint {


    private static final String USERS_END = "/users";
    private static final String USERS_RESOURCE_END = "/users/{userID}";

    public UserEndpoint(RequestSpecification specification) {
        super(specification);
    }

    public UserDto create(UserDto userDto) {

        return create(userDto, HttpStatus.CREATED)
            .extract().as(UserDto.class);
    }

    public ValidatableResponse create(UserDto userDto, HttpStatus status) {
        return post(
            this.specification,
            USERS_END,
            userDto)
            .statusCode(status.getCode());
    }

    public UserDto update(UserDto userDto, String id) {
        ValidatableResponse response = put(this.specification, USERS_RESOURCE_END, userDto, id);
        response.statusCode(200);
        return response.extract().as(UserDto.class);
    }

    public ValidatableResponse update(UserDto userDto, String id, int statusCode) {
        ValidatableResponse response = put(this.specification, USERS_RESOURCE_END, userDto, id);
        response.statusCode(statusCode);
        return response;
    }

    public UserDto getById(String id) {
        ValidatableResponse response = get(this.specification, USERS_RESOURCE_END, id);
        response.statusCode(200);
        return response.extract().as(UserDto.class);
    }

    public List<UserDto> getAll() {
        return List.of(getAll(HttpStatus.OK).extract().as(UserDto[].class));
    }

    public ValidatableResponse getAll(HttpStatus status) {
        ValidatableResponse response = get(this.specification, USERS_END);
        response.statusCode(status.getCode());
        return response;
    }

}
