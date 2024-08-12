package Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InterviewCustomQues {
    public static void main(String[] args) {

        // 1. How to make unmodifiable / immutable collection ?

        List<String> nameList = new ArrayList<>(Arrays.asList("One","Two","Three","Four","Five"));

        //modifying the nameList as its mutable

        nameList.add("Six");

        nameList.forEach(System.out::println);

        //gating unmodifiable version of namelist using copy.Of method added in java 10 for list,map, and set
        List<String> immutableCopyOfList = List.copyOf(nameList);
        immutableCopyOfList.add("Seven");

        immutableCopyOfList.forEach(System.out::println);

        List<String> unmodifiableCollectionList = Collections.unmodifiableList(nameList);
        unmodifiableCollectionList.add("Eight");

        unmodifiableCollectionList.forEach(System.out::println);

        List<String> unmodifiableCollectorsList =nameList.stream().collect(Collectors.toUnmodifiableList());
        unmodifiableCollectorsList.add("Seven");

        List<String> listOfList = List.of("one","two");
        listOfList.add("three");



    }
}
