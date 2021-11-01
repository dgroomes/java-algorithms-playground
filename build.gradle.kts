plugins {
    java
    application
}

repositories {
    mavenCentral()
}

val guavaVersion = "31.0.1-jre" // Guava releases: https://github.com/google/guava/releases
val junitVersion = "5.8.1" // JUnit releases: https://junit.org/junit5/docs/current/release-notes/index.html
val assertJVersion = "3.21.0" // AssertJ releases: https://github.com/assertj/assertj-core/tags

application {
    mainClass.set("dgroomes.Main")
}

dependencies {
    implementation("com.google.guava:guava:$guavaVersion")

    testImplementation(platform("org.junit:junit-bom:$junitVersion"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.assertj:assertj-core:3.1.0")
}

tasks {
    test {
        useJUnitPlatform()
    }
}
