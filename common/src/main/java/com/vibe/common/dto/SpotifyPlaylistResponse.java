package com.vibe.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
public class SpotifyPlaylistResponse {
    private List<Playlist> items;
    private String next;
    private Integer total;

    @Data
    public static class Playlist {
        private String id;
        private String name;
        private String description;

        @JsonProperty("owner")
        private Owner owner;

        @JsonProperty("tracks")
        private TracksInfo tracks;

        private List<Image> images;
    }

    @Data
    public static class Owner {
        @JsonProperty("display_name")
        private String displayName;
    }

    @Data
    public static class TracksInfo {
        private Integer total;
    }

    @Data
    public static class Image {
        private String url;
    }
}