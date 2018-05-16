# School Registration System

## Overview

The driving force behind this project for me was organization and flexibility. I approached this problem by initially ignoring the specific tasks required by the assignment and building a program that could be used for various purposes, then implementing the assignment requirements last. This was a large program that needed to be broken down into small, organized parts. I did my best to prioritize readability wherever possible. I encapsulated data wherever possible and implemented factories so users could choose which algorithm to run, or create their own and implement it without hassle. This program, in general, is broken down into five pieces: Classes that store information, Classes that contain algorithms, Classes for text input, Classes for text output, and a Main class.

## Part 1: Classes that Store Information

The classes *Address*, *Person*, *Student*, *Faculty*, *Course*, *CourseSession*, *IdGenerationParameters*, and *ScheduleParameters* all store important data.

* **Address**: Stores a street address, city, state, and zipcode
* **Person**: Stores a first name, last name, email, phone number, address, and id number
* **Student**: Extends Person and also stores a date of birth, gpa, and date enrolled
* **Faculty**: Extends Person and also stores a date hired, and a boolean variable isTenured
* **Course**: Stores a department, code, description, minimum number of students, and maximum number of students
* **CourseSession**: Stores a course base, arraylist of students, faculty member, and session id
* **IdGenerationParameters**: Stores the parameters for generating id's, such as which algorithm to use and a min and max value
* **ScheduleParameters**: Stores parameters for generating a schedule, such as which algorithm to use, the number of sessions per course, the number of sessions per student, and number of sessions per faculty member

These classes all have several overloaded constructors allowing for different types of input, as well as getters and setters for every data field.

## Part 2: Classes that contain Algorithms

The classes *IdFactory*, *ScheduleFactory*, *OrderedIdGenerator*, *RandomIdGenerator*, *DummyScheduleAlgorithm*, and *SmartScheduleAlgorithm* all contain algorithms for two main purposes:

* ID Generation (implement the **IdGenerator** interface)
  * **IdFactory**: Determines based on a parameter which algorithm to use.
    * This provides flexibility because a user can easily define another algorithm class and only change a few lines of code to be able to use it
    * I created two algorithms to demonstrate this flexibility
  * **RandomIdGenerator**: Generates a random, unique id number within a given set of bounds
    * It is unique because the nextInt() method checks an ArrayList of previously used id numbers
  * **OrderedIdGenerator**: First generates a random id within a given set of bounds, then increments the id number to generate an ordered set
    * This is useful if a user wants to keep track of which students were registered first
* Scheduling Algorithms (implement the **ScheduleAlgorithm** interface)
  * **ScheduleFactory**: Determines based on a parameter which algorithm to use
    * This is flexible for the same reasons as IdFactory
    * I also created two algorithms to demonstrate this
  * **DummyScheduleAlgorithm**: References a faculty member's list of courses that they can teach and a student's list of courses they want to take and assigns based on a first come / first serve basis
  * **SmartScheduleAlgorithm**: Does the same as DummyScheduleAlgorithm but first sorts students based on seniority and gpa to allow for priority access to desired classes.

## Part 3: Classes for Text Input
The classes *StudentReader*, *FacultyReader*, *CourseReader*, *IdParameterReader*, and *ScheduleParameterReader* are all made for receiving data from a text file

These classes generally have the same structure:
> * A single method that takes a pathname as a parameter
    * This allows for flexibility in file names / paths
> * A single try block surrounds the method as data is read in line by line
> * This method returns an ArrayList of user defined objects
> * Two types exceptions are caught and thrown back with a message containing the pathname
  * This is done so the main method can handle the exceptions with flexibility and identify which file caused the exception

### Input Format

* Students / Faculty
  * The StudentReader and FacultyReader classes have methods that read input one line at a time. They are written to expect data that looks like this:
  * Student (all on one line)

  ```Text
  firstname, lastname, email@example.com, (123)-456-789, 123 Test St, city,
  state,12345, (birthday)1/1/1990, 4.0,
  (date enrolled)5/9/2018
  ```
  * Faculty (all on one line)

  ```Text
  firstname, lastname, email@example.com, (123)-456-789, 123 Test St, city,
  state, 12345, (date hired)1/1/2000, (tenured?)true
  ```
  * The line is split by commas into an arraylist of strings and constants are used to assign the elements of the ArrayList to data fields in the appropriate class

* Courses
  * The CourseReader class expects an input that looks like this:

  ```Text
  minStudents maxStudents department code
  description
  ```

  * ex:

  ```Text
  5 10 BIO 101
  Intro to biology
  ```
* ID Parameter
  * The class IdParameterReader expects input that looks like this:

  ```Text
  minValue
  maxValue
  useOrderedAlgorithm?
  ```

  * ex.

  ```Text
  1000
  1500
  true
  ```

* Schedule Parameter
  * The class ScheduleParameterReader expects input that looks like this:

  ```Text
  sessionsPerCourse
  sessionsPerStudent
  sessionsPerFaculty
  useSmartAlgorithm?
  ```

  ex:

  ```Text
  2
  3
  4
  true
  ```
Unfortunately in choosing input expectations, some flexibility was lost.

## Part 4: Classes for Text Output

The classes *CoursePrinter*, *StudentPrinter*, and *FacultyPrinter* all serve the purpose of printing output to a text file

These classes generally have the same structure

> * Constructor that takes in a form of output (PrintWriter or pathname to file), an ArrayList of objects of the appropriate type (Course, Student, or Faculty), and a ClassSchedule object
> * 1 or 2 methods to print all scheduled or unscheduled objects of appropriate type
> * Several methods to return the number of scheduled or unscheduled objects of appropriate type

## Part 5: Main Class

The classes *RegistrationSystem* and *ClassSchedule* are the classes that mainly pertain to the assignment

* **ClassSchedule** is a container for an ArrayList of course sessions and also has methods which return specific schedules for Courses, Faculty, and Students
* **RegistrationSystem** contains the main method which runs the program and an additional method to print statistics about the input to the console

## Test Data
I created my program to be as robust as possible by monitoring inputs. My reader classes throw an exception if a file is not found or if the input is invalid and print a message to the console indicating which file is invalid.

* ex. Attempting to open the file "Students_Nonexistent.txt" yields the message

```Text
File Students_Nonexistent.txt not found.

Process finished with exit code 0
```
* ex. Attempting to input a double (2.4) as a parameter for the number of sessions per course yields the message

```Text
File ScheduleParameters.txt contains invalid format.

Process finished with exit code 0
```

Other exceptions are handled more generally

* ex. Missing comma in Students.txt

```Text
Exception occured: java.text.ParseException: Unparseable date: "3.6"

Process finished with exit code 0
```

* ex. Negative session number

```Text
Session Parameter error. Check input file.

Process finished with exit code 0
```

* ex. Invalid date format MM-dd-yyyy

```Text
Exception occured: java.text.ParseException: Unparseable date: "7-11-2001"

Process finished with exit code 0
```

* ex. Min Students > Max Students

```Text
Invalid Course Parameters. Check Course File.

Process finished with exit code 0
```

In general, I created test data files of 30 students, 10 faculty, and 9 courses. Students and Faculty have a variable number of courses on their wishlists/courses taught, including none, duplicates, and courses that do not exist. Schedule parameters include 2 sessions per course, 4 sessions per student, and 3 sessions per faculty member. I have attched printouts of this test data as well as the output files associated with this standard test.

The standard console printout:
```Text
Total Students: 30
Total Faculty: 10
Total Courses: 9
Total Scheduled Sessions: 10
Total Unscheduled Courses: 1
Total Unscheduled Students: 4

Process finished with exit code 0
```

> * Students/Faculty with no courses on their wishlists/courses taught are automatically unscheduled
> * Students/Faculty with nonexistent courses on their wishlists/courses taught are not scheduled in those courses
> * Students with duplicate courses on their wishlists are scheduled twice in different sessions of the same course
> * Faculty with duplicate courses on their wishlists has no effect


I rearranged parts of these files to test various cases.

* ex. Empty Students

```Text
Total Students: 0
Total Faculty: 10
Total Courses: 9
Total Scheduled Sessions: 0
Total Unscheduled Courses: 9
Total Unscheduled Students: 0

Process finished with exit code 0
```

* ex. Empty Faculty

```Text
Total Students: 30
Total Faculty: 0
Total Courses: 9
Total Scheduled Sessions: 0
Total Unscheduled Courses: 9
Total Unscheduled Students: 4

Process finished with exit code 0
```

* ex. Empty Courses

```Text
Total Students: 30
Total Faculty: 10
Total Courses: 0
Total Scheduled Sessions: 0
Total Unscheduled Courses: 0
Total Unscheduled Students: 30

Process finished with exit code 0
```

## Final Thoughts
This assignment was challenging for several reasons. The whole concept of a school registration system raises many questions, such as whether class times / prerequisites should be considered. I understand why the instructions were vague but this also left me confused as to how complicated this project needed to be. Additionally, one of the hardest parts of this assignment for me was confusing technical differences such as courses and course sessions. Overall, this project taught me several things:

* I feel as though I've gotten a better grasp of encapsulation and how it makes code flexible.
  * Several times while modifying parts of this program, I found myself thankful I made a separate class because the changes to my class did not affect the rest of the code.
* I learned about the high-level concept of factories and changing up algorithms at runtime.
* I learned how to generate javadoc comments and present my code in a way that (hopefully) is easy to understand.
* I learned how to version my code.
  * I felt it was necessary to review changes and potentially go back to old versions if my ideas did not pan out.

However, I also feel as though using a database for this project would have been simpler and easier than using text files. Also, generating 30 students + 10 faculty worth of test data was very time consuming. It would have been nice if some sample test data was provided. Overall, I would give this project 8/10.
