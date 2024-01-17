package com.example.api.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title="Doctor And Patient API",
                description = "Doing CRUD operation and suggest Doctor",
                summary ="This Doctor and Patient API is add doctor and Patient remove and Suggest syntom to which Doctor ",
                termsOfService = "Term and Condition",
                contact = @Contact(
                name = "Nitesh Pandey",
                email = "nkpandey7759@gmail.com"
                ),
                license = @License(
                name ="your License No"
                ),
                version ="3.2.1"
                ),
        servers = {
            @Server(
            description ="Dev",
                    url="http://localhost:8080"
            ),
            @Server(
            description ="test",
                    url="http://localhost:8080"
            )
        },
      security =   @SecurityRequirement(name = "authBearer")
)
@SecurityScheme(
        name ="authBearer",
        in = SecuritySchemeIn.HEADER,
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        description = "Security desc",
        scheme = "bearer"
)
public class SwggerConfig {
    
}
