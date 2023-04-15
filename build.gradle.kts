import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.10"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"

	// kotlin-jpa plugin is enough to generate default constructors for classes annotated with @Entity
	id("org.jetbrains.kotlin.plugin.jpa") version "1.6.21"
}

group = "com.sleevesup"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.hamcrest:hamcrest-library")
	testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.0.0-RC1")

	implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.7.9")
	implementation("org.postgresql:postgresql:42.5.4")

	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
//	testImplementation("org.springframework.boot:spring-boot-starter-test")

	// logging dependencies.
	implementation("io.github.microutils:kotlin-logging-jvm:2.0.11") // kotlin-logging sl4f wrapper
	implementation("ch.qos.logback:logback-classic:1.2.6")


}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
