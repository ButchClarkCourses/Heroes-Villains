package com.virtualcodemonkeys.heroesvillains.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface GroupsRepository extends MongoRepository<DBGroup, String> {

    DBGroup findByName(String name);
}
