package com.maru.accounts.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
@Schema(
        name = "Response",
        description = "Schema to hold successful response information."
)
public class ResponseDto {

    @Schema(
            example = "200"
    )
    private String statusCode;


    @Schema(
            example = "Request processed successfully"
    )
    private String statusMsg;
}
