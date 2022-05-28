# Weather Sample App
Sample app for fetching weather status updates for user's current location and a favorite list of cities.

# Features
- Display the weather data for the user's current location.
- List of weather data for 7 upcomming days.
- Search weather data for any city.
- Add a city to a favorite list.
- View a list of favorite cities.

# Main Characteristics
- Multi module project: create module for each business requirement to use them as plug and play features.
- MVI Pattern: Model-View-Intent to manage the relation between user actions and screen state and fulfil the UDF (Uni Directional Data Flow)
- Clean Architecture: split code into three layers:
  1. Data: deal with the app data source.
  2. Domain: descripe application business logic.
  3. Presentation: handle user interactions and display results on app screens.

# Used Technologies
- Kotlin
- Coroutines and Kotlin Flow
- UI: Jetback Compose
- Network: Retrofit
- Database: Room
- Json serialisation: Moshi
- Dependency Injection: Koin
- API: OpenWeatherMap API

# Screenshots
![Screenshot_20220529-000554](https://user-images.githubusercontent.com/35328872/170843027-4bff4832-0b5b-46a4-bd60-ca4c223c5e04.jpg)
![Screenshot_20220529-000611](https://user-images.githubusercontent.com/35328872/170843022-98412e61-1913-42c4-ad61-1ed86f50cf8e.jpg)
![Screenshot_20220529-000718](https://user-images.githubusercontent.com/35328872/170843017-42c9d255-46ba-449f-a014-d0f343bbf3e4.jpg)
![Screenshot_20220529-000709](https://user-images.githubusercontent.com/35328872/170843019-05aa5fec-bd61-45be-8e4c-3373efaea152.jpg)
![Screenshot_20220529-000619](https://user-images.githubusercontent.com/35328872/170843021-3bdc89e3-0358-4a18-b38d-fedbaf434d69.jpg)

