public class List12<E> implements java.util.List<E> {

Node<T> head;

private int size  = 0;

//Complete constructor for List12

public List12<E>();

private static class Node<T> 
{
   private T data;
   private Node<T> next;
   private Node<E> head;
   public LinkedList() {
      head = null;
   }
   Node(T data, Node<T> next) {
      this.data = data;
      this.next = next;
   }
   Node(){
      this.data = null
      this.next = null
   }

   public Node<T> getNext() {
	return this.next;
   }

   public void setNext(Node<T> successor) {
      this.next = successor;
   }

   public E getData() {
      return this.data;
   }

   //remember to check if a different kind of data added then appropriate error message printed
   public void setData(E newData) {
      this.data = newData;
   }

}


//for addFirst(Size = 0) there is a possibility that you will need to refer to Lecture 5 and use Node newNode = new Node(o, head); and so on
public boolean add(E o) {
   Node<E> cursor = head;
   Node newNode  = new Node(o, null);
   if(size>0) { //Or refer to Lecture 5 if this doesnt work
      for(int i = 0; i<size(); i++) {
         cursor = cursor.getNext();
      }
  // newNode = new Node(o, null);
   cursor.setNext(newNode);
   }
   else if(head == null) {
      head = newNode; 
      cursor = head;
   }


   
   
   if(cursor.getNext().equals(newNode) {
      return true;
      size++;
   }
   else
      return false;
}






public void add(int index, E element) {
   Node<E> cursor = head;
   if(size<0 || index>size) 
      throw new IndexOutOfBoundsException;
   
   else if(size>0) {

      while(--index>0) 
         cursor = cursor.getNext();
      Node newNode = new Node(element, null);
      newNode.setNext(cursor.getNext());
      cursor.setNext(newNode);
      size++;
   }
   else if(size ==0) {
      add(element);
      size++;
   }

}

	

public boolean contains(Object o) {
   Node<E> cursor = head;

   for(int i =0; i<size()-1;i++) {
      if(o ==cursor.getData()
         return true;
   }

   return false;
}


public E get(int index) {
   Node<E> cursor = head;
   while(--index>=0)
      cursor = cursor.getNext();
   return cursor.getData();

}



public Iterator<E> iterator () {



}


public E remove(int index) {
   Node<E> cursor = head;
   if(size<0 || index>size) {
      throw new IndexOutOfBoundsException;   
      return null;
   else if(index == 0) {
      Node newNode = cursor.getNext()
      cursor.next() = cursor.next().next();
      return newNode;
      
   else {
      Node<E> cursor = head;
      while(--index>0)
         cursor = cursor.getNext();
      Node newNode = cursor.getNext()
      cursor.next= cursor.next.next;
      return newNode;  
      size--;  
      }
   }
}


public boolean remove(Object o) {
   if(o == head) {   
      head = head.next;
      size--;
      return true;
   }
   else {  	
      Node<E> cursor1 = head;
      Node<E> cursor2 = cursor1.getNext();
      for(int i = 0; i<size-1; i++) {
         //cursor = cursor.getNext(); //May have used .next instead of getNext(). -check This will cause loss of data
         if(o == cursor2) {
            cursor1.setNext(cursor2.next);
            size--;
            return true;
         }
         else {
            cursor1 = cursor1.getNext();
            cursor2 = cursor2.getNext();
      
         }
      }    
   }
   return false;
}


public E set(int index, E elements) {
   if(size<0 || index>size) {   
      throw new IndexOutOfBoundsException
      return null;
   }
   else {
      Node<E> cursor = head;
      while(--index>0) {
         cursor = cursor.getNext();
      }
      Node returnNode = new Node(cursor.getNext());
      cursor.setNext( E);
      return returnNode;

   }
}

public int size() {
   return size;

}

}
