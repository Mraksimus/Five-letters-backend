plugins {

    kotlin("jvm") version "1.9.23"
    id("io.ktor.plugin") version "2.3.9"
    kotlin("plugin.serialization") version "1.9.22"

    id("application")

}

group = "dev.mraksimus"
version = "0.0.1"

val ktorVersion: String by project
val koinVersion: String by project
val exposedVersion: String by project

repositories {
    mavenCentral()
    maven("https://repo.h4kt.dev/releases")
}

dependencies {

    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("io.ktor:ktor-server-auth:$ktorVersion")
    implementation("io.ktor:ktor-server-content-negotiation:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")

    implementation("dev.h4kt:ktor-docs:1.3.9")

    implementation("io.insert-koin:koin-core:$koinVersion")
    implementation("io.insert-koin:koin-ktor:$koinVersion")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-hocon:1.6.2")

    implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-kotlin-datetime:$exposedVersion")
    implementation("org.jetbrains.exposed:exposed-json:$exposedVersion")

    implementation("com.h2database:h2:2.2.224")
    implementation("org.postgresql:postgresql:42.7.1")

    implementation("dev.h4kt:ktor-vk-auth:1.0.1")

    testImplementation("org.jetbrains.kotlin:kotlin-test")

}

application {
    mainClass.set("dev.mraksimus.AppKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

kotlin {
    jvmToolchain(21)
}

tasks.test {
    useJUnitPlatform()
}

tasks.getByName<JavaExec>("run") {
    workingDir = File("run")
}
