package Java8;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ObjectSorting {
    public static void main(String[] args) {
        //------------------------------------------------------------------------------------------------------------------
        // 1. How to convert a List of objects into a Map by considering duplicated keys and store them in sorted order?

        //student list converted to map considering duplicate key and sort them in order

        Set<Integer> customSet = new HashSet<>();
        //custom object list
        List<Student> studentsList = new ArrayList<>();
        studentsList.add(new Student(1, "student1", 5));
        studentsList.add(new Student(2, "student2", 7));
        studentsList.add(new Student(3, "student3", 2));
        studentsList.add(new Student(4, "student4", 1));
        studentsList.add(new Student(5, "student5", 3));

        //additional object with same student name but different age
        studentsList.add(new Student(6, "student2", 5));

        // studentsList.stream().filter(a-> customSet.add(a.getAge())).sorted(Comparator.comparing(Student::getAge)).forEach(System.out::println);
      //  studentsList.stream().filter(a-> customSet.add(a.getAge())).sorted(Comparator.comparing(Student::getAge)).map(student -> Map.entry(student.getName(),student.getAge())).forEach(System.out::println);
        studentsList.stream().filter(a-> customSet.add(a.getAge())).map(student -> Map.entry(student.getName(),student.getAge())).forEach(System.out::println);

studentsList.stream().collect(Collectors.toMap(Student::getName,Student::getAge,(oldVal,newVal)->oldVal,LinkedHashMap::new)).entrySet().forEach(System.out::println);
        System.out.println("Student List without sorting maintaining insertion order - ");
        studentsList.forEach(System.out::println);



        System.out.println("Student List with sorting by age using comparator - ");
        studentsList.sort(new StudentAgeComparator());

        //sorted Students by Age
        studentsList.forEach(System.out::println);



        System.out.println("Student List with sorting by id using comparable - ");
        Collections.sort(studentsList);
        studentsList.forEach(System.out::println);

        //integerList
        List<Integer> intList = Arrays.asList(2,4,5,1,3);


        System.out.println("Integer List not sorted - ");
        intList.forEach(System.out::println);


        //sort int type of list
        System.out.println("Integer List sorted using Collections - ");
        Collections.sort(intList);
        intList.forEach(System.out::println);

        //-------------------------------------------------------------------------------------------------------------------
        // 20. How to check if list is empty in Java 8 using Optional, if not null iterate through the list and print the object?

        List<Student> st = null;
        System.out.println("Here");

        Supplier<List<Student>> getStudentList = ()-> studentsList;


        Optional.ofNullable(st).orElseGet(getStudentList).forEach(System.out::println);

     //  Optional.of(studentsList).orElseGet(Collections::emptyList).forEach(System.out::println);
    }
}
