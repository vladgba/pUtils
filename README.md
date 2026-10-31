# pUtils

A pocket toolbox built on your phone's sensors: **compass, spirit level, on-screen ruler, GPS speedometer and a live sensor monitor**. Sensors run only for the tool you are looking at.

## Features

- **Compass.** A rotating dial with heading and cardinal point. Held upright, it switches to a horizon view that projects directions onto what the camera faces. Tap to switch between magnetic and true north.
- **Level.** Flat on a surface it shows a round bubble with X/Y tilt; standing on an edge it becomes a tube level. Tap to calibrate, long-press to reset.
- **Ruler.** Real-size scales along the screen edges (mm/cm or inches) and three measuring shapes: line, triangle (sides, angles, area) and rectangle. Calibrate it with a bank card.
- **GPS.** Speed with an arc gauge, coordinates (decimal or DMS), altitude, accuracy, bearing, satellites, maximum speed and trip distance. Tap the speed to change units.
- **Sensors.** Live graphs for the accelerometer, gyroscope, magnetometer, light, proximity, barometer and more, plus a list of every sensor on the device.
- **No ads, no network, no data collection.**

## Permissions

| Permission | Why | Required |
|---|---|---|
| Location (precise / approximate) | GPS tab, and the true-north correction of the compass | Optional |

The other tools work without any permission.

### Notes

- The screen stays on while the app is open.
- Gestures for every tool are listed in the [guide](docs/GUIDE.md).

## Build

Requires Android 7.0+ (API 24). Built with Kotlin on the plain Android framework, without libraries.

```bash
./gradlew assembleRelease
```

The APK is written to `app/build/outputs/apk/release/`.
