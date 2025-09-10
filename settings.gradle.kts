rootProject.name = "AM2"

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven("https://jenkins.usrv.eu:8081/nexus/content/repositories/releases/")
        maven {
            name = "OvermindDL1 Maven"
            url = uri("https://gregtech.overminddl1.com/")
            metadataSources {
                mavenPom()
                gradleMetadata()
                artifact()
            }
        }

        maven {
            name = "GTNH Maven"
            url = uri("https://nexus.gtnewhorizons.com/repository/public/")
        }

        maven("https://maven.fabricmc.net/")
        maven("https://maven.architectury.dev/")
        maven("https://files.minecraftforge.net/maven/")
    }
}

include("forge-1.7.10")
project(":forge-1.7.10").projectDir = file("./forge/1.7.10")
