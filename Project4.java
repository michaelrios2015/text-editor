/*
 Michael Rios
COSC 600
Project 4 

Algorithim

 */

package project.pkg4;

import java.io.File;
import java.util.Scanner;

public class Project4 {

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("we will start by importing your text");
        
        list myList = new list();       
        String next = "yes";
        //would you like to use precreated list or build yor own
        //precreated
        myList.BuildList();
        myList.DisplayList();
        System.out.println();
        
        //else
        
        while (!next.equals("$done")){
        
            System.out.println("what would you like to do next");
            next = sc.nextLine();
        
            if (next.equals("$insert")){
                System.out.println("please enter line to be insterted");
                String nextLine = sc.nextLine();
                myList.insert(nextLine);
                myList.DisplayList();
            }
            
            else if (next.equals("$delete")){
                int first = 0; 
                int last = 0;
                System.out.println("please enter the line number to begin deletion");
                first = sc.nextInt();
                while (first < 1){
                        System.out.println("Sorry one is the smallest value you can enter");
                        System.out.println("please enter the line number to begin deletion");
                        first = sc.nextInt();
                }
                while (first > myList.countList()){
                    {
                        System.out.printf("Sorry %d is the largest value you can enter", myList.countList());
                        System.out.println("please enter the line number to begin deletion");
                        first = sc.nextInt();
                    }
                }
                System.out.println("please enter the line number to end deletion");
                last = sc.nextInt();
                while (last < first){
                        System.out.printf("Sorry %d is the smallest value you can enter", first);
                        System.out.println("please enter the line number to end deletion");
                        last = sc.nextInt();
                }
                while (last > myList.countList()){
                        System.out.printf("Sorry %d is the largest value you can enter", myList.countList());
                        System.out.println("please enter the line number to end deletion");
                        last = sc.nextInt();
                }
                myList.delete(first, last);
                myList.DisplayList();
                }
            else if (next.equals("$print")){
                int first = 0; 
                int last = 0;
                System.out.println("please enter the line number to begin printing");
                first = sc.nextInt();
                while (first < 1){
                        System.out.println("Sorry 1 is the smallest value you can enter");
                        System.out.println("please enter the line number to begin printing");
                        first = sc.nextInt();
                }
                while (first > myList.countList()){
                    {
                        System.out.printf("Sorry %d is the largest value you can enter", myList.countList());
                        System.out.println("please enter the line number to begin printing");
                        first = sc.nextInt();
                    }
                }
                System.out.println("please enter the line number to end printing");
                last = sc.nextInt();
                while (last < first){
                        System.out.printf("Sorry %d is the smallest value you can enter", first);
                        System.out.println("please enter the line number to end printing");
                        last = sc.nextInt();
                }
                while (last > myList.countList()){
                        System.out.printf("Sorry %d is the largest value you can enter", myList.countList());
                        System.out.println("please enter the line number to end printing");
                        last = sc.nextInt();
                }
                myList.print(first, last);
                
                }
            else if (next.equals("$current")){
                int first = 0; 
                
                System.out.println("please enter the line number to make current");
                first = sc.nextInt();
                while (first < 1){
                        System.out.println("Sorry 1 is the smallest value you can enter");
                        System.out.println("please enter the line number to make current");
                        first = sc.nextInt();
                }
                while (first > myList.countList()){
                    {
                        System.out.printf("Sorry %d is the largest value you can enter", myList.countList());
                        System.out.println("please enter the line number to make current");
                        first = sc.nextInt();
                    }
                }
                
                myList.current(first);
                
                }
            else if (next.equals("$search")){
                String word; 
                
                System.out.println("please enter word to search for");
                word = sc.next();
                
                
                myList.search(word);
                
                }
            else{
                System.out.println(next + "is not a command, please try again");
            }
        
        }  
     }
}

