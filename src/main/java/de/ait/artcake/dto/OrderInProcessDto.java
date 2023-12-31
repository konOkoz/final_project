package de.ait.artcake.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderInProcessDto {

    @Schema(description = "Confectioner Id of the confectioner who declined", example = "3")
    private Long confectionerId;

    @Schema(description = "Additional fee depending on client wishes and urgency, " +
            "standard order preparation time is 2 days.", example = "00.00")
    private Double extra;

}
