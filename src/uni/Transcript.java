package uni;

import base.Person;

import java.util.HashMap;

public class Transcript {
    public int studentID;
    public HashMap<Integer, Double> transcript;

    public Transcript(int studentID) {
        this.studentID = studentID;
        this.transcript = new HashMap<>();
    }

    public void setGrade(int presentedCourseID, double grade) {
        PeresentedCourse presentedCourse = PeresentedCourse.findById(presentedCourseID);
        if (presentedCourse != null && presentedCourse.studentIds.contains(studentID)) {
            transcript.put(presentedCourseID, grade);
        } else {
            System.out.println("Student is not enrolled in this course.");
        }
    }

    public void printTranscript() {
        Student student = Student.findById(studentID);
        Person person = Person.findById(studentID);
        if (student != null) {
            System.out.println("Transcript for: " + person.name + " (Student ID: " + student.studentID + ")");
        } else {
            System.out.println("Student not found.");
        }

        for (Integer courseID : transcript.keySet()) {

            PeresentedCourse presentedCourse = PeresentedCourse.findById(courseID);
            if (presentedCourse != null) {
                Course course = Course.findById(presentedCourse.courseID);
                if (course != null) {
                    System.out.println(course.title + ": " + transcript.get(courseID));
                }
            }
        }
    }

    public double getGPA() {
        double totalGradePoints = 0.0;
        int totalUnits = 0;

        for (Integer courseID : transcript.keySet()) {
            PeresentedCourse presentedCourse = PeresentedCourse.findById(courseID);
            if (presentedCourse != null) {
                Course course = Course.findById(presentedCourse.courseID);
                if (course != null) {
                    double grade = transcript.get(courseID);
                    int units = course.units;
                    totalGradePoints += grade * units;
                    totalUnits += units;
                }
            }
        }
        return totalUnits == 0 ? 0.0 : totalGradePoints / totalUnits;
    }
}
