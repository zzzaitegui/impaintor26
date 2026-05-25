package com.impaintor.feature.matchmaking.dto;

public record MatchmakingStatusResponse(boolean queued, long waitSeconds, int searchRange, String roomCode) {
    public static MatchmakingStatusResponse notQueued() {
        return new MatchmakingStatusResponse(false, 0, 0, null);
    }
}
