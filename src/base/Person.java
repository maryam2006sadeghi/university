package base;

import java.util.ArrayList;

public class Person {
    public int id = 0;
    public String name;
    public String nationalID;
    public static ArrayList<Person> personList = new ArrayList<Person>();
    private static int nextId = 0;

    public Person (String name,String nationalID){
        this.id = nextId + 1;
        nextId ++ ;
        this.name = name;
        this.nationalID = nationalID;
        personList.add(this);
    }

    public static Person findById (int id){
        for (Person p : personList) {
            if (p.id == id) {
                return p;
            }
        }
        return null;
    }
}

