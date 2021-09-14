package com.muskan.resource;

import com.muskan.bean.User;
import com.muskan.bean.UserList;
import com.muskan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
public class UserResource {
	 private UserService userService;

	    @Autowired
	    public void setUserService(UserService userService) {
	        this.userService = userService;
	    }

	    @Autowired

	    @GetMapping(produces = "Application/json")
	    UserList findAllUsers() {
	        return userService.getAllUsers();
	    }

	    @GetMapping(path = "/{id}", produces = "Application/json")
	    User getUserById(@PathVariable("id") int id) {
	        return userService.getUserById(id);
	    }

	    @GetMapping(path = "/name/{userName}", produces = "Application/json")
	    User getUserByName(@PathVariable("userName") String userName) {
	        return userService.getUserByName(userName);
	    }

	    @RequestMapping(method = RequestMethod.POST, produces = "Application/json", consumes = "Application/json")
	    User saveUser(@RequestBody User user) {
	        return userService.insertUser(user);
	    }

	    @RequestMapping(path = "/{id}/{name}", method = RequestMethod.PUT, produces = "Application/json")
	    User updateUserName(@PathVariable("id") int id, @PathVariable("name") String name) {
	        return userService.updateUserName(id, name);
	    }

	    @RequestMapping(path = "/{id}/changePassword/{password}", method = RequestMethod.PUT, produces = "Application/json")
	    User updateUserPassword(@PathVariable("id") int id, @PathVariable("password") String password) {
	        return userService.updateUserPassword(id, password);
	    }

	    @RequestMapping(path = "/changePassword", method = RequestMethod.PUT, produces = "Application/json",consumes = "Application/json")
	    User updateUserPassword(@RequestBody User user) {
	        return userService.updateUserPassword(user.getId(), user.getPassword());
	    }

	    @DeleteMapping(path = "/{id}", produces = "Application/json", consumes = "Application/json")
	    User deleteMovie(@PathVariable("id") int id) {
	        return userService.deleteUserById(id);
	    }
}
