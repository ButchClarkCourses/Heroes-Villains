package com.virtualcodemonkeys.heroesvillains.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CharactersRepository extends MongoRepository<DBCharacter, String> {
}
