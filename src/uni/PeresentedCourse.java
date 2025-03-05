package uni;

import java.util.ArrayList;

public class PeresentedCourse {
    public int id;
    public static ArrayList<PeresentedCourse> PeresentedCourseList = new ArrayList<PeresentedCourse>();
    public int courseID;
    public int professorID;
    public int capacity;
    public ArrayList<Integer> studentIds = studentIds = new ArrayList<Integer>();

    public PeresentedCourse(int courseID,int professorID,int maxCapacity){
        this.courseID = courseID;
        this.professorID = professorID;
        this.capacity = maxCapacity;
        this.id = maxCapacity;
        PeresentedCourseList.add(this);
    }

    public static PeresentedCourse findById(int id){
        for (PeresentedCourse p : PeresentedCourseList) {
            if (p.id == id)
                return p;
        }
        return null;
    }

    public void addStudent (int studentId){
        if (this.studentIds.size() < capacity)
            studentIds.add(studentId);
        else
        System.out.println("you cannot add new students,the capacity has been exceeded");
    }
}
