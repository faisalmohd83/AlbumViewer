## Welcome to the AlbumViewer wiki!

### Prerequisites
* AndroidStudio 3.5 or later
* Java JDK 1.8
* Kotlin 1.3.50
* Android SDK minimum API level 22

### Libraries used

* RetroFit - Retrofit is a REST Client library (Helper Library), Type-safe HTTP client for Android and Java by Square, Inc., used in Android and Koltin to create an HTTP request and also to process the HTTP response from a REST API.

* Gson - Gson is a Java library that can be used to convert Java Objects into their JSON representation. It can also be used to convert a JSON string to an equivalent Java object. Gson can work with arbitrary Java objects including pre-existing objects that you do not have source-code of.

### Android components

- RecyclerView - Used to list the Albums.
- Constraintlayout - Simple, flat hierarchies in a layout.
- Synthetic Binding(Kotlin) - bind the data with UI, wonder not if **findViewById()** missing.

### [Android Architecture Components](https://developer.android.com/topic/libraries/architecture/)([Android Jetpack](https://developer.android.com/jetpack/))
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - allows data to survive configuration changes such as screen rotations.
- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)   - lifecycle-aware data holder class to respects the lifecycle Fragments.
- [Room Persistence Library ](https://developer.android.com/topic/libraries/architecture/room) - Jetpack wrapper for Android sqlite database operations.
- [AndroidX](https://developer.android.com/jetpack/androidx/) - Complete project implemented using AndroidX libraries.

### Workflow of the application
The app name is **AlbumViewer**. 
Once installed it can be found in the phone with a **Music** icon.

### Implementation

1. The App is designed to list all the albums from the [JSONPlaceholder](https://jsonplaceholder.typicode.com/)by calling intended API endpoint with filter(album). The UI implemented as LinearLayout(RecycleView) to showcase the album list.
2. The App list all the Album retrieved from data repository using Room, used for **Offline** capability.
3. The network call is performed using Retrofit2 in conjunction with Gson converter, expects to convert the results to be mapped onto Kotlin data classes using Gson converter.
4. ViewModel in combination with LiveData helps the data to survive view lifecycle changes.

### Design
- The application is based on MVVM pattern. 
In MVVM architecture, Views react to changes in the ViewModel without being called explicitly.
- The API requests are made using retrofit.
- The Gson is used conjunction retrofit to parser results onto Kotlin data classes.
- The ViewModel interacts with a data repository(Using Room) to get the data and updates the View.
- The data source manages the data to be fetched from the data repository on UI scrolls.
- The ViewModel delegates all the requests from the view to the repository and vice versa.
- The RecylerView is used instead of normal listview.

### Further enhancements
- No data/ limited network scenario to handled with progressbar.
- Improved pagination with Jetpack's new pagination library.
- Improving the data source fetch using [Paging With Database And Network](https://github.com/googlesamples/android-architecture-components/tree/master/PagingWithNetworkSample#paging-with-database-and-network)
- furthurmore, the refractoring is an endless thought.
