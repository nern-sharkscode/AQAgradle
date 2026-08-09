plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.microsoft.playwright:playwright:1.61.0")
    testImplementation("org.testng:testng:7.12.0")
}


tasks.test {
    useTestNG()
}