package de.ait.artcake.controller;

import de.ait.artcake.controller.api.UsersApi;
import de.ait.artcake.dto.*;
import de.ait.artcake.security.details.AuthenticatedUser;
import de.ait.artcake.services.UsersService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@RestController
public class UsersController implements UsersApi {

    UsersService usersService;

    @Override
    public ResponseEntity<UserDto> getMyProfile(AuthenticatedUser currentUser) {
        Long userId = currentUser.id();
        return ResponseEntity
                .ok(usersService.getUser(userId));
    }

    @Override
    public ResponseEntity<UsersDto> getAllUsersByRole(String role) {
        return ResponseEntity
                .ok()
                .body(usersService.getAllUsersByRole(role));
    }

    @Override
    public ResponseEntity<OrdersForManagerDto> getAllOrders(OrdersRequestDto request) {
        return ResponseEntity
                .ok(usersService.getAllOrders(request));
    }

    @Override
    public ResponseEntity<OrdersDto> getAllOrdersForConfectioner(Integer pageNumber, String orderByField, Boolean desc ) {
        return ResponseEntity
                .ok(usersService.getAllOrdersForConfectioner(pageNumber, orderByField, desc));
    }
  
    @Override
    public ResponseEntity<OrdersDto> getAllOrdersForClient(Integer pageNumber, String orderByField, Boolean desc) {
        return ResponseEntity
                .ok()
                .body(usersService.getAllOrdersForClient(pageNumber, orderByField, desc));
    }

    @Override
    public ResponseEntity<UserDto> updateUser(Long userId, UpdateUserDto updateUser) {
        return ResponseEntity
                .ok()
                .body(usersService.updateUser(userId, updateUser));
    }


}
