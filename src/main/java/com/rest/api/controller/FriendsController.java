package com.rest.api.controller;


import com.rest.api.domain.FriendDto;
import com.rest.api.domain.request.FriendRequest;
import com.rest.api.domain.response.FriendResponse;
import com.rest.api.service.FriendsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "api/v1/friends", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class FriendsController {

    private final FriendsService friendsService;

    @Autowired
    public FriendsController(FriendsService friendsService) {
        this.friendsService = friendsService;
    }

    @GetMapping
    public ResponseEntity<List<FriendDto>> getAllFriends() {
        return ResponseEntity.ok(friendsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FriendDto> getFriendById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(friendsService.findById(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FriendResponse> createFriend(@Valid @RequestBody FriendRequest friendRequest) {
        return ResponseEntity.ok(friendsService.createFriend(friendRequest));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FriendResponse> updateFriend(@PathVariable(value = "id") Long id,
                                                       @Valid @RequestBody FriendRequest friendRequest) {
        return ResponseEntity.ok(friendsService.updateFriend(id, friendRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FriendResponse> deleteFriend(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok(friendsService.deleteFriend(id));
    }
}
