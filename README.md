# Fibonacci & Rice Grain Legend

A JavaFX desktop application for generating Fibonacci sequences and calculating the rice grain legend on a chessboard.
Fibonacci & Rice Grain Legend combines classic mathematics with a compact JavaFX user interface and demonstrates practical Java programming with a clear separation between UI and logic.

> **Portfolio project**  
> This application was created as part of my vocational retraining as an IT specialist for application development and is intended to demonstrate practical Java programming, object-oriented design, JavaFX UI development, and mathematical problem solving.

## Project Information

- **Project:** Fibonacci & Rice Grain Legend
- **Created:** 2025, as part of my vocational retraining as an IT specialist for application development
- **Technology:** Java
- **User interface:** JavaFX
- **UI layout:** FXML
- **Styling:** CSS
- **Platform:** Windows
- **JDK:** 25
- **JavaFX version:** 25
- **Author:** Toni Dietzel

## Features

### Fibonacci Sequence

- Generate a Fibonacci sequence with a user-defined number of terms
- Validation for positive integer input
- Output in a text area with the calculated values
- Support for larger values using `BigInteger`

### Rice Grain Legend

- Calculate the total number of rice grains on the entire chessboard with 64 squares
- Automatic doubling of the amount on each square
- Clear mathematical output for the classic legend problem

### User Interface

- Compact JavaFX application layout
- Fixed-size window for a simple desktop experience
- Clean separation between interface and business logic
- FXML-based structure and CSS styling

## Requirements

- Windows 10 or later
- Java Development Kit (JDK) 25
- JavaFX SDK 25 for Windows x64
- Internet access on the first startup if JavaFX is not already available locally

The project is intentionally kept simple and does not require Maven or Gradle.

## Installation and Usage

1. Download or clone this repository.
2. Open the project folder.
3. Double-click `run-app.bat`.
4. If JavaFX is not available, the script downloads the SDK and extracts it into the project folder.
5. The application compiles the Java source files and starts the JavaFX interface.

Alternatively, run the batch file from a command prompt in the project folder:

```bat
run-app.bat
```

The script checks for a compatible JDK in the following locations:

```text
C:\Program Files\Java\jdk-25.0.2
C:\Program Files\Microsoft\jdk-25.0.2.10-hotspot
```

If the JDK is installed somewhere else, update the path in `run-app.bat` accordingly.

## Project Structure

```text
FibonacciRiceApp/
├── Main.java                       JavaFX application entry point
├── FibonacciAndRiceController.java User interface event handling and input validation
├── FibonacciService.java           Fibonacci sequence calculation
├── RiceGrainService.java           Rice grain calculation
├── layout.fxml                    JavaFX layout definition
├── style.css                      Application styling
├── run-app.bat                    Compile and start the application on Windows
├── javaFx-sdk-25/                 Local JavaFX SDK directory (created automatically)
├── .gitignore                     Excludes compiled files and local SDK files
├── README.md                      Project documentation
└── LICENSE                        Optional project license file (if added later)
```

## Architecture

The application uses a simple layered structure:

- `Main` starts the JavaFX application, loads the FXML file, and attaches the stylesheet.
- `FibonacciAndRiceController` handles user input and connects the interface to the logic classes.
- `FibonacciService` contains the Fibonacci calculation logic.
- `RiceGrainService` contains the rice grain doubling calculation.
- `layout.fxml` describes the user interface declaratively.
- `style.css` defines the visual presentation.

This separation keeps the calculations independent from the UI and makes future extensions easier.

## Mathematical Background

### Fibonacci Sequence

The sequence starts with `1, 1`. Each following term is calculated by adding the two previous terms:

```text
F(n) = F(n - 1) + F(n - 2)
```

The application calculates exactly as many terms as requested by the user.

### Rice Grain Legend

The rice grain legend doubles the number of grains on every square. For the full chessboard with 64 squares, the result is:

```text
1 + 2 + 4 + ... + 2^63 = 2^64 - 1 = 18,446,744,073,709,551,615 grains
```

`BigInteger` prevents integer overflow and makes the calculation suitable for larger values as well.

## Usage

### Fibonacci Sequence

1. Enter a positive integer, for example `15`.
2. Click **Generate Fibonacci**.
3. The calculated sequence appears in the text area.

Invalid or non-positive inputs result in a clear error message.

### Rice Grain Calculation

Click **Calculate for 64 Squares**. The total number of rice grains on the full chessboard is displayed.

## Development Notes

The project demonstrates the following practical skills:

- Java classes, control flow, and object-oriented structure
- JavaFX application setup with `Application`, `Stage`, and `Scene`
- FXML-based user interface creation
- Event handling and user input validation with `@FXML`
- Use of `BigInteger` for large integer calculations
- Separation of UI logic and calculation logic with service classes
- Styling with JavaFX CSS
- Windows batch scripting for compilation and startup

## Known Limitations and Possible Extensions

- The rice grain calculation is currently fixed at 64 squares.
- The application is currently prepared for Windows and JDK 25.
- There are no automated unit or UI tests yet.

Possible next steps include allowing a user-defined number of squares, adding a visual chessboard, adding automated tests, and using Maven or Gradle for the build.

## License

No license has been added yet. All rights are reserved by the author unless a license is added to this repository.
