/*
 * @author: Anish Narsian
 * @date: 7/21/2013
 * */

/*
 * This is the Deque12 class which implements BoundedDeque<E>
 * It is a data structure of using an array and two pointers:
 * front back
 * */


public class Deque12<E> implements BoundedDeque<E> {

  //Data(Class Variables)
 private int capacity;
 private int size;
 private E[] dataArr;

 int front, back;
 
  /*
  * The constructor
  * It constructs a Deque12 with size 0, front and back pointers at 0
  * @param setCapacity is the capacity ofthe Deque12 data structure
  * @thows illegal argument exception if capacity is set to -1
  * */

 public Deque12 (int setCapacity) {
  if(setCapacity<0)
   throw new IllegalArgumentException();
  else {
   capacity = setCapacity;
   //Casting: generics and arrays aren't directly compatible
   dataArr = (E[])new Object[capacity];
   size = 0;
   front = 0; 
   back = 0;
  }
 }
 
 /**
  * Returns the capacity of this Deque12, that is,
  * the maximum number of elements it can hold.  
  * <br>PRECONDITION: none 
  * <br>POSTCONDITION: the BoundedDeque is unchanged.  
  * @return the capacity of this BoundedDeque
  */
 
 public int capacity() {
   return capacity;
 }
 
   /**
   * Returns the number of elements in this Deque12. 
   * <br>PRECONDITION: none 
   * <br>POSTCONDITION: the Deque12 is unchanged. 
   * @return the number of elements in this Deque12
   */

 public int size() {
  return size;
 }
 
 //Using opton 2 in the P3 discussion section slides
 /*
  * The adds and equals methods run such that:
  * addFirst decrements first then adds at the new front index
  * addBack adds first then increments at the back index
  * removeFirst removes first then increments at the current front index
  * removeBack decrements first then removes
  * */
 
 
  /**
   * Adds the specified element to the front of this Deque12.
   * Returns true if the operation succeeded, else false. 
   * <br>PRECONDITION: the Deque12's size is less than its capacity. 
   * <br>POSTCONDITION: the element is now the front element in this 
   * Deque12, none of the other elements have been changed, and
   * the size is increased by 1. 
   * @param e the element to add to the front of the list
   * @return <tt>true</tt> if the element was added, else <tt>false</tt>.
   * @throws NullPointerException if the specified element is null,
   * and size is less than capacity
   */
 public boolean addFront(E e) {
   if(size<capacity) { //The precondition
     if(e == null)
       throw new NullPointerException();
     else { 
       
       if(front != 0)
         front = front -1; //Decrement
       else
         front = capacity-1; //else set index to end of array
       dataArr[front] = e;  //set value
       size++;
       return true;
     }
   }
   else 
     return false;
 }
 
  /**
   * Adds the specified element to the back of this Deque12.
   * Returns true if the operation succeeded, else false. 
   * <br>PRECONDITION: the Deque12's size is less than its capacity. 
   * <br>POSTCONDITION: the element is now the back element in this 
   * Deque12, none of the other elements have been changed, and
   * the size is increased by 1. 
   * @param e the element to add to the back of the list
   * @return <tt>true</tt> if the element was added, else <tt>false</tt>.
   * @throws NullPointerException if the specified element is null,
   * and size is less than capacity
   */
 
 public boolean addBack(E e) {
   if(size<capacity) { //The precondition
     if(e == null)
       throw new NullPointerException();
     else {
       dataArr[back] = e; //set value
       if(back!= capacity-1)
         back = back + 1; //increment back
       else
         back = 0; //otherwise set it to 0
       
       size++;
       return true;    
     }
     
   }
   else 
     return false;
 }

   /**
   * Removes the element at the front of this Deque12.
   * Returns the element removed, or <tt>null</tt> if there was no such element.
   * <br>PRECONDITION: the Deque12's size is greater than zero.
   * <br>POSTCONDITION: the front element in this Deque12 has been removed,
   * none of the other elements have been changed, and
   * the size is decreased by 1.
   * @return  the element removed, or <tt>null</tt> if the size was zero.
   */
 public E removeFront() {
   if(size>0) //precondition
   {
     E e = dataArr[front];
     dataArr[front] = null;
     if(front == capacity-1) {
       front = 0; } //set front to 0
     else {
       front++; //increment front  otherwise
     }
     
     size--;
     return e;
   }
   else
     return null;
 }
 
   /**
   * Removes the element at the back of this Deque12.
   * Returns the element removed, or <tt>null</tt> if there was no such element.
   * <br>PRECONDITION: the Deque12's size is greater than zero.
   * <br>POSTCONDITION: the back element in this Deque12 has been removed,
   * none of the other elements have been changed, and
   * the size is decreased by 1.
   * @return  the element removed, or <tt>null</tt> if the size was zero.
   */
 

 public E removeBack() {
   if(size>0) //precondition
   {
     if(back == 0)
       back = capacity-1; //Set back to end of array
     else
       back--; //Otherwise decrement
     E temp = dataArr[back]; 
     dataArr[back] = null; //Set value
     size--;
     return temp;
   }
   else
     return null;
 }
 
 
 /**
   * Returns the element at the front of this Deque12,
   * or <tt>null</tt> if there was no such element.
   * <br>PRECONDITION: the Deque12's size is greater than zero.
   * <br>POSTCONDITION: The Deque12 is unchanged.
   * @return  the element at the front, or <tt>null</tt> if the size was zero.
   */
 
 public E peekFront() {
   if(size>0) //precondition
   {
     return dataArr[front];
   }
   else
     return null;
 }

 
  /**
   * Returns the element at the back of this Deque12,
   * or <tt>null</tt> if there was no such element.
   * <br>PRECONDITION: the Deque12's size is greater than zero.
   * <br>POSTCONDITION: The Deque12 is unchanged.
   * @return  the element at the back, or <tt>null</tt> if the size was zero.
   */
 
 public E peekBack() {
   int tempBack = 0;
   if(size>0) //precondition
   { 
     if(back == 0)
       tempBack = capacity-1;
     else
       tempBack = back-1;
     return dataArr[tempBack];
   }
   else 
     return null;
 }
 
   /**
   * Compares the specified object with this Deque12 for equality.
   * Returns true if and only if the specified object is
   * also a Deque12 of the same type, both have the same size, and the
   * corresponding pairs of elements in the two are
   * equal. Two elements e1 and e2 are equal if e1.equals(e2).
   * "Corresponding pairs" means: the pair of front elements,
   * the pair of next-to-front elements, and so on through to
   * the pair of back elements.
   * @return true if the specified Object is equal to this Deque12
   * @param  o the Object to compare to this BoundedDeque for equality
   *
   */
 public boolean equals(Object o) {
   if(!(o instanceof Deque12)) //Checks if the object is Deque12
     return false;
   if(o == null) //Cannot compare with null
     return false;
   //Casting o to Deque 12: for adapter pattern and to make comparable
   Deque12<E> d12= (Deque12<E>)o; 
   if(d12.size == 0 && this.size ==0) //Empty Deque12's always equal
     return true;
   int x = d12.back; //x=back index value
   int y = this.back; 
   if(this.size != d12.size) //Unequal size --> unequal Deque12's
     return false;
   
   for(int i = 0; i<size; i++) {
     x--; //Decrement since back index is always one ahead of last set value
     y--;
     if(y < 0)
       y = capacity-1;
     if(x < 0 )
       x = d12.capacity-1;
     if(!((d12.dataArr[x]).equals(dataArr[y]))) { 
       return false;
     }
   }
   return true;
 }
 
 //End of Deque12 class
}







 













