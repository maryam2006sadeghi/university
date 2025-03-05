package uni;

import base.Person;

import java.util.ArrayList;

import static uni.Major.majorList;

public class Student {
    public int id = 0;
    public static ArrayList<Student> studentList = new ArrayList<Student>();
    public int personID;
    public final int enteranceYear;
    public int majorID;
    public String studentID;
    private static int nextId = 1;
    int i ;

    public Student(int personID,int enteranceYear,int majorID){
        this.id = nextId;
        nextId ++;
        this.personID = personID;
        this.enteranceYear = enteranceYear;
        this.majorID = majorID;

        for (i = 0 ; i < majorList.size() ; i ++){
            if (majorList.get(i).id == majorID){
                majorList.get(i).numberOfStudents++;
                break;
            }
        }
        setStudentCode();
        studentList.add(this);
    }
    public static Student findById(int id){
        for (Student s : studentList) {
            if (s.id == id)
                return s;
        }
        return null;
    }
    public void setStudentCode(){
        studentID = String.valueOf(enteranceYear) + String.valueOf(majorID) + String.valueOf(majorList.get(i).numberOfStudents);
    }
}
