package main.java;

import java.util.*;
import java.util.stream.Collectors;

public class IntroduceStreams {
    public static void main(String[] args) {

        new IntroduceStreams().introStreams();

    }

    private void introStreams() {
        List<String> strings = Arrays.asList("abc", "", "def", "efg", "ac","", "xyz");
        long emptyString = strings.stream().filter(s -> matchString(s)).count();

        //long count = strings.stream().filter(string->string.isEmpty()).count();
        System.out.println("Empty Strings: " + emptyString);


        List<String> filtered = strings.stream().filter(string ->!string.isEmpty()).collect(Collectors.toList());
        System.out.println("Filtered List: " + filtered);

        String mergedString = strings.parallelStream().filter(string ->!string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("Merged String: " + mergedString);

    }
    private boolean matchString(String checkString) {
        if(checkString.isBlank())
            return true;
        return false;
    }
}

