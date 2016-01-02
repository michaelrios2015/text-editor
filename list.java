/*
 Michael Rios
COSC 600
Project 4 

*/

package project.pkg4;
import java.util.*;
import java.io.*;

public class list {

  private node q = new node();
  private node head = q;  
  private int current = 0;
  private Scanner sc = new Scanner(System.in);
  
  public void BuildList()
  { 
    String oneLine;
    try{BufferedReader indata = new
        BufferedReader(new InputStreamReader(System.in)); // read data from terminals
        Scanner sc = new Scanner(new  File("golf.txt"));
        
    while (sc.hasNextLine()){
        oneLine = sc.nextLine();
        
        node p = new node(oneLine,null);
        q.next = p;
        q = p;
     
    }
    }catch(Exception e)
    { System.out.println("Error --" + e.toString());}
 
  }
  
  public int countList()
  { 
    int count = 0;  
    q = head;  
    while (q != null){
        count++;
        q = q.next;    
    }
    return count;
  }
  
  
  public void DisplayList()
  {
    int i = 0;
    q = head;  
    q = q.next;
    while (q != null){
         System.out.println((i+1) + ".  " + q.line);
    q = q.next;
   
    i++;}
  }
/* $insert
Each subsequent line, up to the next line editor command, will be inserted in the text. 
If there is a designated current line, each line is inserted before that current line. 
Otherwise each line is inserted at the end of the text*/
   public void insert(String line){
   
    if (current == 1){
        q = head;
 //       node next = head.next;
    
    
        node p = new node(line, head.next);
    
        q.next = p;    }   
    else if (current > 1){
        q = head;
        node next = head.next;
    
        for (int i=0; i < current-1; i++){
            q = q.next;
            next = next.next;    
        }
    
        node p = new node(line, next);
    
        q.next = p;
    }   
    else {
        q = head;
      
        while (q.next != null){
            q = q.next;}
    
        node p = new node(line, null);
    
        q.next = p;
    }
   }   

// $delete m n
//Each line in text between lines m and n inclusively will be deleted

   public void delete(int m, int n ){
    
    if (m==1){    
    for (int i = 0; i < m-1; i++)
        head = head.next;
    q = head;
    for (int i = m; i <= n; i++)
        q = q.next;
    head.next = q.next;
    }
    else if (n == countList() ){
        q = head;
      
        for (int i = 0; i < m-1; i++)
            q = q.next;
        q.next = null;
    }  
    
    else {
        q = head;
      
    for (int i = 0; i < m-1; i++)
        q = q.next;

    node start = q;
    for (int i = m; i <= n; i++)
        q = q.next;
    
   start.next = q.next;} 
   }

 /*$print m n
	Display the lines m and n inclusively along with their line
     numbers. If the parameters m and n are missing, print the
     entire text*/

   public void print(int m, int n ){
   q = head;  
    for (int i = 0; i < m; i++)
        q = q.next;

    for (int i = m; i <= n; i++){
        System.out.println(i + ".  " + q.line);
        q = q.next;
    }
   //start.next = q.next;
   }

 
 /*$line m Line m becomes the current line. The program should display       
 up to 3 lines of text along with their line numbers before
and after the current line depending on whether there is
enough text in the linked list*/
 
 public void current(int m){
    
    q = head;  
    current = m;
  
    
    if (m < 4)
    {
     for (int i = 0; i < m +3; i++){
        q = q.next;
         System.out.println((i+1) + ".  " + q.line);
        }
    }
    else if (m > countList() - 3){
        q = head;
        for (int i = 0; i < m-3; i++)
           q = q.next;
        node mid = q;
            //System.out.println((i+1) + ".  " + q.line);
        
        for (int i = m-3; i < countList(); i++){
            
            System.out.println((i) + ".  " + mid.line);
        mid = mid.next;    
        }
       
    }  
    else {
        q = head;
        for (int i = 0; i < m-4; i++)
           q = q.next;
        
        for (int i = m-4; i < m +3; i++){
        q = q.next;
         System.out.println((i+1) + ".  " + q.line);
        }
    }
  
 }

 /*$search string	
	Search for the string in the text. If found, display the line
     that contains the first occurrence of the string*/
//need to use tokenizer?? pray for wi-fi access or save stuff tomorrow at hotel?? 
 public int search(String m){
        q = head;  
    while (q != null){
        String line = q.line;
        String yourstring;
        //StringTokenizer st = new StringTokenizer("this is a test");
        StringTokenizer mytoken = new StringTokenizer(line);
        for(int i= 0; i< mytoken.countTokens(); i++)
            {
                yourstring = mytoken.nextToken();
                if (m.equals(yourstring)){
                    System.out.println(q.line);
                    return 0;//??
                    }    
           
    }
    q = q.next;     
    
    
 }   
    System.out.println("sorry " + m + " is not in text");
    return 0;
 }
// $done
//	Terminates the execution*/
//maybe in driver  
  
}
