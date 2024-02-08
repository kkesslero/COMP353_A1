import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Represents a student with SID, SName, Program, and Address attributes
class Student {
    String SID;
    String SName;
    String Program;
    String Address;

    public Student(String SID, String SName, String Program, String Address) {
        this.SID = SID;
        this.SName = SName;
        this.Program = Program;
        this.Address = Address;
    }
}

// Represents a course with CID, CName, and NoOfCredits attributes
class Course {
    String CID;
    String CName;
    int NoOfCredits;

    public Course(String CID, String CName, int NoOfCredits) {
        this.CID = CID;
        this.CName = CName;
        this.NoOfCredits = NoOfCredits;
    }
}

// Represents a student's enrollment with SID, CID, Semester, Year, and Grade attributes
class Enrollment {
    String SID;
    String CID;
    String Semester;
    int Year;
    String Grade;
    
    public Enrollment(String SID, String CID, String Semester, int Year, String Grade) {
        this.SID = SID;
        this.CID = CID;
        this.Semester = Semester;
        this.Year = Year;
        this.Grade = Grade;
    }
}

public class Main {
    public static void main(String[] args) {

        // Read the data from text files
        Student[] students = loadStudents("src/students.txt");
        Course[] courses = loadCourses("src/courses.txt");
        Enrollment[] enrollments = loadEnrollments("src/enrollments.txt");

        // Perform the query based on the data read from the text files
        queryStudentsByEnrollment(students, courses, enrollments);
    }

    private static Student[] loadStudents(String fileName) {
        List<Student> studentList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Student student = new Student(parts[0], parts[1], parts[2], parts[3]);
                studentList.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return studentList.toArray(new Student[0]);
    }

    private static Course[] loadCourses(String fileName) {
        List<Course> courseList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Course course = new Course(parts[0], parts[1], Integer.parseInt(parts[2]));
                courseList.add(course);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return courseList.toArray(new Course[0]);
    }


    private static Enrollment[] loadEnrollments(String fileName) {
        List<Enrollment> enrollmentList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Enrollment enrollment = new Enrollment(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]);
                enrollmentList.add(enrollment);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return enrollmentList.toArray(new Enrollment[0]);
    }

    // Perform the query to find students who satisfy the given enrollment conditions
    private static void queryStudentsByEnrollment(Student[] students, Course[] courses, Enrollment[] enrollments) {
        System.out.println("Result:");
        System.out.println("SID\tSName");
        
        for (Enrollment enrollment : enrollments) {
            if (enrollment.Semester.equals("Winter") && enrollment.Year == 2024 && enrollment.CID.equals("101")) {
                if (enrollment.Grade.equals("B+") || enrollment.Grade.equals("A-") || enrollment.Grade.equals("A") || enrollment.Grade.equals("A+")) {
                    for (Student student : students) {
                        if (student.SID.equals(enrollment.SID)) {
                            System.out.println(student.SID + "\t" + student.SName);
                            break;
                        }
                    }
                }
            }
        }
    }
}
