package com.vibe.api.controller;

import com.vibe.common.dto.SpotifyPlaylistResponse;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/api/spotify")
public class SpotifyController {

    private final RestClient restClient;

    public SpotifyController(RestClient.Builder builder) {
        this.restClient = builder.baseUrl("https://api.spotify.com/v1").build();
    }

    @GetMapping("/playlists")
    public SpotifyPlaylistResponse getUserPlaylists(
            @RegisteredOAuth2AuthorizedClient("spotify") OAuth2AuthorizedClient authorizedClient
    ) {
        // 1. Get the "Valet Key" (Access Token) from the secure session
        String accessToken = authorizedClient.getAccessToken().getTokenValue();
        System.out.println(authorizedClient.getAccessToken().getTokenValue());

        // 2. Call Spotify API
        return restClient.get()
                .uri("/me/playlists?limit=50")
                .header("Authorization", "Bearer " + accessToken)
                .retrieve()
                .body(SpotifyPlaylistResponse.class);
    }
}
