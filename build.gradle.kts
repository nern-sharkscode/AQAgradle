plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"
val agent by configurations.creating

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.microsoft.playwright:playwright:1.61.0")
    testImplementation("org.testng:testng:7.12.0")
    implementation("org.apache.logging.log4j:log4j-api:2.23.1")
    implementation("org.apache.logging.log4j:log4j-core:2.23.1")
    testImplementation("io.qameta.allure:allure-testng:2.27.0")
    agent("org.aspectj:aspectjweaver:1.9.22")
}


tasks.test {
    jvmArgs("-javaagent:${agent.singleFile.absolutePath}")
    useTestNG {
        suites("testng.xml")
    }
}