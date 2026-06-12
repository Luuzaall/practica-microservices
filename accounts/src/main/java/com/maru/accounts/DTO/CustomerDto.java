package com.maru.accounts.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

// Acá utilizamos arroba Data y no en Customer porque da problemas para las clases del tipo entidad
@Data
@Schema(
        name = "Customer",
        description = "Schema to old Customer and Account Information"
)
public class CustomerDto {

    @Schema(
            description = "Name of the customer",
            example = "Maru"
    )
    @NotEmpty(message = "Name cannot be null or empty")
    @Size(min = 5, max = 30, message="The length of the customer name should be between 5 and 30")
    private String name;

    @Schema(
            description = "Email of the customer",
            example = "Maru@gmail.com"
    )
    @NotEmpty(message = "Email cannot be null or empty")
    @Email(message = "Email address should be valid.")
    private String email;

    @Schema(
            description = "Mobile number of the customer",
            example = "3513223829"
    )
    @NotEmpty(message = "Mobile number cannot be null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @Schema(
            description = "Account details of the customer"
    )
    private AccountDto accountDto;
}
