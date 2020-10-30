# HackerNews

Simple application requested by REIGN as technical test.

## Installation guide
1) If you haven't Android Studio on your computer, download the lasted version in the official download [site](https://developer.android.com/studio).
2) You can download this project via git:
   1) First open your favorite terminal and type:
 ```git clone https://github.com/jkhin/hacker-news.git``` to clone the project or download it directly from the repo and unzip it on your workspace folder.

3) Open the project in Android Studio.
4) Connect an Android Device, wait to make Android Studio recognize it and it will appear on this section.
![device list](https://developer.android.com/studio/images/run/deploy-run-app.png)
5) Then click **Run** ![RunIcon](https://developer.android.com/studio/images/buttons/toolbar-run.png)
6) And enjoy the App!


Or, if you're familiarized with the command prompt, you can install it open your terminal and:
1) Go to the root folder of the project: ```cd my/root/project/folder/```
2) Make sure that your Android device is connected
3) Then type: ```./gradlew installDebug```
4) Wait until gradle finishes the compiling and enjoy!


## Project Structure

This is the project structure:
- **app**: Main module where is developed the features. Inside this module you will notice that it has the next structure:
  1) **core**: this package contains networkings' configuration, utils and other stuff that could give support to the whole project.
  2) **di**: here is declared the dependency injection setup for the application.
  3) **features**: where are the magic is made! Each feature will be defined here and it will contains its own Clean Architecture Structure.
      1) presentation: where the UI logic is defined.
      2) domain: Domain module contains all the entities, usecases, repositories interfaces.
      3) data: Data module contains the database(Room) and DAO, DataMappers, Data Entities, Repositories implementation and DataStore.


- **buildSrc**: This is not a module itself, this is just a kotlin-dsl that provides all the dependencies for our gradle files. Of course, we use kotlin-dsl to build the project.

### Third Parties:
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel): The ViewModel class is designed to store and manage UI-related data in a lifecycle conscious way.
- [ROOM](https://developer.android.com/topic/libraries/architecture/room): The Room persistence library provides an abstraction layer over SQLite.
- [Navigation](https://developer.android.com/guide/navigation):  Navigation refers to the interactions that allow users to navigate across, into, and back out from the different pieces of content within your app.
- [Moshi](https://github.com/square/moshi): to serialize and deserialize the JSON in a better and simpler way.
- [Retrofit](https://square.github.io/retrofit/): A type-safe HTTP client for Android and Java.
- [Coroutines](https://developer.android.com/kotlin/coroutines): A coroutine is a concurrency design pattern that you can use on Android to simplify code that executes asynchronously.
- [Koin](https://insert-koin.io/): A pragmatic lightweight dependency injection framework for Kotlin developers.

