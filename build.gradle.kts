plugins {
    kotlin("jvm") version "1.3.61"
    idea
}

group = "world.gregs.hestia.social"
version = "0.3.1"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(fileTree("dir" to "libs", "include" to listOf("*.jar")))

    //Main
    implementation("io.netty:netty-all:4.1.44.Final")
    implementation("org.yaml:snakeyaml:1.25")

    //Logging
    implementation("commons-io:commons-io:2.6")
    implementation("com.google.guava:guava:28.2-jre")

    //Utilities
    implementation("org.slf4j:slf4j-api:1.7.30")
    implementation("ch.qos.logback:logback-classic:1.2.3")

    //Testing
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.5.2")
    testImplementation("org.assertj:assertj-core:3.14.0")
    testImplementation("org.mockito:mockito-core:3.2.4")
    testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.2.0")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}