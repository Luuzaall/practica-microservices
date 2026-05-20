package com.maru.accounts.DTO;

import lombok.Data;

// Acá utilizamos arroba Data y no en Account porque da problemas para las clases del tipo entidadwwwwww
@Data
public class AccountDto {
    private Long accountNumber;

    private String accountType;

    private String branchAddress;
}
