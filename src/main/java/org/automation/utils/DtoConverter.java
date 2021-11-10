package org.automation.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.util.Strings;

public class DtoConverter {

    private static final Logger LOGGER = LogManager.getLogger();

    private DtoConverter() {
        // default private constructor, no object creation
    }

    /**
     * Convert dto to json string.
     *
     * @param dtoClass input object
     * @return String json
     */
    public static String dtoToJsonString(Object dtoClass) {
        ObjectMapper mapper = new ObjectMapper();
        return writeAsString(dtoClass, mapper, JsonInclude.Include.NON_NULL);
    }

    /**
     * Convert dto to pretty json output.
     *
     * @param dtoClass - source
     * @return string json
     */
    public static String dtoToPrettyJsonString(Object dtoClass) {
        String result = Strings.EMPTY;
        ObjectMapper mapper = new ObjectMapper();
        try {
            result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(dtoClass);
        } catch (JsonProcessingException e) {
            LOGGER.error(e.getMessage());
        }
        return result;
    }

    private static String writeAsString(Object dtoClass, ObjectMapper mapper, JsonInclude.Include option) {
        String result = Strings.EMPTY;
        try {
            mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            mapper.setSerializationInclusion(option);
            result = mapper.writeValueAsString(dtoClass);
        } catch (JsonProcessingException e) {
            LOGGER.error(e.getMessage());
        }
        return result;
    }



}
