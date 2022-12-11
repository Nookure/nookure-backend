plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "4.0.4"
    application
}

group = "es.angelillo15"
version = "1.0"
val run = "es.angelillo15.Main"
repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

application {
    mainClass.set(run)
}

project.setProperty("mainClassName", "es.angelillo15.Main")

// set source and target compatibili

tasks.shadowJar {
    archiveFileName.set("Nookure-backend.jar")
    relocate("org.simpleyaml", "es.angelillo15.minearte.libs.simpleyaml")
    relocate("org.yaml", "es.angelillo15.minearte.libs.yaml")
    relocate("es.angelillo15.configmanager", "es.angelillo15.minearte.libs.config.manager")
    relocate("es.angelillo15.minearte", "es.angelillo15.minearte.libs.minearte")
    relocate("com.google.gson", "es.angelillo15.minearte.libs.google.gson")
    relocate("com.mashape.unirest", "es.angelillo15.minearte.libs.mashape.unirest")
    relocate("net.sf", "es.angelillo15.minearte.libs.net.sf")
    relocate("mozilla", "es.angelillo15.minearte.libs.mozilla")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}


dependencies {
    implementation("io.javalin:javalin:5.2.0")
    implementation("com.github.Angelillo15:ConfigManager:1.2")
    implementation("org.yaml:snakeyaml:1.33")
    implementation("me.carleslc.Simple-YAML:Simple-Yaml:1.8.1")
    implementation("com.mashape.unirest:unirest-java:1.4.9")
    implementation("com.google.code.gson:gson:2.9.0")
    implementation("org.slf4j:slf4j-simple:2.0.3")
}