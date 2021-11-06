package com.example.demo.controllers;

import com.example.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MainController {
    private final UserService userService;

    @GetMapping("/")
    public String homePage(){
        return "home page";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminPage(){
        return "admin page";
    }

    @GetMapping("/auth")
    public String authenticationEcho(){
        return "Authentication page";
    }

    @GetMapping("/library/books")
    @PreAuthorize("hasRole('USER')")
    public String booksLibrary(){
        return "books library page";
    }

    @GetMapping("/library/films")
    public String filmsLibrary(){
        return "films library page";
    }

    @GetMapping("/library")
    public String fLibraries(){
        return "Libraries list page: /library/games  /library/films  /library/books ";
    }

    @GetMapping("/library/games")
    @PreAuthorize("hasAuthority('GAMES')")
    public String gamesLibrary(){
        return "games library page";
    }

    @GetMapping("/info")
    @PreAuthorize("hasRole('ADMIN')")
    public String infoPage(){
        return "info page";
    }
}
