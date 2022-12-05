package Day03;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Day03 {

    private final static String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static void part1() throws IOException{
        Scanner in = new Scanner(new File("input.txt"));
        int total = 0;
        while(in.hasNext()){
            String line = in.nextLine();
            String firstHalf = line.substring(0, line.length()/2);
            String secondHalf = line.substring(line.length()/2);
            String common = "";
            for(int i = 0; i < firstHalf.length(); i++){
                if(secondHalf.indexOf(firstHalf.substring(i,i+1))!= -1){
                    common = firstHalf.substring(i,i+1);
                }
            }
            total += alphabet.indexOf(common) + 1;
        }
        System.out.println(total);
    }

    public static void part2() throws IOException{
        Scanner in = new Scanner(new File("input.txt"));
        int total = 0;
        while(in.hasNext()){
            String line1 = in.nextLine();
            String line2 = in.nextLine();
            String line3 = in.nextLine();
            String common = "";
            for(int i = 0; i < line1.length(); i++){
                String let = line1.substring(i,i+1);
                if(line2.indexOf(let) != -1 && line3.indexOf(let) != -1){
                    common = let;
                }
            }
            total += alphabet.indexOf(common) + 1;
        }
        System.out.println(total);
    }

    public static void main(String[] args){
        try {
            part2();
            
        } catch(Exception e){
            System.out.println(e);
        }
    }
}
