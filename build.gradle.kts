plugins {
    java
    id("org.springframework.boot") version "4.0.6"
    id("io.spring.dependency-management") version "1.1.7"
    id("io.freefair.aspectj.post-compile-weaving") version "9.2.0"
}

group = "org.kicktipp"
version = "0.0.1-SNAPSHOT"
description = "annotationorder"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

repositories {
    mavenCentral()
}

dependencies {

    // Lombok
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    testCompileOnly("org.projectlombok:lombok")
    testAnnotationProcessor("org.projectlombok:lombok")

    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    aspect("org.springframework:spring-aspects")
    implementation("org.springframework:spring-aspects")
    implementation("org.aspectj:aspectjrt")

    // security aspects
    // UNCOMMENT and tests run fine
    aspect("org.springframework.security:spring-security-aspects")

    implementation("com.h2database:h2")

    testImplementation("org.springframework.boot:spring-boot-starter-security-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    jvmArgs("-XX:+EnableDynamicAgentLoading")
    useJUnitPlatform()
}
