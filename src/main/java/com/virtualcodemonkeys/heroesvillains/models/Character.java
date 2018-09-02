package com.virtualcodemonkeys.heroesvillains.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Character {
    private String name;
    private float height;
    private float weight;
    private Orientation orientation;
    private List<Group> association;
    private List<String> friends;
    private List<String> enemies;
    private String universe;
}
