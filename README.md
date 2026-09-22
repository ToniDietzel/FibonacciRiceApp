# Fibonacci & Rice Grain Legend

A small JavaFX desktop application that demonstrates two classic mathematical examples:

- Generate a Fibonacci sequence with a user-defined number of terms
- Calculate the number of rice grains on 32 squares of a chessboard

This project was created as part of my retraining to become an IT specialist for application development. It demonstrates my first practical experience with Java, JavaFX, FXML, and a basic separation between the user interface and application logic.

**First created:** 2025-10-24  
**Author:** Toni Dietzel

## Overview

The application has two sections:

1. In the Fibonacci section, the user enters a positive number. After clicking **Generate Fibonacci**, the sequence is displayed in the output field.
2. In the rice grain legend section, **Calculate for 32 Squares** calculates the total number of rice grains on the first half of a chessboard.

The user interface is intentionally compact and designed for a fixed window size.

## Technical Overview

| Area | Implementation |
| --- | --- |
| Programming language | Java |
| User interface | JavaFX |
| UI layout | FXML |
| Styling | CSS |
| Number handling | `BigInteger` for arbitrarily large integers |
| Startup | Windows batch file `run-app.bat` |

### Project Structure

```text
.
├── Main.java                       # JavaFX application entry point
├── FibonacciAndRiceController.java # User interface event handling
├── FibonacciService.java            # Fibonacci sequence calculation
├── RiceGrainService.java            # Rice grain calculation
├── layout.fxml                     # User interface layout
├── style.css                       # Colors and styling
├── run-app.bat                     # Compile and run on Windows
└── README.md
```

## Mathematical Background

### Fibonacci Sequence

The sequence starts with `1, 1`. Each following term is calculated by adding the two previous terms:

```text
F(n) = F(n - 1) + F(n - 2)
```

The application outputs exactly as many terms as specified in the input field.

### Rice Grain Legend

In the rice grain legend, the number of grains doubles on every square. For 32 squares, the result is:

```text
1 + 2 + 4 + ... + 2^31 = 2^32 - 1 = 4,294,967,295 grains
```

`BigInteger` prevents integer overflow and makes the calculation suitable for much larger values as well.

## Requirements

- Windows
- JDK 25
- JavaFX SDK 25 for Windows x64
- Internet access on the first launch if the JavaFX SDK is not already in the project folder

The project currently uses a simple file and batch-based structure and does not require Maven or Gradle.

## Running the Application

1. Clone the repository or download it as a ZIP file.
2. Double-click `run-app.bat`.
3. If JavaFX is not available, the script downloads the SDK and extracts it into the project folder.

Alternatively, run the batch file from a command prompt in the project folder:

```bat
run-app.bat
```

The script looks for a suitable JDK installation at:

```text
C:\Program Files\Java\jdk-25.0.2
C:\Program Files\Microsoft\jdk-25.0.2.10-hotspot
```

If the JDK is installed somewhere else, update `run-app.bat` accordingly.

## Publishing on GitHub

For the first publication, create an empty repository on [GitHub](https://github.com). Then publish the project from its folder using Git:

```bat
git init
git add .
git commit -m "Initial version of the Fibonacci and rice grain application"
git branch -M main
git remote add origin https://github.com/YOUR-USERNAME/FibonacciRiceApp.git
git push -u origin main
```

Replace `YOUR-USERNAME` and the repository name with your own values. When creating the GitHub repository, do not automatically add another README or license so that the existing files can be uploaded without a conflict.

The `.gitignore` file prevents compiled Java files, IDE settings, and the locally used JavaFX SDK from being published.

## Usage

### Fibonacci Sequence

1. Enter a positive integer, for example `15`.
2. Click **Generate Fibonacci**.
3. The calculated sequence appears in the text area.

Invalid or non-positive inputs result in a clear error message.

### Rice Grain Calculation

Click **Calculate for 32 Squares**. The total for the first 32 chessboard squares is then displayed.

## Architecture

The application uses a simple layered structure:

- `Main` starts JavaFX, loads the FXML file, and attaches the stylesheet.
- `FibonacciAndRiceController` handles user input and connects the interface to the services.
- `FibonacciService` contains the Fibonacci sequence logic.
- `RiceGrainService` contains the rice grain doubling logic.
- `layout.fxml` declaratively describes the user interface.
- `style.css` contains the visual styling.

This separation keeps the calculations independent from the user interface and makes future extensions or tests easier.

## What I Learned

- Building a JavaFX application with `Application`, `Stage`, and `Scene`
- Connecting FXML elements with controller methods using `@FXML`
- Separating user interface code from application logic with service classes
- Processing and validating user input
- Using `BigInteger` for large integer calculations
- Styling a user interface with JavaFX CSS
- Automating compilation and startup with a Windows batch file

## Known Limitations and Possible Extensions

- The rice grain calculation is currently fixed at 32 squares.
- The application is currently prepared for Windows and JDK 25.
- There are no automated unit or UI tests yet.

Possible next steps include allowing a user-defined number of squares, adding a graphical chessboard, adding automated tests, and using Maven or Gradle for the build.

## License

This project was created for learning and demonstration purposes. A license can be added once the conditions for reusing the source code have been decided.