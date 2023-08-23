package de.ait.final_project.dto;

import de.ait.final_project.models.Cake;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CakeDto {

    @Schema(description = "Cakes id", example = "1")
    private Long id;

    @Schema(description = "Cakes name", example = "BlueBerry-Cupcake")
    private String name;

    @Schema(description = "Cakes ingredients", example = "eggs, milk, salt")
    private String ingredients;

    @Schema(description = "Cakes price", example = "100$")
    private String price;

    @Schema(description = "Cakes Category", example = "CUPCAKES")
    private String category;

    @Schema(description = "linking a cake to ordersId", example = "1")
    private Long ordersId;

    public static CakeDto from (Cake cake) {
        CakeDto result = CakeDto.builder()
                .id(cake.getId())
                .name(cake.getName())
                .ingredients(cake.getIngredients())
                .price(cake.getPrice().toString())
                .category(cake.getCategory().toString())
                .build();

        return result;
    }

    public static List<CakeDto> from(Collection<Cake> cakes){
        return cakes.stream()
                .map(CakeDto::from)
                .collect(Collectors.toList());
    }
}
