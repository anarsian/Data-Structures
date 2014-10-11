/*
 * @author: Anish Narsian
 * @Date: 07/21/2013
 * */

/*
 * This is the tester class for Deque12 and conducts junit testing
 * to ensure that everything works perfectly
 * */

import java.util.*;
import junit.framework.*;
import java.io.*;
import java.lang.*;

public class BoundedDequeTester extends junit.framework.TestCase {
  
  
  /*
   * Testing the addBack using peekBack and vice versa
   * Tests to see if added at the backcorrectly
   * @return void
   * */
  
 public void testAddBackPeekBack() {
   BoundedDeque<Integer> a =  new Deque12<Integer>(30);
   for(int i = 0; i<30; i++) {
     a.addBack(i);
     assertEquals(new Integer(a.peekBack()), new Integer(i));
   }
 }
 
 public void random() {
   int x =0;
   while(x<0) ;
 }
   
 
 
 
 
 /*
  * testing the nullPointerException for AddBack
  * and ensuring it is thrown correctly
  * */
 public void testAddBackNullPointer() {
   BoundedDeque<Integer> a =  new Deque12<Integer>(30);
   for(int i = 0; i<5; i++) {
     a.addBack(i);
   }
   try {
     a.addBack(null);
     fail("Null Pointer Exception Test for addBack failed.");
   }
   catch(NullPointerException e) {}
 }
 
 
 /*
  * Testing AddBack precondition
  * (size<capacity)
  * */ 
 public void testAddBackPrecondition() {
   BoundedDeque<Integer> a =  new Deque12<Integer>(5);
   for(int i = 0; i<5; i++) {
     a.addBack(i);
   }
   assertFalse(a.addBack(6));
 }
 
   
 
 /* 
  * testing the addBack method with its return value
  * */
 public void testAddBackReturn() {
   BoundedDeque<Integer> a =  new Deque12<Integer>(30);
   for(int i = 0; i<30; i++) {
     assertTrue(a.addBack(i));
   }
 }
 
 
 
 /*
  * testing the removeBack method using PeekBack 
  * and also if its size has changed as required
  * */ 
 public void testRemoveBackPeekBack() {
   BoundedDeque<Integer> a =  new Deque12<Integer>(30);
   a.addBack(0);
   for(int i = 1; i<30; i++) {
     a.addBack(i);
     a.removeBack();
     assertEquals(a.size(), i);
     assertEquals(new Integer(a.peekBack()), new Integer(i-1));
     a.addBack(i);
   }
 }

 
 /*
  * Tests the return value for RemoveBack
  * to ensure it returns the removed elements
  * */
 public void testRemoveBackReturn() {
  BoundedDeque<Integer> a =  new Deque12<Integer>(30);
  a.addBack(0);
  for(int i = 1; i<30; i++) {
   a.addBack(i);
   assertEquals(new Integer(a.removeBack()), new Integer(i));
   a.addBack(i);
  }
 }
 
 /*
  * Testing the removeBack preCondition
  * Bounded Deque's size was greater than zero
  * */
 
 public void testRemoveBackPrecondition() {
   BoundedDeque<Integer> a =  new Deque12<Integer>(30);
   assertNull(a.removeBack());
 }
 
 
 /*
  * Testing the Add Front using peekBack and vice versa
  * also testing the precondtion is met (size<capacity)
  * */ 
 public void testAddFrontPeekFront() {
  BoundedDeque<Integer> a =  new Deque12<Integer>(30);
  for(int i = 0; i<30; i++) {
   a.addFront(i);
   assertEquals(new Integer(a.peekFront()), new Integer(i));
  }
  assertFalse(a.addFront(31));//The Precondtion test
 }
 
 
 /*
  *  testing the nullPointerException for AddFront
  * */
 public void testAddFrontNullPointer() {
   BoundedDeque<Integer> a =  new Deque12<Integer>(30);
   for(int i = 0; i<5; i++) {
     a.addBack(i);
   }
   try {
     a.addFront(null);
     fail("Null Pointer Exception Test for addFront failed.");
   }
   catch(NullPointerException e) {}
 }
 
 
/*
 * Testing the return value of the AddFront mthod
 * */
 
 public void testAddFrontReturn() {
  BoundedDeque<Integer> a =  new Deque12<Integer>(30);
  for(int i = 0; i<30; i++) {
   assertTrue(a.addFront(i));
  }
 }

 
 /*
  * Testing removeFront using PeekFront and vice versa
  * */ 
 public void testRemoveFrontPeekFront() {
  BoundedDeque<Integer> a =  new Deque12<Integer>(30);
  a.addFront(0);
  for(int i = 1; i<30; i++) {
   a.addFront(i);
   a.removeFront();
   assertEquals(new Integer(a.peekFront()), new Integer(i-1));
   a.addFront(i);
  }
 }
 
 /*
  * Testing removeFront using its return value
  * */

 public void testRemoveFrontReturn() {
  BoundedDeque<Integer> a =  new Deque12<Integer>(30);
  a.addFront(0);
  for(int i = 1; i<30; i++) {
   a.addFront(i);
   assertEquals(new Integer(a.removeFront()), new Integer(i));
   a.addFront(i);
  }
 }
 
 
 /*
  * Testing the precondition for Remove
  * size != null
  * */
 public void testRemoveFrontPrecondition() {
 BoundedDeque<Integer> a =  new Deque12<Integer>(30);
 assertNull(a.removeFront());
 }
 

 //Testing the equals method
 /*
  * Testing the equals method by adding
  * same elements at in two different Deque12's and in 
  * different locations hence covering coner testing as well
  * */
 
 public void testEquals() {
  BoundedDeque<Integer> a =  new Deque12<Integer>(30);
  BoundedDeque<Integer> b =  new Deque12<Integer>(40);
  for(int i = 5; i>0; i--)
   a.addBack(i);
  for(int i = 6; i<11; i++)
   a.addFront(i);
  for(int i =3; i>0; i--)
   b.addBack(i);
  for(int i = 4; i<11;i++)
   b.addFront(i);
  assertTrue(a.equals(b));
 }
 
 /*
  * Testing the equals method if there are two empty Deques of different types
  * */
 
 public void testEqualsEmptyDifferentTypes() {
   BoundedDeque<Integer> a =  new Deque12<Integer>(30);
   BoundedDeque<String> b =  new Deque12<String>(40);
   assertTrue(a.equals(b));
 }
 
 /*
  * Testing the equals method if there are two different types of Deques
  * */
 
 public void testEqualsDifferentTypes() {
   BoundedDeque<Integer> a =  new Deque12<Integer>(30);
   BoundedDeque<String> b =  new Deque12<String>(40);
   b.addFront("hi");
   b.addFront("how");
   b.addFront("are");
   b.addFront("you");
   
   a.addFront(2);
   a.addFront(3);
   a.addFront(4);
   a.addBack(1);
   a.addBack(0);
   assertFalse(a.equals(b));
 }
 
 
 /*
  * Testing the constructor and passing in a capacity<0
  * */
 public void testConstructorCapacity() {
   try {
     BoundedDeque<Integer> a = new Deque12<Integer>(-1);
     fail("The Incorrect capacity input test failed");
   }
   catch (IllegalArgumentException e) {}
 }
 
 /*
  * Testing size using addFront
  * */
 
 public void testSizeAddFront() {
   BoundedDeque<Integer> a = new Deque12<Integer>(30);
   for(int i = 0; i<30; i++) {
     a.addFront(i);
     assertEquals(a.size(), i+1);
   }
 }
 
 /*
  * Testing capacity
  * */
 public void testCapacity() {
   for(int i =1; i<15; i++) {
     BoundedDeque<Integer> a= new Deque12<Integer>(i);
     assertEquals(a.capacity(), i);
   }
 }
 
 /*
  * Tests the wrapping ability of Back as well as
  * addBack, peekBack, removeFront, size
  * */
 
 public void testAddBackRemoveFrontWrapping() {
   BoundedDeque<Integer> a = new Deque12<Integer>(30);
   for(int i = 0; i<30; i++) {
     a.addBack(i);
     assertEquals(a.size(), i+1);
     assertEquals(new Integer(a.peekBack()), new Integer(i));
   }
   for(int i = 0; i<15; i++) {
     assertEquals(new Integer(a.removeFront()), new Integer(i));
     assertEquals(a.size(), 29 -i);
   }
   for(int i = 30; i<45; i++) {
     a.addBack(i);
     assertEquals(a.size(), 15 +(i-29));
     assertEquals(new Integer(a.peekBack()), new Integer(i));
   }     
 }
 
 /*
  * Tests wrapping abaility of Front as well as
  * addFront, peekFront, removeBack, size
  * */
 
 public void testAddFrontRemoveBackWrapping() {
   BoundedDeque<Integer> a = new Deque12<Integer>(30);
   for(int i = 0; i<30; i++) {
     a.addFront(i);
     assertEquals(a.size(), i+1);
     assertEquals(new Integer(a.peekFront()), new Integer(i));
   }
   for(int i = 0; i<15; i++) {
     assertEquals(new Integer(a.removeBack()), new Integer(i));
     assertEquals(a.size(), 29 -i);
   }
   for(int i = 30; i<45; i++) {
     a.addFront(i);
     assertEquals(a.size(), 15 +(i-29));
     assertEquals(new Integer(a.peekFront()), new Integer(i));
   }     
 }   


 /*
  * The staic main method to begin the tests
  * */
 public static void main(String args[]){
   junit.textui.TestRunner.main(new String[] {"BoundedDequeTester"});
 }
 
 
 
 
//End of Testing class
} 





