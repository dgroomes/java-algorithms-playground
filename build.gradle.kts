plugins {
    java
    application
}

repositories {
    mavenCentral()
}

application {
    mainClass.set("dgroomes.Main")
}

dependencies {
    testImplementation("junit:junit:4.12")
    testImplementation("org.assertj:assertj-core:3.1.0")
    testImplementation("nl.jqno.equalsverifier:equalsverifier:1.7.5")
}
