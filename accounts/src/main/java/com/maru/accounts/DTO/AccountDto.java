package com.maru.accounts.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

// Acá utilizamos arroba Data y no en Account porque da problemas para las clases del tipo entidadwwwwww
@Data
@Schema(
        name = "Account",
        description = "Schema to Account Information"
)
public class AccountDto {

    @Schema(
            description = "Account number of the bank",
            example = "1234567891"
    )
    @NotEmpty(message = "Account number can not be a null or empty")
    @Pattern(regexp="(^$|[0-9]{10})",message = "AccountNumber must be 10 digits")
    private Long accountNumber;

    @Schema(
            description = "Account type of the bank",
            example = "Savings"
    )
    @NotEmpty(message = "Account type can not be a null or empty")
    private String accountType;

    @Schema(
            description = "Branch address of the bank",
            example = "123 New Yorke"
    )
    @NotEmpty(message = "Branch address can not be a null or empty")
    private String branchAddress;
}
