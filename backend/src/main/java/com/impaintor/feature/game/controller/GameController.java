package com.impaintor.feature.game.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.impaintor.feature.game.model.GameState;
import com.impaintor.feature.game.service.GameService;
import com.impaintor.feature.room.repository.RoomRepository;

/**
 * Endpoints del feature de juego
 */
@RestController
@RequestMapping("/api/game")
public class GameController {

    private final GameService gameService;

    public GameController(RoomRepository roomRepository, GameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/rooms/{code}/start")
    public ResponseEntity<?> startGame(@PathVariable String code) {
        try {
            GameState gameState = gameService.initializeGame(code);
            return ResponseEntity.ok(gameState);
        } catch (IllegalStateException | IllegalArgumentException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
