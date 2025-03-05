import base.Person;
import uni.*;

public class Main {
    public static void main (String[] args){
        Major major1 = new Major("Computer Science",30);
        Major major2 = new Major("Computer engineering",20);

        Person person1 = new Person("Maryam","11111111");
        Person person2 = new Person("Shirin","22222222");
        Person person3 = new Person("Zhina","33333333");
        Person person4 = new Person("Zare","1111111");
        Person person5 = new Person("Ghate","22222222");

        Student daneshjo1 = new Student(person1.id,403,major1.id);
        Student daneshjo2 = new Student(person2.id,403,major1.id);
        Student daneshjo3 = new Student(person3.id,403,major2.id);

        printStudent(daneshjo1);
        printStudent(daneshjo2);
        printStudent(daneshjo3);

        Professor professor1 = new Professor(person4.id,major1.id);
        Professor professor2 = new Professor(person5.id,major2.id);

        printProfessors(professor1);
        printProfessors(professor2);

        Course course1 = new Course("Advanced Programming", 3);
        Course course2 = new Course("Data Structures", 3);
        Course course3 = new Course("Algorithms", 3);

        PeresentedCourse presentedCourse1 = new PeresentedCourse(course1.id,professor1.id, 30);
        PeresentedCourse presentedCourse2 = new PeresentedCourse(course2.id,professor1.id, 30);
        PeresentedCourse presentedCourse3 = new PeresentedCourse(course3.id,professor2.id, 30);

        presentedCourse1.addStudent(daneshjo1.id);
        presentedCourse1.addStudent(daneshjo2.id);
        presentedCourse2.addStudent(daneshjo1.id);
        presentedCourse2.addStudent(daneshjo2.id);
        presentedCourse2.addStudent(daneshjo3.id);
        presentedCourse3.addStudent(daneshjo3.id);

        printPresentedCourse(presentedCourse1);
        printPresentedCourse(presentedCourse2);
        printPresentedCourse(presentedCourse3);

        Transcript transcript1 = new Transcript(daneshjo1.id);
        Transcript transcript2 = new Transcript(daneshjo2.id);
        Transcript transcript3 = new Transcript(daneshjo3.id);

        transcript1.setGrade(presentedCourse1.id, 18.5);
        transcript1.setGrade(presentedCourse2.id, 16.0);

        transcript2.setGrade(presentedCourse1.id, 15.0);
        transcript2.setGrade(presentedCourse2.id, 17.5);

        transcript3.setGrade(presentedCourse2.id, 19.0);
        transcript3.setGrade(presentedCourse3.id, 20.0);

        System.out.println("Transcripts:");
        transcript1.printTranscript();
        transcript2.printTranscript();
        transcript3.printTranscript();

        System.out.println("GPAs:");
        System.out.println("Student 1 GPA: " + transcript1.getGPA());
        System.out.println("Student 2 GPA: " + transcript2.getGPA());
        System.out.println("Student 3 GPA: " + transcript3.getGPA());
    }
        public static void printStudent(Student student) {
            Person person = Person.findById(student.personID);
            Major major = Major.findById(student.majorID);
            if (person != null && major != null) {
                System.out.println("Name: " + person.name);
                System.out.println("Student ID: " + student.studentID);
                System.out.println("Major: " + major.name);
                System.out.println("Entrance Year: " + student.enteranceYear);
                System.out.println("-----------------------------");
            } else {
                System.out.println("Student not found.");
            }
        }
        public static void printProfessors(Professor professor) {
                  Person person = Person.findById(professor.personID);
                  Major major = Major.findById(professor.majorID);
                  if (person != null && major != null) {
                   System.out.println("Professor ID: " + professor.id);
                   System.out.println("Name: " + person.name);
                   System.out.println("Major: " + major.name);
                   System.out.println("-----------------------------");
                  } else {
                    System.out.println("Professor not found.");
                  }
        }
         public static void printPresentedCourse(PeresentedCourse presentedCourse) {
                  Course course = Course.findById(presentedCourse.courseID);
                  Professor professor = Professor.findById(presentedCourse.professorID);

                  if (course != null && professor != null) {
                  System.out.println("Course Title: " + course.title);
                  System.out.println("Professor: " + Person.findById(professor.personID).name);
                  System.out.println("Student IDs: " + presentedCourse.studentIds);
                  System.out.println("-----------------------------");
                  }
                  else {
                  System.out.println("Presented course information not found.");
                  }
         }
}
