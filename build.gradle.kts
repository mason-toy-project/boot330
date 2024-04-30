plugins {
	java
	id("org.springframework.boot") version "3.3.0-SNAPSHOT"
	id("io.spring.dependency-management") version "1.1.4"
}

group = "com.mason.practice"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/milestone") }
	maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-validation")//For @NonNull and other validation annotation

	testImplementation("org.springframework.boot:spring-boot-starter-test")

	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("mysql:mysql-connector-java:8.0.33")
	implementation("org.hibernate.orm:hibernate-core:6.1.7.Final")
	implementation("org.hibernate.orm:hibernate-spatial:6.1.7.Final")




	//lombok
	implementation("org.projectlombok:lombok:1.18.32")
	//To enable lombok annotations in build and runtime,
	//Without specifying the annotation processor, you will get a compilation error.
	annotationProcessor("org.projectlombok:lombok:1.18.32")

}

