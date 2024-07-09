# DSA-University-Management-System
Data Structure and Algorithms Assignment

# Tutorial Group Management Module

I am in charge of this module.
This repository contains the Tutorial Group Management Module, designed to manage tutorial groups and their students using a TreeMap implementation. This module includes functionality to add, remove, and modify tutorial group details and students.

## Table of Contents

- [Overview](#overview)
- [Project Structure](#project-structure)
- [Installation](#installation)
- [Usage](#usage)
- [Features](#features)
- [Authors](#authors)
- [License](#license)

## Overview

The Tutorial Group Management Module is implemented in Java and uses a custom TreeMap to store and manage students and their tutorial groups. The project is structured to follow the MVC (Model-View-Controller) pattern, ensuring a clear separation of concerns.

## Project Structure

The project is organized into the following packages and classes:

### `adt` (Abstract Data Types)

- **Files by Kam Bee Foong**:
  - `TreeMap<K extends Comparable<K>, V>`: Custom implementation of a TreeMap to store key-value pairs.
  - `MapInterface<K extends Comparable<K>, V>`: Interface defining the methods for the TreeMap.
  - `ListInterface<T>`: Interface defining the methods for a list.
  - `ArrayList<T>`: Custom implementation of an ArrayList to store elements.

### `boundary` (User Interface)

- **Files by Kam Bee Foong**:
  - `TutorialGroupMaintenanceUI`: Handles user input and output for managing tutorial groups.

### `control` (Controller)

- **Files by Kam Bee Foong**:
  - `TutorialGroupMaintenance`: Manages the logic for handling tutorial groups and students, including adding, removing, and modifying groups and students.

### `entity` (Entities)

- **Files by Kam Bee Foong**:
  - `Student`: Represents a student with properties like student ID, name, and gender.
  - `TutorialGroup`: Represents a tutorial group with properties like group ID, faculty name, and program name.

### `utility` (Utilities)

- **Files by Kam Bee Foong**:
  - `MessageUI`: Contains utility methods for displaying messages to the user.

### Other Modules

- **Files by Other Authors**:
  - Assignment teammates: Chai Jia You, Tan Hao Yang, and Tan Kok Wang.

## Installation

To get started with the project, follow these steps:

1. **Clone the repository**:
    ```bash
    git clone https://github.com/Charlotteorsalad/DSA-Assignment.git
    ```
2. **Open the project in your favorite IDE**:
    - Open IntelliJ IDEA, Eclipse, or any other Java IDE.
    - Import the project as a Java project.

## Usage

### Running the Project

1. **Navigate to the `control` package**:
    - Locate the `TutorialGroupMaintenance` class.
2. **Run the `main` method**:
    - Right-click on the `main` method in `TutorialGroupMaintenance` and select `Run`.
    - Alternatively, execute the `main` method using the IDE's run configuration.

### Interacting with the Program

1. The program will display a menu with various options for managing tutorial groups and students.
2. Follow the prompts to add, remove, find, and list students and tutorial groups.

## Features

- **Add Student to Group**: Add a student to a specific tutorial group.
- **Remove Student from Group**: Remove a student from a tutorial group.
- **Change Student's Group**: Change the tutorial group for a student.
- **Find Student in Group**: Find which tutorial group a student belongs to.
- **List Students in Group**: List all students in a specific tutorial group.
- **Filter Groups**: Filter tutorial groups based on the alphabet.
- **Generate Enrollment Report**: Generate a report of student enrollments.

## Authors

- Kam Bee Foong: Responsible for the following modules:
  - `TreeMap<K extends Comparable<K>, V>`
  - `MapInterface<K extends Comparable<K>, V>`
  - `ListInterface<T>`
  - `ArrayList<T>`
  - `TutorialGroupMaintenanceUI`
  - `TutorialGroupMaintenance`
  - `Student`
  - `TutorialGroup`
  - `MessageUI`

- Other Authors: Contributed to other modules not listed above.

## License

This project is licensed under the MIT License.

