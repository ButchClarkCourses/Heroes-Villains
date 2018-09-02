package com.virtualcodemonkeys.heroesvillains.mongo;

import com.virtualcodemonkeys.heroesvillains.models.Group;
import com.virtualcodemonkeys.heroesvillains.models.Orientation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor(force=true)
@AllArgsConstructor
@Builder
@Document(collection = "characters")
public class DBCharacter {

    @Id
    private String id;

    private String name;
    private float height;
    private float weight;
    private Orientation orientation;
    private List<String> friends;
    private List<String> enemies;
    private String universe;

    private List<String> associations;

}
