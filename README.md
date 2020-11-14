# Expose Rest Service with stander project structure along with Mapstruct, lombok etc.

The MapStruct library is used for mapping between Java bean types. By using a custom mapper with MapStruct, we can customize the default mapping methods


```
git clone https://github.com/sunilrai7607/mapstruct-friends-service.git
```

```
MAC machine (IntelliJ click on terminal) 
% chmod 777 ./gradlew
% ./gradlew clean build

```

```
curl -X GET "http://localhost:8080/api/v1/friends" -H  "accept: */*" 
```

``
Lombok Annotation
Intellij IDEA -> Preferences -> Annotation (type in search) -> check Enable Annotation Processing 
``