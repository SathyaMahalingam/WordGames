# Word Game
    This application lets you to find out the possible three letter words available in the word board.
    User can refresh the word board anytime using refresh icon on the right side top of the screen.
    User can scan and view the list of three letter words available in the word board by tapping onto the scan button.
    It takes user to the next screen which list the words available on the word board.
    Scanning finds out only three letter words available in horizontal left and right directions.
# Getting Started
    These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.
# Prerequisites
    The following components must be installed in order to go through the Usage Instructions.
    * Gradle Build Tool.
    * Latest release of the Java JDK version 8.
    * Git client.
    * Android Studio version 3.5.2.
    * Android SDK with the API level 21 or later.
# Setting up
    Assuming your project is in a folder named "Project" on your Desktop.
    * Determine your SSH clone url. On Github it's probably something like git@github.com:USERNAME/PROJECT.git. Should be on the project's page.   cd ~/Desktop   git clone {{the link you just copied}} Project
    * This creates a directory named "Project", clones the repository there and adds a remote named "origin" back to the source.   cd Project  git checkout develop
    * If that last command fails   git checkout -b develop
    # Android Studio as your main IDE
    * The recommended IDE for Android development is Android Studio because it is developed and constantly updated by Google, has good support for Gradle, contains a range of useful monitoring and analysis tools and is fully tailored for Android development.
    * Avoid adding Android Studio's specific configuration files, such as .iml files to the version control system as these often contain configurations specific of your local machine, which won't work for others.
#Installation
    * Open Android Studio and select the "Import project" menu item in the welcome screen.
    * Navigate to the location where you checked out the repository in your computer, and select the debug folder.
    * Android Studio should be able to import the project automatically, which includes the library itself and a minimal test app.
# Running the tests
   You can run the test cases using run button enabled on each test cases
   Used Espresso UI testing and Mockito for Unit Testing
# Versioning
    Version 0.0.1
    * Published Word Game Application
# Contributing
    * Fork it
    * Create your feature branch (git checkout -b my-new-feature)
    * Commit your changes (git commit -am 'Added some feature')
    * Push to the branch (git push origin my-new-feature)
    * Create a new pull request
    * Update the change log with new version
# Authors
    *  Sathya Mahalingam - Initial work
# Releasing
    * Create a feature branch as normal.
    * Update the version history in the README.md file
    * Update this to develop as normal.
    * git checkout master
    * git merge --no-ff develop
    * git push origin master
    * git tag v1.0.0
    * git push origin v1.0.0

