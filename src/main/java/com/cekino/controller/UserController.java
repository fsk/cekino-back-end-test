package com.cekino.controller;

import com.cekino.entities.User;
import com.cekino.paths.UserPaths;
import com.cekino.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = UserPaths.BASE_URL)
@Api(value = "This Class is REST API for this CEKINO Project")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping(value = UserPaths.GET_ALL_USERS)
    @ApiOperation(value = "This operation Gets all USER Object from PostgreSQL",
            notes = "For Example request: localhost:1905/cekino/getAllUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(value = UserPaths.GET_USER_BY_ID + "{id}")
    @ApiOperation(value = "This operation Gets according to given id return USER OBJECT from PostgreSQL.",
            notes = "For Example request: localhost:1905/cekino/getUserById/1")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long id) throws Exception {
        return userService.getUserById(id);
    }

    @PostMapping(value = UserPaths.INSERT_USER)
    @ApiOperation(value = "This operation Inserts a USER OBJECT in PostgreSQL.",
            notes = "For Example request: localhost:1905/cekino/insertUser")
    public User insertUser(@RequestBody User user) throws Exception {
        return userService.insertUser(user);
    }

    @PutMapping(value = UserPaths.UPDATE_USER_BY_ID + "{id}")
    @ApiOperation(value = "This operation Updates according to given id updates the USER OBJECT from PostgreSQL.",
            notes = "For Example request: localhost:1905/cekino/updateUserById/1")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long id,
                                                   @RequestBody User userDetails) throws Exception {
        return userService.updateUserById(id, userDetails);
    }

    @DeleteMapping(value = UserPaths.DELETE_USER_BY_ID + "{id}")
    @ApiOperation(value = "This operation Delete according to given id USER OBJECT from PostgreSQL.",
            notes = "For Example request: localhost:1905/cekino/deleteUserById/1")
    public Map<String, Boolean> deleteUserById(@PathVariable("id") Long id) throws Exception {
        return userService.deleteUserById(id);
    }

    @DeleteMapping(value = UserPaths.DELETE_ALL_USERS)
    @ApiOperation(value = "This operation Deletes all Users Objects from PostgreSQL.",
            notes = "For Example request: localhost:1905/cekino/deleteAllUsers")
    public void deleteAllUsers() throws Exception {
        userService.deleteAllUsers();
    }

}
