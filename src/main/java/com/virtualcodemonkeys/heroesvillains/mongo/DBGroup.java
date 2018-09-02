package com.virtualcodemonkeys.heroesvillains.mongo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder
@Document(collection = "groups")
public class DBGroup {

    @Id
    private String id;

    private String name;
    private String orientation;

    private List<String> members;
}
