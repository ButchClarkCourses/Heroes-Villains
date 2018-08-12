# Heroes and Villains project

This is the project for Heroes and Villains.  It accompanies the Udemy course "GraphQL with Spring Boot".

## Branches

Different stages of this project will be saved in various branches.

## Project Structure
The main packages for this project are as follows:

### config
  This package contains Spring Bean definitions.  The main bean will return a GraphQLSchema object.
  
### controllers
  This package holds a simple REST controller.  The purpose is to show that REST and GraphQL can easily live together in harmony.
  
### models
   The models package contains all the Java Model classes used in the project, including models for 
   GraphQL, REST endpoints, and MongoDB access.
   
### repos
   This package contains repository classes/interfaces that aide in the movement of data between our application and back-end datasources.
  
### resolvers
   The resolvers package contains all the GraphQL Resolver classes that will gather data and return to the graphql-java library to be packaged for client responses.
   
   