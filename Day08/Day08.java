import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Day08{
    public static void part1() throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        ArrayList<String> stringList = new ArrayList<String>();
        int visible = 0;
        while(in.hasNext()){
            stringList.add(in.nextLine());
        }
        int[][] map = new int[stringList.size()][stringList.get(0).length()];
        for(int r = 0; r < map.length; r++){
            for(int c = 0; c < map[0].length; c++){
                map[r][c] = Integer.valueOf(stringList.get(r).substring(c,c+1));
            }
        }
        for(int r = 0; r < map.length; r++){
            for(int c = 0; c < map[0].length; c++){
                if(r == 0 || c == 0 || r == map.length-1 || c == map[0].length-1){
                    visible++;
                } else {
                    boolean isVisible = true;
                    for(int i = 0; i < c; i++){
                        if(map[r][i] >= map[r][c]){
                            isVisible = false;
                        }
                    }
                    if(isVisible){
                        visible++;
                        continue;
                    }
                    isVisible = true;
                    for(int i = c+1; i < map[0].length; i++){
                        if(map[r][i] >= map[r][c]){
                            isVisible = false;
                        }
                    }
                    if(isVisible){
                        visible++;
                        continue;
                    }
                    isVisible = true;
                    for(int i = 0; i < r; i++){
                        if(map[i][c] >= map[r][c]){
                            isVisible = false;
                        }
                    }
                    if(isVisible){
                        visible++;
                        continue;
                    }
                    isVisible = true;
                    for(int i = r+1; i < map.length; i++){
                        if(map[i][c] >= map[r][c]){
                            isVisible = false;
                        }
                    }
                    if(isVisible){
                        visible++;
                        continue;
                    }
                }
            }
        }
        System.out.println(visible);
        
    }

    public static void part2() throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        ArrayList<String> stringList = new ArrayList<String>();
        int highest = 0;
        while(in.hasNext()){
            stringList.add(in.nextLine());
        }
        int[][] map = new int[stringList.size()][stringList.get(0).length()];
        for(int r = 0; r < map.length; r++){
            for(int c = 0; c < map[0].length; c++){
                map[r][c] = Integer.valueOf(stringList.get(r).substring(c,c+1));
            }
        }
        for(int r = 1; r < map.length-1; r++){
            for(int c = 1; c < map[0].length-1; c++){
                int distanceScore = 1;
                int location = c-1;
                while(location > 0 && map[r][location] < map[r][c]){
                    location--;
                }
                distanceScore *= c-location;
                location = c+1;
                while(location < map[0].length-1 && map[r][location] < map[r][c]){
                    location++;
                }
                distanceScore *= location-c;
                location = r-1;
                while(location > 0 && map[location][c] < map[r][c]){
                    location--;
                }
                distanceScore *= r-location;
                location = r+1;
                while(location < map.length-1 && map[location][c] < map[r][c]){
                    location++;
                }
                distanceScore *= location-r;
                
                if(distanceScore > highest){
                    highest = distanceScore; 
                }

            }
        }
        System.out.println(highest);

    }

    public static void main(String[] args){
        try{
            part2();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}