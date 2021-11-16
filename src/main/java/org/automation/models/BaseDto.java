package org.automation.models;

import org.automation.utils.DtoConverter;

public abstract class BaseDto {


    public String toJsonString() {
        return DtoConverter.dtoToJsonString(this);
    }

    public String toPrettyJsonString() {
        return DtoConverter.dtoToPrettyJsonString(this);
    }

    @Override
    public String toString() {
        return toJsonString();
    }

}
