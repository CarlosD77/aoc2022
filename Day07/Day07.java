import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

class Directory {
    private String name;
    private int size;
    private ArrayList<SimpleFile> containedFiles;
    private ArrayList<Directory> containedDirectories;
    private Directory parent;
    public Directory(String name){
        this.name = name;
        this.size = 0;
        this.containedFiles = new ArrayList<SimpleFile>();
        this.containedDirectories = new ArrayList<Directory>();
    }


    public String getName(){
        return this.name;
    }
    public int getSize(){
        return this.getSize();
    }
    public Directory getParent(){
        return this.parent;
    }
    public ArrayList<SimpleFile> getContainedFiles(){
        return containedFiles;
    }
    public ArrayList<Directory> getContainedDirectories(){
        return containedDirectories;
    }
    public void addFile(SimpleFile f){
        this.containedFiles.add(f);
        this.size += f.getSize();
    }

    public void addDirectory(Directory d){
        this.containedDirectories.add(d);
    }
    public void setParent(Directory d){
        this.parent = d;
    }

}

class SimpleFile {
    private String name;
    private int size;
    public SimpleFile(String name, int size){
        this.name = name;
        this.size = size;
    }

    public String getName(){
        return this.name;
    }

    public int getSize(){
        return this.size;
    }
}

public class Day07 {

    
    public static void part1() throws IOException {
        Scanner in = new Scanner(new File("sampleInput.txt"));
        while(in.hasNext()){
            String[] line = in.nextLine().split(" ");
        }
    }

    public static void part2() throws IOException {

    }

    public static void main(String[] args){
        try {
            part1();
        } catch(Exception e){
            System.out.println(e);
        }
    }
}