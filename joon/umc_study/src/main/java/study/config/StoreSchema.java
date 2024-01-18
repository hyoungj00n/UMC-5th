package study.config;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "first name of the user", name = "firstName", type = "string", example = "Vatsal" )
public class StoreSchema {
    String firstName;
}
