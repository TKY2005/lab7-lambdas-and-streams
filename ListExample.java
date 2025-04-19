/*
 * Name: Youssef Mohamed Torki Ahmed
 * ID: 445820246
 * Lab7- Streams and lambda expressions.
 */

import java.io.*;
import java.util.*;

public class ListExample {

    public static void main(String[] args) {

        try(BufferedWriter writer = new BufferedWriter(new FileWriter("logListFile.txt"))){
            List<Integer> list = new ArrayList<Integer>();
            for(int i = 0; i < 100; i++) list.add(new Random().nextInt(1, 100));
            System.out.println(list);
            writer.append("Original list :\n");
            writer.append(list + "\n");

            int threshold = new Random().nextInt(1, 100);
            writer.append("Selected threshold: " + threshold + "\n");
            System.out.println("Selected threshold : " + threshold);

            list = list.stream().filter(x -> x < threshold).sorted().toList();
            // this displays each element using stream operations. but i thought that printing it as a list would be better.
            // list.stream().filter(x -> x < threshold).sorted().forEach(System.out::println)
            System.out.println(list);
            writer.append("Processed list: \n");
            writer.append(list.toString());
            writer.close();
        }
        catch(IOException ioProblem){
            System.out.println("Couldn't write to file.");
            System.out.println(ioProblem.getStackTrace().toString());
        }
    }
}