```
./gradlew clean build
```

> Task :test FAILED
> AspectOrderingTest > asyncAndSpringTransactionalOrdering() FAILED
 
Remove/Comment in build.gradle.kts this line 39

```
aspect("org.springframework.security:spring-security-aspects")
```

and then

```
./gradlew clean build
```
> BUILD SUCCESSFUL in 4s
