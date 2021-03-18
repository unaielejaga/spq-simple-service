package com.example;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("users")
public class UsersResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUsers() {
        // This data could be retrieved from a database
        List<User> users = new ArrayList<User>();
        users.add(new User(0, "John", "Smith"));
        users.add(new User(1, "Isaac", "Newton"));
        users.add(new User(0, "Albert", "Einstein"));

        return users;
    }
}

