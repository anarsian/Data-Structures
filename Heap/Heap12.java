/*
 *@ author - Rajat Shah - cs12uco
 *
 */
  public class Heap12<E extends Comparable<? super E>> 
  implements PQueue<E>{
    private int size;  //size of the heap
    private int cap;   //capacity of the heap
    private E[] heap;
    
    // public constructor
    
    public Heap12(){
        size = 0;
        cap = 5;
        heap = (E[]) new Comparable[cap];
        }
    
    // private constructor making a deep copy of the 
    // passed in array
    
    private Heap12(E[] sortArray){ 
        if(sortArray == null)
            throw new NullPointerException();
        size = 0;
        cap = sortArray.length;
        heap = sortArray;
        }
  
  
  /**
   * Adds the specified element to this PQueue.
   * <br>PRECONDITION: the element to add is not null.
   * <br>POSTCONDITION: the element has been added to this PQueue,
   * none of the other elements have been changed,
   * and the size is increased by 1.
   * @param e The element to add.
   * @throws NullPointerException if the
   * specified element is <tt>null</tt>.
   */
   
    public void add(E e){
        if(e == null)
            throw new NullPointerException();
        if (size < cap ){
            this.heap[size] = e;
            }
       else if(size == cap){
            E[] heap1 = (E[]) new Comparable[2*cap];
            for (int i =0; i < cap; i++){
                heap1[i] = heap[i];
                } 
            heap = heap1;
            heap[size] = e;
            this.cap = (this.cap * 2); 
            }
        int parent = (size-1)/2;
        if(parent >= 0 && (max(this.heap,size,parent) == size) )
            bubbleUp(size);
        size++;
   }
  
    /**
     * cheks if the two heaps are equal
     * i.e, same layout of the parent 
     * and the children
     */  
  
    public boolean equals(Object o){
        if (!(o instanceof Heap12))
            return false;
        Heap12 other = (Heap12) o;
        if(this.size == other.size){
            if (this.size == 0)
                return true;
        for (int i = 0; i < this.size; i++){
            if(this.heap[i].equals(other.heap[i])){}
            else{
                return false;
                }
            }
            return true;
        }
        else{
            return false;
            }
   }



   /**
    * assigns a unique code to every heap element
    * if two hash codes are equal, then the two
    * heaps are equal
    */

    public int hashCode(){
        int code = 0;
        for(int i =0; i < size; i++){
            code = 31*code + this.heap[i].hashCode();
            }
        return code;
        }
  
  
  /**
   * Determine if this PQueue contains any elements.
   * <br>PRECONDITION: none
   * <br>POSTCONDITION: the PQueue is unchanged.
   * @return <tt>true</tt> if this PQueue is empty,
   * <tt>false</tt> otherwise.
   */
    
    public boolean isEmpty(){
        return (size==0);
        }
   
   
  /**
   * Returns the element in this PQueue that would
   * be returned by <tt>remove()</tt>.
   * <br>PRECONDITION: this PQueue contains at least one element.
   * <br>POSTCONDITION: the PQueue is unchanged.
   * @return The highest priority element in this
   * PQueue, or <tt>null</tt> if none.
   * @see #remove()
   */
   
    public E peek(){
        if(size == 0)
            return null;
        else
        return this.heap[0];
        }
 
 
  /**
   * Removes and returns the highest priority element in this PQueue.
   * If more than one element has the same highest priority, one
   * of them is removed and returned.
   * <br>PRECONDITION: this PQueue contains at least one element.
   * <br>POSTCONDITION: the highest priority
   *  element has been removed from
   * this PQueue, none of the other elements have been changed,
   * and the size is decreased by 1.
   * @return The highest priority element in
   * this PQueue, or <tt>null</tt> if none.
   */
    
    public E remove(){
        if(size == 1){
            E element = heap[0];
            //heap[0] = null;
            size--;
            return element;
        }
        if(size == 2){
            E element = heap[0];
            heap[0] = heap[1];
            //heap[1] = null;
            size--;
            return element;
            }
        if(size > 2){
        E element = this.heap[0];
        this.heap[0] = this.heap[size-1];
        //heap[size-1] = null;
        int k = max(this.heap,1,2);
        if(max(this.heap,0,k) == k)
            trickleDown(0);
        size--;
        return element;
        }
        else{
            return null;
            }
        }


  /**
   * Returns the number of elements in this PQueue.
   * <br>PRECONDITION: none
   * <br>POSTCONDITION: the PQueue is unchanged.
   * @return the number of elements in this PQueue.
   */

    public int size(){
        return this.size;
        }
    
    /**
     * Takes in the array. Makes a heap object of the array 
     * and then sorts the array in ascending order.
     */

    public static<T extends java.lang.Comparable<? super T>>
    void sort(T[] a){
       Heap12 sorting = new Heap12(a);
      
       for(int i = 0; i < a.length; i++){
           sorting.add(a[i]);
           } 
      
       for(int i = sorting.size()-1; i >= 0; i--){
           sorting.heap[i] = sorting.remove();
           }
        }
    
    
    /**
     * checks if the parent is smaller than the bigger 
     * of the two children. If so, it swaps the parent 
     * with the child. Also checks if the children are 
     * not null.
     */

    private void trickleDown(int index){
        int leftChild = 2*index +1;
        int rightChild = 2*index +2;
        if( leftChild >= size)
            return;
        if(leftChild  == (size -1)){
            if(max(heap,index,leftChild) == leftChild)
                swap(heap,index,leftChild);
              trickleDown(leftChild);
        }
        if(rightChild <= (size-1)){
        int big = max(heap,leftChild,rightChild);
        if(max(this.heap,index,big) == big)
           swap(heap,index,big);
        trickleDown(big);
        }
    }
    
    /**
     * checks recursively if the child is bigger than 
     * the parent. If so, swap the child and the parent 
     *
     */

    private void bubbleUp(int index){
        if(index == 0)
            return;
        int parent = (index - 1) / 2;
        if (max(this.heap,index,parent) == index)
            swap(heap,parent,index);
        bubbleUp(parent);
        }
    
    /**
     * returns the index of the heap array which contains
     * the bigger of the two children
     */
   
    private int max(E[] array, int i, int j){
        if(array[i].compareTo(array[j]) > 0)
            return i;
        else if( array[i].compareTo(array[j]) < 0)
            return j;
        else 
            return i;
        }
    /**
     * swaps the lesser element with the greater element
     */

    private void swap(E[] array,int lesser, int greater){
        E subsi = array[lesser];
        array[lesser] = array[greater];
        array[greater] = subsi;
        }
    
    }
