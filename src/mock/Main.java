package mock;

import java.util.*;
import java.io.*;
import java.math.*;


class Outcome {

    public static List<Integer> merge(List<Integer> arr1,List<Integer> arr2){
        //Write your code here
        List<Integer> result = new ArrayList<>();
        result.add(1);
        result.add(2);
        result.add(3);
        return result;
    }

}

public class Main {
	
    public static void main(String[] args) throws IOException {
    	
    	
    	
    	
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getProperty("D:\\SourceTree\\crackingcodinginterview\\src\\mock\\input.txt")));
//        bufferedWriter.write("\n");
//        bufferedWriter.close();
//        bufferedWriter = new BufferedWriter(new FileWriter(System.getProperty("OUTPUT_FILE_PATH"),true));
//        //int arr1Count = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> arr1 = new ArrayList<>();
//
//        String[] arr1tempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//        for (int i = 0; i < arr1tempItems.length; i++) {
//            int arr1Item = Integer.parseInt(arr1tempItems[i]);
//            arr1.add(arr1Item);
//        }
//
//        // int arr2Count = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<Integer> arr2 = new ArrayList<>();
//
//        String[] arr2tempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
//
//        for (int i = 0; i < arr2tempItems.length; i++) {
//            int arr2Item = Integer.parseInt(arr2tempItems[i]);
//            arr2.add(arr2Item);
//        }
//
//        List<Integer> outcome = Outcome.merge(arr1,arr2);
//
//        // for(int i=0;i<outcome.size();i++) {
//        //     bufferedWriter.write(outcome.get(i).toString());
//        //     if(i<outcome.size()-1)
//        //         bufferedWriter.write(" ");
//        // }
//        for(int item : outcome){
//            bufferedWriter.write(item + " ");
//        }
//
//        bufferedWriter.newLine();
//    
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
