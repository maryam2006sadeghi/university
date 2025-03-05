package uni;

import java.util.ArrayList;

public class Professor {
    public int id;
    public static ArrayList<Professor> professorList = new ArrayList<Professor>();
    public int personID;
    public int majorID;
    private static int nextId = 1;

    public Professor (int personID,int majorID){
        this.id = nextId;
        nextId ++;
        this.personID = personID;
        this.majorID = majorID;
        professorList.add(this);
    }

    public static Professor findById(int id){
        for (Professor p : professorList) {
            if (p.id == id)
                return p;
        }
        return null;
    }
}
