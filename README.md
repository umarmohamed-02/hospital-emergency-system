# Mini Hospital Emergency Management System

A Java console application that simulates hospital emergency management using core data structures, built for the CIT300 - Data Structures and Algorithms assignment.

## Overview

This system manages patient records, emergency treatment queues, treatment history, and patient visit history using four fundamental data structures, each implemented from scratch.

## Data Structures Used

| Component        |      Data Structure          |         Purpose                                             |
|----------------- |------------------------------|-----------------------------------------------------------|
| Patient Records  |     Binary Search Tree (BST) | Store and retrieve patients by Patient ID in sorted order |
| Emergency Queue  |     Queue (FIFO)             | Manage patients waiting for emergency treatment |
| Treatment History|     Stack (LIFO)             | Track completed treatments, most recent first |
| Patient Visit History| Singly Linked List       | Store each patient's past hospital visits |

## Project Structure

```
hospital-emergency-system/
├── src/
│   └── hospital/
│       ├── model/
│       │   └── Patient.java
│       ├── structures/
│       │   ├── PatientBST.java
│       │   ├── EmergencyQueue.java
│       │   ├── TreatmentStack.java
│       │   └── VisitLinkedList.java
│       └── Main.java
└── README.md
```

## Features

**Patient Records (BST)**
- Insert, search, and delete patients by Patient ID
- Display all patients in ascending order (in-order traversal)

**Emergency Queue**
- Enqueue new patients into the waiting queue
- Dequeue the next patient for treatment (FIFO)
- Display all patients currently waiting

**Treatment History (Stack)**
- Push a completed treatment record
- Pop the most recently completed record
- Display full treatment history (LIFO order)

**Patient Visit History (Linked List)**
- Add a new visit record
- Remove a visit by Visit ID
- Search for a visit by Visit ID
- Display full visit history

## How to Run

1. Navigate to the `src` folder:
   ```
   cd src
   ```
2. Compile all files:
   ```
   javac hospital/model/Patient.java hospital/structures/*.java hospital/Main.java
   ```
3. Run the program:
   ```
   java hospital.Main
   ```
4. Use the on-screen menu (0-14) to interact with the system.

## Author

Developed by Umar Mohamed for CIT300 - Data Structures and Algorithms.