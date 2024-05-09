package com.backend.authentication.backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
public class MessagesController {

    @RequestMapping(method = RequestMethod.GET, path = "/messages")
    public ResponseEntity<List<String>> hello() throws URISyntaxException {
        return ResponseEntity.ok(Arrays.asList("first","last"));
    }
}
