# Project Context: MyApplication2

This is a simple Android application written in Java that displays a grid of Moroccan cities with their names and images.

## Architecture & Tech Stack
*   **Platform:** Android
*   **Language:** Java (Java 11 compatibility)
*   **UI Toolkit:** Views (XML Layouts)
*   **Build System:** Gradle (Kotlin DSL)
*   **Min SDK:** 24
*   **Target SDK:** 36

## Key Components

### 1. `MainActivity.java` (`app/src/main/java/com/example/myapplication2/MainActivity.java`)
The main entry point of the application.
*   **Functionality:**
    *   Initializes an array of city names (`villes`): Casablanca, Marrakech, Fès, Tanger, Agadir, Rabat.
    *   Initializes an array of corresponding drawable image resources (`images`).
    *   Uses a `SimpleAdapter` to bind this data to a `GridView`.
    *   Implements a custom `ViewBinder` for the `SimpleAdapter` to properly set the `ImageView` resources from integer IDs.
    *   Sets up an `OnItemClickListener` on the `GridView` to display a `Toast` message with the selected city's name when an item is tapped.
    *   Configures window insets for edge-to-edge display.

### 2. Layouts
*   **`activity_main.xml` (`app/src/main/res/layout/activity_main.xml`):**
    *   The main layout for `MainActivity`.
    *   Uses a `ConstraintLayout` as the root, containing a `LinearLayout` with a dark background (`#0d1b2a`).
    *   Contains a `GridView` (`@+id/gridVilles`) configured with 2 columns (`android:numColumns="2"`).
*   **`item_ville.xml` (`app/src/main/res/layout/item_ville.xml`):**
    *   The layout for individual items within the `GridView`.
    *   Uses a `CardView` for a card-like appearance with rounded corners and elevation.
    *   Contains an `ImageView` (`@+id/villeImage`) for the city picture and a `TextView` (`@+id/villeName`) for the city name, arranged vertically.

### 3. Resources
*   **Drawables:** The app includes image resources for the cities (e.g., `agadir.jpg`, `casablanca.jpg`, etc.) located in `app/src/main/res/drawable/`.
*   **Themes (`themes.xml`):** Uses `Theme.Material3.DayNight.NoActionBar` as the base theme.
*   **Strings (`strings.xml`):** The application name is "My Application2".

## Dependencies
The project uses standard AndroidX libraries including:
*   `appcompat`
*   `material` (Material Design Components)
*   `activity`
*   `constraintlayout`
