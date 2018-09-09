package com.virtualcodemonkeys.heroesvillains.config;

import com.virtualcodemonkeys.heroesvillains.resolvers.CharactersResolver;
import com.virtualcodemonkeys.heroesvillains.resolvers.GroupsResolver;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.File;

@Slf4j
@Configuration
public class BeanConfig {

    @Autowired
    ResourceLoader resourceLoader;

    @Autowired
    CharactersResolver charactersResolver;

    @Autowired
    GroupsResolver groupsResolver;

    @Bean
    GraphQLSchema graphQLSchema() {
        SchemaParser schemaParser = new SchemaParser();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        Resource resource = null;
        File schemaFile = null;
        TypeDefinitionRegistry typeDefinitionRegistry = null;

        try { resource = resourceLoader.getResource("classpath:models.graphqls");
        } catch (Exception exc) { log.warn("** Unable to load resource models.graphqls: {}", exc.getMessage()); }

        try { schemaFile = resource.getFile();
        } catch (Exception exc) { log.warn("** Unable to get schemaFile: {}", exc.getMessage()); }

        try { typeDefinitionRegistry = schemaParser.parse(schemaFile);
        } catch (Exception exc) { log.warn("** Unable to parse schemaFile: {}", exc.getMessage()); }

        RuntimeWiring runtimeWiring = RuntimeWiring.newRuntimeWiring()
                .type("Queries", builder -> builder
                        .dataFetcher("characters", charactersResolver)
                        .dataFetcher("groups", groupsResolver))
                .build();

        return schemaGenerator.makeExecutableSchema(typeDefinitionRegistry,runtimeWiring);
    }
}
