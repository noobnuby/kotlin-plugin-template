# Kotlin Plugin Template

코틀린 PaperMC Plugin 템플릿입니다.

# Library

* [MC Server Luncher](https://github.com/monun/minecraft-server-launcher)
* [Icemmand](https://github.com/gooddltmdqls/icemmand)
* [Brigadier](https://github.com/Mojang/brigadier)

# Configuration

gradle.properties

```gradle
group=com.noobnuby.plugin (group)
version=1.0.0 (ver)
paper_version=1.21.1 (papermc ver)
icemmand_version=1.21+1.0.1 (icemmand ver)
```

# Build

* `./gradlew paperJar`
* `Gradle -> Tasks -> other -> paperJar`

# Run Server

* `./start`

### It's not working!

* [READ](https://github.com/monun/minecraft-server-launcher/blob/master/README.md)
    
# License

[MIT](https://github.com/NOOBNUBY/kotlin-plugin-template/blob/master/LICENSE)