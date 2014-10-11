/*
 * @author: Anish Narsian
 * @Date: 07/21/2013
 * */

/*
 * This is the stack12 class 
 * @implements BoundedStack<E>
 * It uses a Deque adapter pattern
 * */

import java.io.*;
import java.lang.*;
public class Stack12<E> implements BoundedStack<E> {
  
  private Deque12<E> stack;
  private int size;
  private int capacity;
  
  /*
   * This is the constructor for Stack12
   * */
  
  public Stack12 (int setCapacity) {
    if(setCapacity<0)
      throw new IllegalArgumentException();
    else
      capacity = setCapacity;
    stack = new Deque12<E>(capacity);
  }
  
  
   /**
   * Removes the element at the top of this Stack.
   * Returns the element removed, or <tt>null</tt> if there was no such element.
   * <br>PRECONDITION: the Stack's size is greater than zero.
   * <br>POSTCONDITION: the top element in this Stack has been removed,
   * none of the other elements have been changed, and
   * the size is decreased by 1.
   * @return  the element removed, or <tt>null</tt> if the size was zero.
   */   
  public E pop() {
    return stack.removeBack();
  }
  
  
   /**
   * Returns the capacity of this Stack, that is,
   * the maximum number of elements it can hold.
   * <br>PRECONDITION: none
   * <br>POSTCONDITION: the Stack is unchanged.
   * @return the capacity of this Stack
   */
  
  public int capacity() {
    return stack.capacity();
  }
  
  
   /**
   * Returns the number of elements in this Stack.
   * <br>PRECONDITION: none
   * <br>POSTCONDITION: the Stack is unchanged.
   * @return the number of elements in this Stack
   */
  
  public int size() {
    return stack.size();
  }
  
  /**
   * Adds the specified element to the top of this Stack.
   * Returns true if the operation succeeded, else false.
   * <br>PRECONDITION: the BoundedStack's size is less than its capacity.
   * <br>POSTCONDITION: the element is now the top element in this
   * Stack, none of the other elements have been changed, and
   * the size is increased by 1.
   * @param e the element to add to the Stack
   * @return <tt>true</tt> if the element was added, else <tt>false</tt>.
   * @throws NullPointerException if the specified element is null,
   * and size is less than capacity
   */  
  public boolean push(E e) {
    return stack.addBack(e);
  }
  
  
  /**
   * Returns the element at the top of this Stack,
   * or <tt>null</tt> if there was no such element.
   * <br>PRECONDITION: the Stack's size is greater than zero.
   * <br>POSTCONDITION: The Stack is unchanged.
   * @return  the element at the top, or <tt>null</tt> if the size was zero.
   */
  
  public E peek() {
    return stack.peekBack();
  }
  
  
  
    /**
   * Compares the specified object with this Stack for equality.
   * Returns true if and only if the specified object is
   * also a Stack of the same type, both have the same size, and the
   * corresponding pairs of elements in the two are
   * equal. Two elements e1 and e2 are equal if e1.equals(e2).
   * "Corresponding pairs" means: the pair of top elements,
   * the pair of next-to-top elements, and so on through to
   * the pair of bottom elements.
   * @return true if the specified Object is equal to this Stack
   * @param  o the Object to compare to this Stack for equality
   */
  
  public boolean equals(Object o) {
    if(!(o instanceof Stack12) || (o==null)){ 
      return false; 
    } 

    else {
      Stack12<E> other = (Stack12<E>) o;    //Deque12    
      return this.stack.equals(other.stack);
    } 
    
}
    
    
}
  
  