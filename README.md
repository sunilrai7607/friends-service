# Expose Rest Service with stander project structure along with Mapstruct, lombok etc.

The MapStruct library is used for mapping between Java bean types. By using a custom mapper with MapStruct, we can customize the default mapping methods
https://mapstruct.org/documentation/stable/reference/html/#mappers-factory

```
git clone https://github.com/sunilrai7607/mapstruct-friends-service.git
```

```
MAC machine (IntelliJ click on terminal) 
% chmod 777 ./gradlew
% ./gradlew clean build
% ./gradlew bootRun

```

```
curl -X GET "http://localhost:8080/api/v1/friends" -H  "accept: */*" 
```

``
Lombok Annotation
Intellij IDEA -> Preferences -> Annotation (type in search) -> check Enable Annotation Processing 
``
```
curl -X GET "http://localhost:8080/api/v1/vegetables" -H  "accept: */*" 
```

## MapStruct Expression or conditional

```java
@Mapper(componentModel = "spring", imports = {UUID.class})
  public interface FriendEntityMapper {    
     @Mapping(target = "firstName", source = "friendRequest.firstName")
     @Mapping(target = "lastName", source = "friendRequest.lastName")
     @Mapping(target = "emailId", source = "friendRequest.emailId")
     @Mapping(target = "address1", source = "friendRequest.address1")
     @Mapping(target = "address2", source = "friendRequest.address2")
     @Mapping(target = "zip", source = "friendRequest.zip")
     @Mapping(target = "state", source = "friendRequest.state")
     @Mapping(target = "uuid", expression = "java( UUID.randomUUID().toString() )")
     FriendEntity transform(FriendRequest friendRequest);
            
    }
```

### @AfterMapping - Populate fields based on condition
```java
@AfterMapping
default void beforeMapping(@MappingTarget FriendEntity target, FriendRequest source) {

        switch (source.getState()) {
            case "PA":
                target.setState("Pennsylvania");
                break;
            case "NJ":
                target.setState("New Jersey");
                break;
            default:
                target.setState(source.getState());
                break;

        }
    }
```


### Factory @BeanMapping
Vegetable Factory class to produce Vegetable class based on state
```java
public class VegetableFactory {

    public Vegetable createVegetable(String state) {
        switch (state) {
            case "PA":
                return new VegetablePA("Potato", 4.03);
            case "NJ":
                return new VegetableNJ("Potato", 3.13);
            default:
                return null;
        }
    }
}
```
```java

@Data
@NoArgsConstructor
public class BaseVegetable {

    private String name;

    private String state;

    public BaseVegetable(String name, String state) {
        this.name = name;
        this.state = state;
    }
}


@Data
@NoArgsConstructor
public class VegetableNJ extends BaseVegetable implements Vegetable {

    private double price;

    public VegetableNJ(String name, double price) {
        super(name, "NJ");
        this.price = price;
    }
}

@Data
public class VegetablePA extends BaseVegetable implements Vegetable {

    private double price;

    public VegetablePA(String name, double price) {
        super(name, "PA");
        this.price = price;
    }
}

```
