plugins {
    id("java")
}

group = "org.example"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    testImplementation("org.assertj:assertj-core:3.27.7")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
    systemProperty("file.encoding", "UTF-8")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.withType<JavaExec> {
    systemProperty("file.encoding", "UTF-8")
}

tasks.register<Test>("runAllSmokeTests") {
    group = "CustomTasks"
    useJUnitPlatform {
        includeTags("SMOKE")
    }
}

tasks.register<Test>("runSmokeAndDevTests") {
    group = "CustomTasks"
    useJUnitPlatform {
        includeTags("SMOKE & DEV")
    }
}