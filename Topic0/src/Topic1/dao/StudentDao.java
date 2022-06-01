package Topic1.dao;

import Topic1.core.Student;

public class StudentDao {
    private  int count;
    private Student[] students = new Student[100];
    private ISortStrategy sortStrategy;

    public void addStudent(Student student){

    }
    public  Student removeStudent(int code){
        return null;
    }
    public void display(){

    }
    public  void sort(){

    }
    public void setSortStrategy(ISortStrategy sortStrategy){
        this.sortStrategy = sortStrategy;
    }
}

