package com.virtualcodemonkeys.heroesvillains.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Group {
    private String name;
    private String orientation;
    private List<Character> members;
}
