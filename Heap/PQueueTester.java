import java.util.*;
import junit.framework.*;
import java.io.*;
import java.lang.*;


public class PQueueTester extends junit.framework.TestCase{
  
  //Testing the add method
  public void testAddRemovePeek () {
    PQueue<Integer> a =  new Heap12<Integer>();
    assertTrue(a.size() == 0);
    //assertTrue(a.capacity() == 5);
    for(int i = 0; i<5; i++) {
      a.add(i);
      assertEquals(a.peek(), new Integer(i));
      assertEquals(a.size(), i+1);
    }
    
    for(int i = 4; i>=0; i--) {
      assertEquals(a.remove(), new Integer(i));
      assertEquals(a.size(), i);
      if(i>0)
        assertEquals(a.peek(), new Integer(i-1));
      else if(i == 0)
        assertNull(a.peek());
      
    }
      
  }
  
  public void testAdd() {
    PQueue<Integer> a =  new Heap12<Integer>();
    for(int i = 7; i<15; i++) {
      a.add(i);
      assertEquals(a.peek(), new Integer(i));
      assertEquals(a.size(), i-6);
      //System.out.println(a);
    }
    for(int i = 0; i<7; i++) {
      a.add(i);
      assertEquals(a.peek(), new Integer(14));
      assertEquals(a.size(), i+9);
    }
  }
  
 /* public void testCapacity() {
    PQueue<Integer> a =  new Heap12<Integer>();
    for(int i = 0; i< 5; i++) {
      a.add(i);
      assertEquals(a.capacity(), 5);
    }
    for(int i = 5; i<10; i++) {
      a.add(i);
      assertEquals(a.capacity(), 10);
    }
    for(int i = 10; i<15; i++) {
      a.add(i);
      assertEquals(a.capacity(), 15);
    }
  }*/
  
                               
    
  
  public void testEquals() { 
    PQueue<Integer> a =  new Heap12<Integer>();
    for(int i = 0; i< 5; i++) {
      a.add(i);
      //assertEquals(a.capacity(), 5);
    }
    
    PQueue<Integer> b =  new Heap12<Integer>();
    for(int i = 0; i< 5; i++) {
      b.add(i);
      //assertEquals(a.capacity(), 5);
    }
    
    assertTrue(a.equals(b));
    b.add(2);
    assertFalse(a.equals(b));
    a.add(2);
    assertTrue(a.equals(b));
  }
  
  public void testEqualsNull() {
    PQueue<Integer> a =  new Heap12<Integer>();
    for(int i = 0; i< 5; i++) {
      a.add(i);
    }
    PQueue<Integer> b =  new Heap12<Integer>();
    assertFalse(a.equals(b));
    assertFalse(b.equals(a));
  }
  
  public void testEqualsDiffferentSartingData(){
    Heap12<Integer> p1 = new Heap12<Integer>();
    for(int i = 0; i<10; i++){
      p1.add(i);
    }
    Heap12<Integer> p2 = new Heap12<Integer>();
    for(int i = 9; i >= 0; i--){
      p2.add(i);
    }
    assertFalse(p1.equals(p2) );
  }
  
  //Testing remove for nothing the heap
  public void testRemoveNull() {
    Heap12<Integer> p1 = new Heap12<Integer>();
    assertNull(p1.remove());
  }
  
  //Testing the add for adding a null element
  public void testAddNull() {
    Heap12<Integer> p1 = new Heap12<Integer>();
    try {
      p1.add(null);
      fail("NullPointer check failed. Null element was added even though it shouldnt");
    }
    catch(NullPointerException e) {}
  }
  
  
  public void testSort() {
    //Heap12<Integer> p1 = new Heap12<Integer>();
    Integer[] a= {5, 8, 10, 3, 2, 15};
    Heap12.sort(a);
    assertEquals(a[5] , new Integer(15));
    assertEquals(a[4], new Integer(10));
    assertEquals(a[3], new Integer(8));
    assertEquals(a[2], new Integer(5));
    assertEquals(a[1], new Integer(3));
    assertEquals(a[0], new Integer(2));
  }
  
  
    
      
    //assert
  
  
    
      
 
    
                                
  
      
      
    
  
   public static void main(String args[]){
   junit.textui.TestRunner.main(new String[] {"PQueueTester"});
 }
  
  
  
    
    
  
  
  
  
  
}