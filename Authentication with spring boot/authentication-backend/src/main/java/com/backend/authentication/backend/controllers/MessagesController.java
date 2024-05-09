package com.backend.authentication.backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

@RestController
public class MessagesController {
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/messages")
    public ResponseEntity<List<String>> hello() throws URISyntaxException {
        return ResponseEntity.ok(Arrays.asList("first","last"));
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, path = "/messages")
    public ResponseEntity<List<String>> hello2() throws URISyntaxException {
        return ResponseEntity.ok(Arrays.asList("first","last"));
    }
