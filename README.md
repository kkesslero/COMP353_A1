Based on the provided Java code, here's a README file that explains what the program does and how to use it:

---

# Student Enrollment Query System

This Java program reads data from text files containing information about students, courses, and enrollments. It performs a query to find students who satisfy specific enrollment conditions and displays the results.

## Features

- **Load Data:** Reads data from text files for students, courses, and enrollments.
- **Perform Query:** Queries students based on enrollment conditions such as semester, year, course ID, and grade.
- **Display Results:** Prints the student IDs and names who meet the specified enrollment conditions.

## How to Use

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/your-username/student-enrollment-query.git
   ```

2. **Compile the Java Code:**
   ```bash
   javac Main.java
   ```

3. **Run the Program:**
   ```bash
   java Main
   ```

4. **View Results:**
   The program will display the student IDs and names who meet the specified enrollment conditions.

## Data Files

- **students.txt:** Contains student information (SID, SName, Program, Address).
- **courses.txt:** Contains course information (CID, CName, NoOfCredits).
- **enrollments.txt:** Contains enrollment information (SID, CID, Semester, Year, Grade).

## Example Query

The program performs a query to find students who:
- Were enrolled in the Winter semester of 2024.
- Took the course with ID "101".
- Received a grade of "B+", "A-", "A", or "A+".

---
