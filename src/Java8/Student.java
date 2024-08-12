package Java8;

import java.util.Collections;

public class Student implements Comparable<Student>{

    private int id;
    private String name;
    private int age;


    Student(int id,String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    @Override
    public int compareTo(Student o) {
      return Integer.compare(this.id, o.getId());
     //   return Collections.sort(this.name,o.getName());
//        if(this.id>o.id)
//            return 1;
//        else if(this.id<o.getId())
//            return  -1;
//        else
  //      return 0;
    }
}
