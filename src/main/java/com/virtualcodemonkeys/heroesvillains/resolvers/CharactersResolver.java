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

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class CharactersResolver implements DataFetcher<List<Character>> {
    @Autowired
    CharactersRepository charactersRepository;

    @Autowired
    GroupsRepository groupsRepository;

    @Override
    public List<Character> get(DataFetchingEnvironment environment) {
        return getAllCharacters();
    }

    private List<Character> getAllCharacters() {
        List<DBCharacter> characters = charactersRepository.findAll();
        return characters.stream().map(c -> {
            log.info("-> Character: {}, associations: {}", c.getName(), c.getAssociations());
            List<Group> groups = getGroups(c.getAssociations());
            log.info(" .. Groups returned: ");
            groups.stream().forEach(g -> {
                log.info("   .. {}", g.getName());
            });

            return Character.builder()
                    .name(c.getName())
                    .height(c.getHeight())
                    .weight(c.getWeight())
                    .universe(c.getUniverse())
                    .orientation(c.getOrientation())
                    .friends(c.getFriends())
                    .enemies(c.getEnemies())
                    .associations(groups)
                    .build();
        })
                .collect(Collectors.toList());
    }

    private List<Group> getGroups(List<String> groupNames) {
        log.info("> getGroups() finding {} groups", groupNames.size());
        List<Group> grps = groupNames.stream().map(g -> {
            DBGroup dbGroup = groupsRepository.findByName(g);

            return Group.builder()
                    .name(dbGroup.getName())
                    .orientation(dbGroup.getOrientation())
                    .build();
        })
                .collect(Collectors.toList());
        return grps;
    }
}
