/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package studentrecordbrowser;

/**
 *
 * @author kmhasan
 */
public class Student implements Comparable {
    private String name;
    private int id;
    private double gpa;
    
    public Student(String name, int id, double gpa) {
        this.name = name;
        this.id = id;
        this.gpa = gpa;
    }
    
    public String getName() {
        return name;
    }
    
    public int getID() {
        return id;
    }
    
    public double getGPA() {
        return gpa;
    }
    
    public String toString() {
        return name + " " + id + " " + gpa;
    }

    public int compareTo(Object o) {
        Student object = (Student)o;
        
        if (this.getName().compareTo(object.getName()) < 0)
            return -1;
        else return +1;
        
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}
