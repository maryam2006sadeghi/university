package uni;

import java.util.ArrayList;

public class Course {
    public int id;
    public static ArrayList<Course> courseList = new ArrayList<Course>();
    public String title;
    public int units;
    private static int nextId = 1;

    public Course(String title,int units){
        this.id = nextId;
        nextId ++;
        this.title = title;
        this.units = units;
        courseList.add(this);
    }


    public static Course findById(int id){
        for (Course c : courseList) {
            if (c.id == id)
                return c;
        }
        return null;
    }

}
