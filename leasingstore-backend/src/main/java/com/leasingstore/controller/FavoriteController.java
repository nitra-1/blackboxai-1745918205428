package com.leasingstore.controller;

import com.leasingstore.entity.Favorite;
import com.leasingstore.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for managing user favorites
 */
@RestController
@RequestMapping("/api/favorites")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @GetMapping("/user/{userId}")
    public List<Favorite> getFavoritesByUser(@PathVariable Long userId) {
        return favoriteService.getFavoritesByUserId(userId);
    }

    @PostMapping
    public Favorite addFavorite(@RequestBody Favorite favorite) {
        return favoriteService.addFavorite(favorite);
    }

    @DeleteMapping("/{id}")
    public void removeFavorite(@PathVariable Long id) {
        favoriteService.removeFavorite(id);
    }
}
