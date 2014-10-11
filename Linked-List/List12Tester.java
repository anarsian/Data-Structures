/*@author: Anish Narsian
 *@date: 07/08/2013
 * */

import java.util.*;
import junit.framework.*;
import java.io.*;

/*This is a tester class "List12Tester" to test lists
 * */

public class List12Tester extends junit.framework.TestCase
{
//Testing the boolean Add method
  
  
  /*Tests the Add method using Contains*/  
  public void testAddContains() {
   List<String> theL = new List12<String>();
              theL.add("A");
              theL.add("B");
              assertTrue(theL.contains("A"));
              assertTrue(theL.contains("B"));
              assertFalse(theL.contains("C"));
 }
 
 /*Tests the Add method using Get*/
  public void testAddGet() {
    List<Integer> theL = new List12<Integer>();
        for(int i=1; i<=50; i++) {
          theL.add(i); //Add 50 elements
        }
        for(int i=0; i<50; i++) {
          //i^th index should store i+1 value
          assertEquals(theL.get(i),new Integer(i+1));
        }
  }
  
  
  /*Tests the Add method using its default return value*/
  public void testAddReturn() {
    List<String> theL = new List12<String>();
    assertTrue(theL.add("A")); //Return true if add successful
        assertTrue(theL.add("B"));
        assertTrue(theL.add("A"));
 }
  
  /*Tests the Add method using Size*/
  public void testAddSize() {
    List<String> theL = new List12<String>();
    theL.add("A");
    assertEquals(theL.size(), 1);
  }
  
  /*Tests the Add method using IndexOf of Add to test correctness of 
   * the Index at which element is added  * */
  public void testAddIndexOf() {
    List<Integer> theL = new List12<Integer>();
    for(int i=1; i<=50; i++) {
      theL.add(i);
      assertEquals(theL.indexOf(i+1), -1);
      assertEquals(theL.indexOf(i), i-1);
    }
  }
  
  /*Tests the Add method by adding null and ensuring it works*/
  public void testAddNULLAdd() {
    List<String> theL = new List12<String>();
    theL.add("A");
    theL.add("B");
    //assertNotNull(theL.contains(null));
    theL.add(null);
    assertTrue(theL.contains(null));
  }




  //Testing the void Add method
  
  /*Tests the void Add method using Contains*/
  public void testVoidAddContains() {
    List<Integer> theL = new List12<Integer>();
    for(int i=1; i<=50; i++) {
      theL.add(i);
    }
    theL.add(25, 10000);
    assertTrue(theL.contains(10000));
  }
  
  /*Tests the void Add method using Get*/
  public void testVoidAddGet() {
    List<Integer> theL = new List12<Integer>();
    for(int i=1; i<=50; i++) {
      theL.add(i-1,i);
    }
    //theL.add(10000, 25);
    for(int i = 0; i<50; i++){
   
   assertEquals(theL.get(i), new Integer(i+1));
 }
  }
  
  public void testVoidAddSize() {
    List<Integer> theL = new List12<Integer>();
    for(int i=1; i<=50; i++) {
        theL.add(i);
        }
 theL.add(7, 25);
 assertEquals(theL.size(), 51);
  }

  public void testVoidAddIndexOf() {
    List<Integer> theL = new List12<Integer>();
    //theL.add(50);
    for(int i=1; i<=50; i++) 
    {
      theL.add(i);
    }
    theL.add(7, 25);
    assertEquals(theL.indexOf(25), 7);
  }

  //Testing Index out of Bounds for the void Add method

  public void testVoidAddOutOfBounds() {
 List<Integer> theL = new List12<Integer>();
 theL.add(1);
 theL.add(2);
 //for(int i=3; i<=50; i++) {
  try {
  //theL.add(i);
  theL.add(3, 5);
  fail("Expected IndexOutOfBoundsException for the Add method");
  }
  catch(IndexOutOfBoundsException e){
  //theL.add(i);
  System.out.println("Test Passed for IndexOutOfBoundsException in the Add method");

         }
 //}
  }





  //Testing the Set method
 public void testSetGet() {
 List<Integer> theL = new List12<Integer>();
 for(int i=1; i<=50; i++) {
         theL.add(i);
        }

 for(int i = 51; i<=100; i++) {
  theL.set(i-51, i);
  assertEquals(theL.get(i-51), new Integer(i)) ;
  //assertNotEquals(theL.get(i-51), new Integer(i-51));
 }
 }

 public void testSetContains() {
  testContainsSet();
 }

 public void testSetIndexOf() {
 List<Integer> theL = new List12<Integer>();
 for(int i=1; i<=50; i++) {
         theL.add(i);
        }
 
 for(int i = 51; i<=100; i++) {
 theL.set(i-51, i);
 assertEquals(new Integer(theL.indexOf(i)), new Integer(i-51)) ;
 assertEquals(new Integer(theL.indexOf(i-51)), new Integer(-1));
 }
 }

 public void testSetSize() {
  List<Integer> theL = new List12<Integer>();
  theL.add(1);
  theL.add(2);
  theL.set(0,5);
  assertEquals(theL.size(), 2);
  theL.set(1, 6);
  assertEquals(theL.size(), 2);
 }


//Testing the IndexOutOfBoundsException for the Set method

 public void testSetIndexOutException() {
 List<Integer> theL = new List12<Integer>();
 for(int i=1; i<=50; i++) {
         theL.add(i);
  try {
   theL.set(i, i);
   fail( "Expected IndexOutOfBoundsException for the Set method");
  }
  catch(IndexOutOfBoundsException e)  {
  System.out.println("test Passed for IndexOutOfBoundsException in the Set method");
  }
 }
 
 }



 

 //Testing the Remove(int Index) method
 
 public void testRemoveContains() {
  testContainsRemove();
 }

 public void testRemoveGet() {
  testGetRemove();
 }

 public void testRemoveReturn() {
   List<String> theL = new List12<String>();
          theL.add("A");
          theL.add("B");
   assertEquals(theL.remove(0), "A");
 }

 public void testRemoveSize() {
   List<String> theL = new List12<String>();
          theL.add("A");
          theL.add("B");
   theL.remove(1);
   assertEquals(theL.size(), 1);
 }

 //testing the IndexOutOfBoundsException for this
 
 public void testRemoveException() {
  List<String> theL = new List12<String>();
         theL.add("A");
         theL.add("B");
  try {
   theL.remove(3);
   fail(" Expected IndexOutOfBoundsException for the Remove method");
  }
  catch(IndexOutOfBoundsException e)  {
  System.out.println("test Passed for IndexOutOfBoundsException in the Remove method");
  }
 }








//Testing the Remove(Object o) method

 public void testRemoveObjContains() {
   List<String> theL = new List12<String>();
          theL.add("A");
          theL.add("B");
   theL.remove("A");
   assertFalse(theL.contains("A"));
 }

 public void testRemoveObjGet() {
   List<String> theL = new List12<String>();
          theL.add("A");
          theL.add("B");
   theL.remove("A");
   assertEquals(theL.get(0), "B");
 }

 public void testRemoveObjIndexOf() {
   List<String> theL = new List12<String>();
          theL.add("A");
          theL.add("B");
   theL.remove("A");
   assertEquals(theL.indexOf("B"), 0);
 }

 public void testRemoveObjReturn() {
   List<String> theL = new List12<String>();
          theL.add("A");
          theL.add("B");
   assertTrue(  theL.remove("A"));
 }
 
 




 





//Testing size
//
//1. Tested by testAddSize
//2. Tested by testVoidAddSize
//3. Tested by testSetSize
//4. Tested by testRemoveSize


// public void 



 


 //Testing the contains method
 public void testContainsAdd() {
   List<String> theL = new List12<String>();
          theL.add("A");
          theL.add("B");
          assertTrue(theL.contains("A"));
          assertTrue(theL.contains("B"));
          assertFalse(theL.contains("C"));
 }

 public void testContainsRemove() {
 List<Integer> theL = new List12<Integer>();
 for(int i=1; i<=50; i++) {
        theL.add(i);
        }

 theL.remove(25);
 
 assertFalse(theL.contains(26));
 }

 public void testContainsSet() {
 List<Integer> theL = new List12<Integer>();
 for(int i=1; i<=50; i++) {
         theL.add(i);
        }

 for(int i = 51; i<=100; i++) {
  theL.set(i-51, i);
  assertTrue(theL.contains(i));
  assertFalse(theL.contains(i-50));
 }
 }

 //Testing class cast exception for the Contains method
 
/* public void testContainsTypeCheck() {
  List<Integer> theL = new List12<Integer>();
  for(int i=1; i=50; i++) {
         theL.add(i); 
  assertEquals( theL.contains("a"), ClassCastException);
        }
 }*/





 //Testing the get method
 //
 //1. Tested by testVoidAddGet()
 //2. tested by testAddGet();
 //3. Tested by testSetGet();


 public void testGetRemove() {
 List<Integer> theL = new List12<Integer>();
 theL.add(1);
 theL.add(2);
 theL.add(3);
 theL.remove(0);
 assertEquals(theL.get(0), new Integer(2));
 /*for(int i=1; i<=50; i++) {
         theL.add(i);
        }

 for(int i = 1; i<=50; i++) {
  theL.remove(i-1);
  assertEquals(theL.get(i-1), new Integer(i+1));
 }*/
 }

  //testing Index out of Bounds exception in the get method
 
 public void testGetReturn() {
  List<Integer> theL = new List12<Integer>();
  //assertEquals(theL.get(0), IndexOutOfBoundsException);
  for(int i = 1; i <= 50; i++) {
   theL.add(i);
   try {
    theL.get(i);
    fail("Expected IndexOutOfBoundsException for the get method");
   }
   catch (IndexOutOfBoundsException e)
   {
    System.out.println("test Passed for IndexOutOfBoundsException in the Get method");
   //assertEquals(theL.get(i), IndexOutOfBoundsException);
   }
  }
  
  theL.add(1);
   
    try {
    theL.get(-1);
    fail("Expected IndexOutOfBoundsException for the get method");
   }
   catch (IndexOutOfBoundsException e)
   {
    System.out.println("test Passed for IndexOutOfBoundsException in the Get method");
   //assertEquals(theL.get(i), IndexOutOfBoundsException);
   }
   
   

   //assertEquals(theL.get(-1), IndexOutOfBoundsException );
  }
 




    
 

public static void main(String args[]){
              junit.textui.TestRunner.main(new String[] {"List12Tester"});
            }
 







 
 


}
