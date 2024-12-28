import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "2.1.0"
	id("com.gradleup.shadow") version "9.0.0-beta4"
	id("xyz.jpenilla.run-paper") version "2.3.1"
}

group = property("group")!!
version = property("version")!!

val paper_version: String by project

repositories {
    mavenCentral()
    mavenLocal()
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://jitpack.io")
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
    compileOnly("io.papermc.paper:paper-api:${paper_version}-R0.1-SNAPSHOT")
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21

    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}

kotlin {
    jvmToolchain(21)
}

tasks {
    withType<JavaCompile> {
        options.encoding = "UTF-8"
    }

    withType<KotlinCompile> {
        compilerOptions {
            noJdk = false
            jvmTarget.set(JvmTarget.JVM_21)
        }
    }

    processResources {
        filesMatching("plugin.yml") {
            expand(project.properties)
        }
    }

    create<Jar>("paperJar") {
        archiveBaseName.set(rootProject.name)
        archiveClassifier.set("")

        from(sourceSets["main"].output)

        doLast {
            copy {
                from(archiveFile)
                into(File(rootDir, "run/plugins/"))
            }
        }
    }

	runServer {
		minecraftVersion("1.21.4")
	}
}