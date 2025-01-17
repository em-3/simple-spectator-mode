plugins {
    kotlin("jvm") version "1.9.23"
    id("io.github.goooler.shadow") version "8.1.7"
//    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("java")
}

group = "dev.em_3.simplespectatormode"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://hub.jeff-media.com/nexus/repository/jeff-media-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20.6-R0.1-SNAPSHOT")
    implementation("com.jeff_media:MorePersistentDataTypes:2.4.0")
}

kotlin {
    jvmToolchain(21)
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
}

tasks {
    shadowJar {
        minimize()
        relocate("com.jeff_media.morepersistentdatatypes", "dev.em_3.simplespectatormode.morepersistentdatatypes")
    }
}