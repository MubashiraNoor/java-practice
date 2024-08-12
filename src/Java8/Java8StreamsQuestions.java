package Java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Java8StreamsQuestions {
    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10);
    //------------------------------------------------------------------------------------------------------------------
    // 1. Given a list of integers, find out all the even numbers that exist in the list using Stream functions?

        integerList.stream().filter(a-> a % 2 == 0).forEach(System.out::println);

        System.out.println();


    //------------------------------------------------------------------------------------------------------------------
    // 2. Given a list of integers, find out all the numbers starting with 1 using Stream functions?

        integerList.stream().map(Object::toString).filter(a->a.startsWith("1")).forEach(System.out::println);

        System.out.println();

    //------------------------------------------------------------------------------------------------------------------
    // 3. How to find duplicate elements in a given integers list in java using Stream functions?

        List<Integer> duplicateList = new ArrayList<>();
        Collections.addAll(duplicateList,1,1,12,7,11,2,3,4,5,6,4,3,7,8,8,9);

        //using Set
        Set<Integer> uniqueSet = new HashSet<>();
        duplicateList.stream().filter(a->!uniqueSet.add(a)).forEach(System.out::println);

        System.out.println();
        //using map
        duplicateList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream().filter(entry->entry.getValue()>1)
                .forEach(entry->System.out.println(entry.getKey()));

        System.out.println();


    //------------------------------------------------------------------------------------------------------------------
    // 4. Given the list of integers, find the first element of the list using Stream functions?

        System.out.println(integerList.stream().findFirst().get());

        System.out.println();

    //------------------------------------------------------------------------------------------------------------------
    // 5. Given a list of integers, find the total number of elements present in the list using Stream functions?

        System.out.println(integerList.stream().count());

        System.out.println();

    //------------------------------------------------------------------------------------------------------------------
    // 6. Given a list of integers, find the maximum value element present in it using Stream functions?

        System.out.println(integerList.stream().max(Integer::compare).get());

        System.out.println();

    //------------------------------------------------------------------------------------------------------------------
    // 7. Given a String, find the first non-repeated number in it using Stream functions?

        System.out.println(duplicateList.stream().collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting())).entrySet().stream().filter(entry -> entry.getValue()==1).map(Map.Entry::getKey).findFirst().get());

    //------------------------------------------------------------------------------------------------------------------
    // 8. Given a String, find the first non-repeated character in it using Stream functions?

        String repeatedCharacterString = "Java Articles are Awesome";

        System.out.println(repeatedCharacterString.chars().mapToObj(a->Character.toString((char)a).toLowerCase())
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting())).entrySet()
                .stream().filter(a->a.getValue()==1).map(Map.Entry::getKey).findFirst().get());

        System.out.println();

    //------------------------------------------------------------------------------------------------------------------
    // 9. Given a String, find the first repeated character in it using Stream functions?



        System.out.println(repeatedCharacterString.chars().mapToObj(a->Character.toString((char)a).toLowerCase())
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting())).entrySet()
                .stream().filter(a->a.getValue()>1).map(Map.Entry::getKey).findFirst().get());

        System.out.println();

    //------------------------------------------------------------------------------------------------------------------
    // 10. Given a list of integers, sort all the values present in it using Stream functions?

        duplicateList.stream().sorted().forEach(System.out::println);

        System.out.println();

    //------------------------------------------------------------------------------------------------------------------
    // 11. Given a list of integers, sort all the values present in it in descending order using Stream functions?

        duplicateList.stream().sorted((a,b)->Integer.compare(b,a)).forEach(System.out::println);

        //other way using collections
        duplicateList.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);

        System.out.println();

    //------------------------------------------------------------------------------------------------------------------
    // 12. Given an integer array nums, return true if any value appears at least twice in the array,
    // and return false if every element is distinct.

        int[] nums = {1,2,3,4,5,6,7,8,9,9};

        Set<Integer> st = new HashSet<>();
        long res;

        //using boxed()
        res = Arrays.stream(nums).boxed().filter(a->!st.add(a)).count();

        // using mapToObj
        // res =  Arrays.stream(nums).mapToObj(Integer::valueOf).filter(a->!st.add(a)).count();
        System.out.println(res>0);

        System.out.println();

    //------------------------------------------------------------------------------------------------------------------
    // 13. Write a Java 8 program to concatenate two Streams?

        Stream<Integer> streamOne = Stream.of(1,2,3,4,5);
        Stream<Integer> streamTwo = Stream.of(6,7,8,9,10);
        Stream<Integer> resultantStream = Stream.concat(streamOne,streamTwo);

        resultantStream.forEach(System.out::println);

        System.out.println();

    //------------------------------------------------------------------------------------------------------------------
    // 14. Java 8 program to perform cube on list elements and filter numbers greater than 50.

        List<Integer> numList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        numList.stream().map(a->a*a*a).filter(a->a>50).forEach(System.out::println);

        System.out.println();

    //------------------------------------------------------------------------------------------------------------------
    // 15. Write a Java 8 program to sort an array and then convert the sorted array into Stream?

        int[] numArray = {4,2,8,1,3};
        Arrays.parallelSort(numArray);
        Arrays.stream(numArray).forEach(System.out::println);

    //------------------------------------------------------------------------------------------------------------------
    // 15. How to use map to convert object into Uppercase in Java 8?

       List<String> namesList = Arrays.asList("Noor Ahmed", "Mumtaz","Mumtaz", "Sharmin", "Tabish","Wajiha", "Maryam","Umar", "Ibrahim", "Waheba", "Abu", "Minha");

       namesList.stream().map(String::toUpperCase).forEach(System.out::println);
       System.out.println();

    //------------------------------------------------------------------------------------------------------------------
    // 16. How to count each element/word from the String ArrayList in Java8?

    System.out.println(namesList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));

    //------------------------------------------------------------------------------------------------------------------
    // 16. How to count each word length from the String ArrayList in Java8?

        System.out.println(namesList.stream().collect(Collectors.toMap(name->name,String::length,(oldVal,newVal)->oldVal)));

    //------------------------------------------------------------------------------------------------------------------
    // 19. How to find only duplicate elements with its count from the String ArrayList in Java8?

    namesList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().filter(entry->entry.getValue()>1).forEach(System.out::println);

    //------------------------------------------------------------------------------------------------------------------
    // 20. Write a Program to find the Maximum element in an array?

        int[] intArr = {1,2,3,8,4,5};

       System.out.println(Arrays.stream(intArr).max().getAsInt());

    //------------------------------------------------------------------------------------------------------------------
    // 22. Write a program to print the count of each character in a String?

    System.out.println("name map");
    String name = "Mubashira";
    name.chars().mapToObj(a->Character.toString((char)a)).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting())).entrySet().forEach(System.out::println);



    }
}
