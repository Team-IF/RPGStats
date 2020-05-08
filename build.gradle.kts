plugins {
	java
    `maven-publish`
    signing
    id("org.jetbrains.dokka") version "0.10.0"
}

group = "io.teamif"
version = "0.1-SNAPSHOT"

repositories {
    maven("https://repo.maven.apache.org/maven2/")
    maven("https://dl.bintray.com/kotlin/dokka")
    maven("https://oss.sonatype.org/content/repositories/snapshots/")
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.12.2-R0.1-SNAPSHOT")
    compileOnly("org.projectlombok:lombok:1.18.12")
    annotationProcessor("org.projectlombok:lombok:1.18.12")
}

tasks {
    compileJava {
		options.encoding = "UTF-8"
		sourceCompatibility = "1.8"
		targetCompatibility = "1.8"
	}
	
	processResources {
		from("src/main/resources") {
            filter<org.apache.tools.ant.filters.ReplaceTokens>("tokens" to mapOf("version" to version))
		}
	}

    dokka {
        outputFormat = "javadoc"
        outputDirectory = "$buildDir/dokka"

        configuration {
            includeNonPublic = true
            jdkVersion = 8
        }
    }

    create<Jar>("dokkaJar") {
        archiveClassifier.set("javadoc")
        from(dokka)
        dependsOn(dokka)
    }

    create<Jar>("sourcesJar") {
        archiveClassifier.set("sources")
        from(sourceSets["main"].allSource)
    }
}

publishing {
    publications {
        create<MavenPublication>("RPGStats") {
            from(components["java"])

            artifact(tasks["sourcesJar"])
            artifact(tasks["dokkaJar"])

            repositories {
                mavenLocal()
            }

            pom {
                name.set("RPGStats")
                description.set("A vector game for education")
                url.set("https://github.com/Team-IF/RPGStats")

                licenses {
                    license {
                        name.set("GNU General Public License v2.0")
                        url.set("https://opensource.org/licenses/gpl-2.0.php")
                    }
                }

                developers {
                    developer {
                        id.set("patrick-mc")
                        name.set("PatrickKR")
                        email.set("patrickkr@teamif.io")
                        url.set("https://github.com/patrick-mc")
                        roles.addAll("developer")
                        timezone.set("Asia/Seoul")
                    }

                    developer {
                        id.set("Coder-Iro")
                        name.set("Coder Iro")
                        email.set("Coder-Iro@teamif.io")
                        url.set("https://github.com/Coder-Iro")
                        roles.addAll("developer")
                        timezone.set("Asia/Seoul")
                    }

                    developer {
                        id.set("GPLNature")
                        name.set("GPLNature")
                        email.set("GPLNature@teamif.io")
                        url.set("https://github.com/gplnature")
                        roles.addAll("developer")
                        timezone.set("Asia/Seoul")
                    }
                }

                scm {
                    connection.set("scm:git:git://github.com/Team-IF/RPGStats.git")
                    developerConnection.set("scm:git:ssh://github.com:Team-IF/RPGStats.git")
                    url.set("https://github.com/Team-IF/RPGStats")
                }
            }
        }
    }
}

signing {
    isRequired = false
    sign(tasks["jar"], tasks["sourcesJar"], tasks["dokkaJar"])
    sign(publishing.publications["RPGStats"])
}