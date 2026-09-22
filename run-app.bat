@echo off
setlocal
cd /d "%~dp0"

REM Use the installed JDK when the old Java 21 path is unavailable.
if exist "C:\Program Files\Java\jdk-25.0.2\bin\javac.exe" (
    set "JAVA_HOME=C:\Program Files\Java\jdk-25.0.2"
) else if exist "C:\Program Files\Microsoft\jdk-25.0.2.10-hotspot\bin\javac.exe" (
    set "JAVA_HOME=C:\Program Files\Microsoft\jdk-25.0.2.10-hotspot"
) else (
    echo No supported JDK was found.
    pause
    exit /b 1
)

set "JAVAFX_VERSION=25"
set "JAVAFX_HOME=%~dp0javafx-sdk-%JAVAFX_VERSION%"
set "JAVAFX_ZIP=%TEMP%\openjfx-%JAVAFX_VERSION%.zip"

REM Download JavaFX once because it is not included in the JDK.
if not exist "%JAVAFX_HOME%\lib\javafx.controls.jar" (
    echo JavaFX SDK not found. Downloading JavaFX %JAVAFX_VERSION%...
    powershell -NoProfile -ExecutionPolicy Bypass -Command "$ProgressPreference='SilentlyContinue'; Invoke-WebRequest -Uri 'https://download2.gluonhq.com/openjfx/25/openjfx-25_windows-x64_bin-sdk.zip' -OutFile '%JAVAFX_ZIP%'"
    if errorlevel 1 (
        echo Could not download JavaFX.
        pause
        exit /b 1
    )
    powershell -NoProfile -ExecutionPolicy Bypass -Command "Expand-Archive -Path '%JAVAFX_ZIP%' -DestinationPath '%~dp0' -Force"
    if errorlevel 1 (
        echo Could not extract JavaFX.
        pause
        exit /b 1
    )
)

"%JAVA_HOME%\bin\javac.exe" --module-path "%JAVAFX_HOME%\lib" --add-modules javafx.controls,javafx.fxml *.java
if errorlevel 1 (
    echo Compilation failed. See the compiler output above.
    pause
    exit /b 1
)

"%JAVA_HOME%\bin\java.exe" --enable-native-access=javafx.graphics --module-path "%JAVAFX_HOME%\lib" --add-modules javafx.controls,javafx.fxml -cp "%CD%" Main
if errorlevel 1 (
    echo Application failed to start. See the error above.
    pause
    exit /b 1
)
endlocal