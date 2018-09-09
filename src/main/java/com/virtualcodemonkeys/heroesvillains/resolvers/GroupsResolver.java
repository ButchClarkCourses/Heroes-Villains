package com.virtualcodemonkeys.heroesvillains.resolvers;

import com.virtualcodemonkeys.heroesvillains.models.Character;
import com.virtualcodemonkeys.heroesvillains.models.Group;
import com.virtualcodemonkeys.heroesvillains.mongo.CharactersRepository;
import com.virtualcodemonkeys.heroesvillains.mongo.DBCharacter;
import com.virtualcodemonkeys.heroesvillains.mongo.DBGroup;
import com.virtualcodemonkeys.heroesvillains.mongo.GroupsRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class GroupsResolver implements DataFetcher<List<Group>> {
    @Autowired
    GroupsRepository groupsRepository;

    @Autowired
    CharactersRepository charactersRepository;

    @Override
    public List<Group> get(DataFetchingEnvironment environment) {
        List<DBGroup> dbGroups = groupsRepository.findAll();

        return dbGroups.stream().map(g -> {
            return Group.builder()
                    .name(g.getName())
                    .orientation(g.getOrientation())
                    .members(getMembers(g.getMembers()))
                    .build();
        })
                .collect(Collectors.toList());
    }

    private List<Character> getMembers(List<String> names) {
        List<Character> members = new ArrayList<>();
        return names.stream().map(n -> {
            DBCharacter character = charactersRepository.findByName(n);
            return Character.builder()
                    .name(character.getName())
                    .height(character.getHeight())
                    .weight(character.getWeight())
                    .universe(character.getUniverse())
                    .orientation(character.getOrientation())
                    .friends(character.getFriends())
                    .enemies(character.getEnemies())
                    .build();
        })
                .collect(Collectors.toList());
    }

}
