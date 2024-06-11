plugins {
    kotlin("jvm") version "1.9.23"
}

group = "dev.em_3.simplespectatormode"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20.6-R0.1-SNAPSHOT")
}

kotlin {
    jvmToolchain(22)
}