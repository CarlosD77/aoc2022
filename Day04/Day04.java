import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Day04 {
    
    public static void part1() throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        int count = 0;
        while(in.hasNext()){
            String[] line = in.nextLine().split("[,-]");
            int first1 = Integer.valueOf(line[0]);
            int first2 = Integer.valueOf(line[1]);
            int second1 = Integer.valueOf(line[2]);
            int second2 = Integer.valueOf(line[3]);
            if(first1 <= second1 && first2 >= second2){
                count++;
            } else if(second1 <= first1 && second2 >= first2){
                count++;
            }
        }
        System.out.println(count);
    }

    public static void part2() throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        int count = 0;
        while(in.hasNext()){
            String[] line = in.nextLine().split("[,-]");
            int first1 = Integer.valueOf(line[0]);
            int first2 = Integer.valueOf(line[1]);
            int second1 = Integer.valueOf(line[2]);
            int second2 = Integer.valueOf(line[3]);
            if(!(first1 > second2 || second1 > first2)){
                count++;
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args){
        try {
            part2();
        } catch(Exception e){
            System.out.println(e);
        }
    }
}