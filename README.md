# Simple Spectator Mode

A simple Paper plugin to allow non-opped players to access a limited version of spectator mode.

This project was made so that I could learn more about Paper plugins, Kotlin, and Gradle.

> [!WARNING]
> This plugin was made as a hobby project for personal use. This is not intended to replace anti-cheat, nor is it meant
> to be balanced. Players using this plugin are given full access to vanilla Minecraft's spectator gamemode, meaning that
> one can still clip out of bounds underground to find structures or abuse the system in a similar way.

## Features

- Non-opped access to spectator mode
- Teleports user back to where they entered spectator mode from
- 35 block boundary

## Planned Features

- Permissions integration
- Allow overriding of the vanilla gamemode command so that clients can use the F3+N keybind to trigger this plugin
- Configurable boundary distance

## Building

Requires Java 21+ to build.

To build from source, simply clone this repository and run

```shell
./gradlew shadowJar
```

## Credits

Thanks to [@mfnalex](https://github.com/mfnalex) for
their [MorePersistentDataTypes](https://github.com/mfnalex/MorePersistentDataTypes) library which made this project
considerably easier to implement.