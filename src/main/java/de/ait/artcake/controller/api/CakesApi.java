package de.ait.artcake.controller.api;

import de.ait.artcake.dto.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

import de.ait.artcake.dto.CakesDto;
import de.ait.artcake.dto.StandardResponseDto;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tags(value = {
        @Tag(name = "Cakes")
})
@RequestMapping("/api/cakes")
public interface CakesApi {
    @Operation(summary = "add Cake to our assortment", description = "only for manager")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "adding successful",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = CakeDto.class))
                    }),
            @ApiResponse(responseCode = "401", description = "User unauthorized",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = StandardResponseDto.class))
                    })
    })
    @PreAuthorize("hasAnyAuthority('MANAGER')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<CakeDto> addCake(@Parameter(required = true, description = "Cake" )
                                    @Valid @RequestBody NewCakeDto newCake);

    @Operation(summary = "get cake", description = "for all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "get cake",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = CakeDto.class))
                    }),
            @ApiResponse(responseCode = "404", description = "not found",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = StandardResponseDto.class))
                    })
    })
    @GetMapping("/{cake-id}")
    ResponseEntity<GetCakeImageDto> getCake(@Parameter(required = true, description = "cake id", example = "1")
                                    @PathVariable("cake-id") Long cakeId);

    @Operation(summary = "get all cakes", description = "for all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "get cakes",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = CakesDto.class))
                    }),
            @ApiResponse(responseCode = "404", description = "not found",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = StandardResponseDto.class))
                    })
    })
    @GetMapping
    ResponseEntity<GetCakesImageDto> getAllCakes(@Parameter(description = "page number", example = "1")
                                         @RequestParam(value = "page") Integer page,
                                         @Parameter(description = "field to sort by. Available for id, name, price, category")
                                         @RequestParam(value = "orderBy", required = false) String field,
                                         @Parameter(description = "true if you want to sort in reverse order")
                                         @RequestParam(value = "desc", required = false) Boolean desc);

    @Operation(summary = "get cakes by category", description = "for all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "get cakes by category",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = CakesDto.class))
                    }),
            @ApiResponse(responseCode = "404", description = "not found",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = StandardResponseDto.class))
                    })
    })
    @GetMapping("/category/{category}")
    ResponseEntity<GetCakesImageDto> getCakesByCategory(@Parameter(required = true, description = "category", example = "MOUSSE")
                                                @PathVariable("category") String category);

    @Operation(summary = "update cake in our assortment", description = "only for manager")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "updating successful",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = CakeDto.class))
                    }),
            @ApiResponse(responseCode = "401", description = "User unauthorized",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = StandardResponseDto.class))
                    }),
            @ApiResponse(responseCode = "403", description = "Is Forbidden",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = StandardResponseDto.class))
                    })
    })
    @PreAuthorize("hasAnyAuthority('MANAGER')")
    @PutMapping("/{cake-id}")
    ResponseEntity<CakeDto> updateCake(@Parameter(required = true, description = "cake id", example = "1")
                                       @PathVariable("cake-id") Long cakeId,
                                       @Valid @RequestBody  UpdateCakeDto updateCake);


    @Operation(summary = "get cake rating", description = "for all users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "get cake rating",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = CakeRatingDto.class))
                    }),
            @ApiResponse(responseCode = "404", description = "not found",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = StandardResponseDto.class))
                    })
    })
    @GetMapping("/sales")
    ResponseEntity<List<CakeRatingDto>> getCakeRating();

}

