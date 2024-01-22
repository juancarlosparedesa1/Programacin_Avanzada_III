plugins {
    id("java")
}

group = "org.example"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":Ejemplo01"))
}

tasks.test {
    useJUnitPlatform()
}