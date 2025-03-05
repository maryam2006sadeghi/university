package uni;

import java.util.ArrayList;

public class Major {
    public int id;
    public String name;
    public final int capacity;
    public int numberOfStudents = 0;
    public static ArrayList<Major> majorList = new ArrayList<Major>();
    private static int nextId = 0;

    public Major (String name,int capacity) {
        this.id = nextId + 1;
        nextId ++;
        this.name = name;
        this.capacity = capacity;
        majorList.add(this);
    }

    public static Major findById(int id){
        for (Major m : majorList) {
            if (m.id == id)
                return m;
        }
        return null;
    }

    public void addStudent(){
        if (numberOfStudents == capacity )
            System.out.println("you cannot add new students,the capacity has been exceeded");
        else
            numberOfStudents ++;
    }
}
