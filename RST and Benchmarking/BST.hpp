/*
 * @Author: Anish Narsian, Dhanuk Withana
 * @Date: 11 October 2013
 * This is the BST.hpp file
 * It Defines the methods: insert, find, size, empty, begin, end, inorder
 * These functions are the main functions required on a Binary Search Tree
 * */



#ifndef BST_HPP
#define BST_HPP
#include "BSTNode.hpp"
#include "BSTIterator.hpp"
#include <iostream>

template<typename Data>
class BST {

protected:

  /** Pointer to the root of this BST, or 0 if the BST is empty */
  BSTNode<Data>* root;

  /** Number of Data items stored in this BST. */
  unsigned int isize;

public:

  /** define iterator as an aliased typename for BSTIterator<Data>. */
  typedef BSTIterator<Data> iterator;

  /** Default constructor.
      Initialize an empty BST.
   */
  BST() : root(0), isize(0) {  }


  /** Default destructor.
      Delete every node in this BST.
   */ // TODO
  virtual ~BST() {
	deleteAll(root);
  }

  /** Given a reference to a Data item, insert a copy of it in this BST.
   *  Return  true if the item was added to this BST
   *  as a result of this call to insert,
   *  false if an item equal to this one was already in this BST.
   *  Note: This function should use only the '<' operator when comparing
   *  Data items.
   */ // TODO
  virtual bool insert(const Data& item) {
    //Insert to an empty BST
    if(root == NULL){
      root = new BSTNode<Data> (item);
      isize++;
      return true;
    }
    
    BSTNode<Data>* currNode = root;
    while(true){
      if( item < currNode->data ) {
       //goto left sub tree
  	  if(currNode->left == NULL )
	  {
    	    currNode->left = new BSTNode<Data> (item);
   	    currNode->left->parent = currNode; //Set parent
    	    isize++; //Increment Size
    	    return true;
	  }
	  else
	  {
	    //Go further to the left and then check next condition
	    currNode= currNode->left; 
	  }
      }
      else if(currNode->data < item)
      {
	  //goto right sub tree
	  if(currNode->right == NULL )
   	  {
    	    currNode->right = new BSTNode<Data> (item);
   	    currNode->right->parent = currNode; //Set Parent
    	    isize++;
    	    return true;
	  }
	  else
	  {
	    //Go further to the right and then check next condition
	    currNode = currNode->right;
	  }
      }	
      else if (currNode->data == item)
          return false;
   } 
} //End of Method


  /** Find a Data item in the BST.
   *  Return an iterator pointing to the item, or pointing past
   *  the last node in the BST if not found.
   *  Note: This function should use only the '<' operator when comparing
   *  Data items.
   */ // TODO
  iterator find(const Data& item) const {
    if(root == NULL)
      return end();

    BSTNode<Data>* currNode = root;
    while(true){

       if( item < currNode->data ) {
         //left subtree if item is less than the data of current node
         currNode = currNode->left;
       }
       else if(currNode->data < item) {
         //right subtree if item is greater than data of current node
         currNode = currNode->right;
      }	
       
       else return typename BST<Data>::iterator(currNode);
       //If currNode == false
       if(!currNode){
          return end();
   	} 
       }

}


  
  /** Return the number of items currently in the BST.
   */ // TODO
  unsigned int size() const {
   return isize;
  }

  /** Return true if the BST is empty, else false.
   */ // TODO
  bool empty() const {
   return root == NULL;
  }

  /** Return an iterator pointing to the first item in the BST.
   */ // TODO
  iterator begin() const {
    return typename BST<Data>::iterator(first(root));
    

  }

  /** Return an iterator pointing past the last item in the BST.
   */
  iterator end() const {
    return typename BST<Data>::iterator(0);
  }

  /** Perform an inorder traversal of this BST.
   */
  void inorder() const {
    inorder(root);
  }


private:

  /** Recursive inorder traversal 'helper' function */
  void inorder(BSTNode<Data>* n) const {
    //The inorder traversal instructions
    if(n==0) return;
    inorder(n->left);
    std::cout << *n << std::endl;
    inorder(n->right);
  }

  /*
   *The first element traversed by inorder
   **/
  static BSTNode<Data>* first(BSTNode<Data>* root) {
    //Finds the smallest data item
    if(root == 0) return 0;
    while(root->left != 0) root = root->left;
    return root;
  }

  /*
   * do a postorder traversal, deleting nodes
   * */
  static void deleteAll(BSTNode<Data>* n) {
    if (0 == n) return;
    deleteAll(n->left); //Delete Left
    deleteAll(n->right);//Delete Right
    delete n;
  }


 };


#endif //BST_HPP
