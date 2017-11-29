Initialised at <http://start.spring.io>

# Setup

```sh
docker-compose -f docker-compose-es.yml up -d
mvn clean
mvn install
mvn spring-boot:run -Dserver.port=8080
```

- Users url: <http://localhost:8080/api/users>
- Swagger ui: <http://localhost:8080/swagger-ui.html>

# Sprint boot

Annotation  | Meaning
----------- | -----------------------------------------------------------------------------------------------------
@Component  | generic stereotype for any Spring-managed component
@Repository | stereotype for persistence layer (DAO)
@Service    | stereotype for service layer: Hold business Logic, Calculations etc
@Controller | stereotype for presentation layer (spring-mvc): dispatching, forwarding, calling service methods etc.

## @Repository

This is to indicate that the class defines a data repository.

What's special about @Repository?

In addition to pointing out that this is an Annotation based Configuration, @Repository's job is to catch Platform specific exceptions and re-throw them as one of Spring's unified unchecked exception. And for this, we're provided with PersistenceExceptionTranslationPostProcessor, that we are required to add in our Spring's application context like this:

```java
<bean class="org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor"></bean>
```

This bean post processor adds an advisor to any bean that's annotated with @Repository so that any platform-specific exceptions are caught and then rethrown as one of Spring's unchecked data access exceptions.

## @Controller

The @Controller annotation indicates that a particular class serves the role of a controller. The @Controller annotation acts as a stereotype for the annotated class, indicating its role.

What's special about @Controller?

We cannot switch this annotation with any other like @Service or @Repository, even though they look same. The dispatcher scans the classes annotated with @Controller and detects @RequestMapping annotations within them. We can only use @RequestMapping on @Controller annotated classes.

## @Service

@Services hold business logic and call method in repository layer.

What's special about @Service?

Apart from the fact that it is used to indicate that it's holding the business logic, there's no noticeable speciality that this annotation provides, but who knows, spring may add some additional exceptional in future.

What else? Similar to above, in future Spring may choose to add special functionalities for @Service, @Controller and @Repository based on their layering conventions. Hence its always a good idea to respect the convention and use them in line with layers.

## Links

- <https://patrickgrimard.io/2016/01/18/spring-boot-devtools-first-look/>
- <https://patrickgrimard.io/2014/08/14/how-to-build-a-spring-boot-application-using-intellij-idea/>
- <https://docs.spring.io/autorepo/docs/spring-data-jpa/current/api/org/springframework/data/jpa/repository/support/SimpleJpaRepository.html>
- <https://www.callicoder.com/spring-boot-rest-api-tutorial-with-mysql-jpa-hibernate/>
- <https://github.com/eugenp/tutorials/tree/master/spring-security-rest>
