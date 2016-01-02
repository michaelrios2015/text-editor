/*
 Michael Rios
COSC 600
Project 4 

 */

package project.pkg4;

/**
 *
 * @author Michael
 */
public class node {
  	
    String line;
    node next;

    public node()
    {line = ""; next = null;}
    
    public node(String line1, node n)
    {line = line1; next =n;}
  
}
