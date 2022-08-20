plugins {
    id("java")
}

group = "dokerplp"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    implementation("jakarta.xml.bind:jakarta.xml.bind-api:4.0.0")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}