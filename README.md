# To-Do App Task

This is a **native Android application** developed using Java and SQLite to help users manage their daily tasks efficiently. The app allows users to create, view, update, and delete tasks with customizable attributes such as title, description, priority, type, and date.

## Key Features

- **Add Task**: Users can create a new task by filling out the required fields.
- **View Tasks**: Display a list of all tasks with key details such as title, description, type, priority, and date.
- **SQLite Integration**: All task data is stored locally in a SQLite database.
- **RecyclerView**: Efficiently displays tasks in a scrollable list.
- **Customizable Types**: Includes predefined types like *Personal*, *Work*, *Shopping*, and *Others*.
- **Material Design**: User-friendly UI with a clean and modern design.

## Technologies Used

- **Programming Language**: Java
- **Database**: SQLite (local database)
- **UI Components**: RecyclerView, CardView
- **IDE**: Android Studio
- **Version Control**: GitHub

## File Structure

### App Logic

- **`MainActivity`**: Handles navigation and UI for adding tasks.
- **`TodoAdapter`**: Custom adapter for displaying tasks in a RecyclerView.
- **`DatabaseHelper`**: Manages SQLite database operations such as CRUD operations.

### XML Layouts

- **`activity_main.xml`**: Main screen layout for task entry.
- **`item_todo.xml`**: Layout for individual task items in the RecyclerView.

### Resources

- **`styles.xml`**: Defines the app theme and custom styles.
- **`colors.xml`**: Holds the color scheme for the app.
- **`strings.xml`**: Stores all text strings for localization.

## How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/sumonJP/To-Do-App-Task.git
   ```
2. Open the project in **Android Studio**.
3. Build the project to download all dependencies.
4. Run the app on an emulator or a physical device.

## Screenshots

Include screenshots of the app, such as:

- **Task Entry Screen**
- **Task List**
*(Add images here for better visual representation.)*

## Future Enhancements

- Add a search feature for tasks.
- Integrate cloud storage for syncing tasks across devices.
- Add reminders and notifications for due tasks.

## License

This project is open-source and available under the [MIT License](https://opensource.org/licenses/MIT).

---

Feel free to add any specific sections or details that are unique to your project!
