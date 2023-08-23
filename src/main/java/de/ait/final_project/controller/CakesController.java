package de.ait.final_project.controller;

import de.ait.final_project.controller.api.CakesApi;
import de.ait.final_project.dto.NewOrderDto;
import de.ait.final_project.dto.OrderDto;
import de.ait.final_project.security.details.AuthenticatedUser;
import de.ait.final_project.services.OrderService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@RestController
public class CakesController implements CakesApi {


    OrderService orderService;

    @Override
    public ResponseEntity<OrderDto> addOrder(Integer cakeId, NewOrderDto newOrder) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(orderService.addOrder(cakeId, newOrder));

    }
}
