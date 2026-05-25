package com.impaintor.feature.game.model;

import java.util.List;

/**
 * Evento de galería emitido desde game con las capturas de la ronda actual.
 */
public record GalleryPhaseEvent(String type, List<GameState.CanvasSnapshot> snapshots) {

    public GalleryPhaseEvent(List<GameState.CanvasSnapshot> snapshots) {
        this("GALLERY_PHASE", snapshots);
    }
}