# FireTrack Mobile Application

## FireTrack - Wildfire Management System

The FireTrack Mobile Application is a part of the FireTrack Wildfire Management System, aimed at aiding in the management of wildfires through monitoring, early detection, and efficient response.

### Overview

The mobile application is designed for workers monitoring forest areas, providing real-time tracking and inspection capabilities. It allows users to check tracking points in the field and contributes to the system's overall efficiency in managing wildfire incidents.

### Features

- **Real-time Monitoring**: Monitor forest conditions in real-time.
- **Tracking Points Inspection**: Use mobile devices to inspect and mark tracking points in the forest.
- **Emergency Alerts**: Receive timely alerts for rapid response to wildfire incidents.
- **Fire Spread Projection**: Utilize for effective containment strategies.

### Technology

- **Programming Language**: Kotlin
- **Build Tool**: Gradle

### Installation Guide

1. **Prerequisites**:
   - Ensure Android Studio is installed on your system.
   - Have a Kotlin and Gradle compatible environment set up.

2. **Cloning the Repository**:
   - Clone the repository using `git clone https://github.com/rabeezarre/firetrack-mobile.git`.

3. **Building the Application**:
   - Open the project in Android Studio.
   - Build the project using Gradle to resolve dependencies.

4. **Running the Application**:
   - Run the application on an emulator or a physical device through Android Studio.

### Usage

Workers in the field use the app to monitor forest areas in real-time and mark tracking points. The data is synchronized with the central system for real-time updates and analysis.

### Viewing Results

- **API Endpoint**: View scanning history using the `/api/scanningHistory` endpoint at [FireTrack API](https://firetrack.cleverapps.io/swagger-ui/index.html#/).
- **Website**: Check the scanning history on the profile page at [FireTrack Website](https://firetrack.cleverapps.io/).

### Other Sub-Systems

- [**Frontend**](https://github.com/rabeezarre/firetrack-frontend): Interactive map displaying tracking points information.
- [**Backend**](https://github.com/rabeezarre/firetrack): Centralized database for web and mobile interfaces, built with Spring Boot using Java 17 and Gradle.
- [**Embedded Programming**](https://github.com/rabeezarre/firetrack-embed): Utilizes LoRaWAN protocol for scalable data sharing.

### Authors and Acknowledgment

- Author: rabeezarre ([GitHub Profile](https://github.com/rabeezarre))

