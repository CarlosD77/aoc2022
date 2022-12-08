import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

class Directory {
    private String name;
    private ArrayList<SimpleFile> containedFiles;
    private ArrayList<Directory> containedDirectories;
    private Directory parent;
    public Directory(String name){
        this.name = name;
        this.containedFiles = new ArrayList<SimpleFile>();
        this.containedDirectories = new ArrayList<Directory>();
    }

    public Directory(String name, Directory parent){
        this.name = name;
        this.containedFiles = new ArrayList<SimpleFile>();
        this.containedDirectories = new ArrayList<Directory>();
        this.parent = parent;
    }


    public String getName(){
        return this.name;
    }
    public int getSize(){
        int size = 0;
        for(Directory d : this.containedDirectories){
            size += d.getSize();
        }
        for(SimpleFile f : this.containedFiles){
            size += f.getSize();
        }
        return size;
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
        
    }

    public void addDirectory(Directory d){
        this.containedDirectories.add(d);
    }
    public void setParent(Directory d){
        this.parent = d;
    }

    public void addAllToDirectoryList(ArrayList<Directory> l){
        l.add(this);
        for(Directory d : this.containedDirectories){
            d.addAllToDirectoryList(l);
        }
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
        Scanner in = new Scanner(new File("input.txt"));
        ArrayList<Directory> directoryList = new ArrayList<Directory>();
        Directory largest = new Directory("/");
        Directory current = largest;
        in.nextLine();
        while(in.hasNext()){
            String[] line = in.nextLine().split(" ");
            if(line[0].equals("$")){
                if(line[1].equals("cd")){
                    if(line[2].equals("..")){
                        current = current.getParent();
                    } else if(line[2].equals("/")){
                        current = largest;
                    } else {
                        for(Directory d : current.getContainedDirectories()){
                            if(d.getName().equals(line[2])){
                                current = d;
                                break;
                            }
                        }
                    }
                }
            } else if(line[0].equals("dir")){
                current.getContainedDirectories().add(new Directory(line[1],current));
            } else {
                current.addFile(new SimpleFile(line[1], Integer.valueOf(line[0])));
            }
        }
        largest.addAllToDirectoryList(directoryList);
        int total = 0;
        for(Directory d : directoryList){
            int size = d.getSize();
            if(size < 100000){
                total += size;
            }
        }
        System.out.println(total);
    }

    public static void part2() throws IOException {
        Scanner in = new Scanner(new File("input.txt"));
        ArrayList<Directory> directoryList = new ArrayList<Directory>();
        Directory largest = new Directory("/");
        Directory current = largest;
        in.nextLine();
        while(in.hasNext()){
            String[] line = in.nextLine().split(" ");
            if(line[0].equals("$")){
                if(line[1].equals("cd")){
                    if(line[2].equals("..")){
                        current = current.getParent();
                    } else if(line[2].equals("/")){
                        current = largest;
                    } else {
                        for(Directory d : current.getContainedDirectories()){
                            if(d.getName().equals(line[2])){
                                current = d;
                                break;
                            }
                        }
                    }
                }
            } else if(line[0].equals("dir")){
                current.getContainedDirectories().add(new Directory(line[1],current));
            } else {
                current.addFile(new SimpleFile(line[1], Integer.valueOf(line[0])));
            }
        }
        largest.addAllToDirectoryList(directoryList);
        int difference = largest.getSize() - 40000000;
        int smallest = 70000000;
        for(Directory d : directoryList){
            int size = d.getSize();
            if(size >= difference && size < smallest){
                smallest = size;
            }
        }
        System.out.println(smallest);
    }

    public static void main(String[] args){
        try {
            part2();
        } catch(Exception e){
            System.out.println(e);
        }
    }
}