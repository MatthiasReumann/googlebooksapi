val ktorVersion: String = "1.6.2"

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.5.30-M1"
    `maven-publish`
    `java-library`
}

group = "com.github.MatthiasReumann"
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    testImplementation(kotlin("test"))

    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-cio:$ktorVersion")
    implementation("io.ktor:ktor-client-gson:$ktorVersion")
}

tasks {
    val sourcesJar by creating(Jar::class) {
        archiveClassifier.set("sources")
        from(sourceSets.main.get().allSource)
    }

    val javadocJar by creating(Jar::class) {
        dependsOn.add(javadoc)
        archiveClassifier.set("javadoc")
        from(javadoc)
    }

    artifacts {
        archives(sourcesJar)
        archives(javadocJar)
        archives(jar)
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            pom {
                name.set("googlebooksapi")
                description.set("A Kotlin Wrapper of the Google Books APIs")
                url.set("https://github.com/MatthiasReumann/googlebooksapi")
            }
        }
    }
}
