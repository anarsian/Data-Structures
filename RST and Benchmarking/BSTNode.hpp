/*
 * @author: Anish Narsian, Dhanuk Withana
 * @Date: 11 October 2013
 * This is the BSTNode file
 * It defines all the nodes: left, right and parent as well as data field
 * It has a successor function
 *
 * */
#ifndef BSTNODE_HPP
#define BSTNODE_HPP
#include <iostream>
#include <iomanip>
template<typename Data>
class BSTNode {

public:
  

  /** Constructor.  Initialize a BSTNode with the given Data item,
   *  no parent, and no children.
   */
  BSTNode(const Data & d) : data(d) {
    left = right = parent = 0;
    priority = rand();
  }

  unsigned int priority;
  BSTNode<Data>* left;
  BSTNode<Data>* right;
  BSTNode<Data>* parent;
  Data const data;   // the const Data in this node.

  /** Return the successor of this BSTNode in a BST, or 0 if none.
   ** PRECONDITION: this BSTNode is a node in a BST.
   ** POSTCONDITION:  the BST is unchanged.
   ** RETURNS: the BSTNode that is the successor of this BSTNode,
   ** or 0 if there is none.
   */ // TODO
  BSTNode<Data>* successor() {
    if (right!= NULL){
      return right->lastLeftNode();
    }
    else if (parent == NULL) { return 0; }
    else if (this == parent ->left) { return parent; }
    else { return parent -> lastSucc(); }
  }
  /*
   *This is a helper method that recursively returns the lowest Left node
   *@return a BSTNode
   */
  BSTNode<Data>* lastLeftNode(){
    if(left != NULL)
      return left-> lastLeftNode();
    else
      return this;
  }

 /*
  *This is a helper method lastSucc
  *Checks if this is the right node
  *@return BSTNode
  */ 
    
  BSTNode<Data>* lastSucc(){
        
    if (parent == NULL) { return 0;}
    else if (this == parent->right) {
      return parent-> lastSucc();
    }
    else { return parent;}
            
  }



};

 

/** Overload operator<< to print a BSTNode's fields to an ostream. */
template <typename Data>
std::ostream & operator<<(std::ostream& stm, const BSTNode<Data> & n) {
  stm << '[';
  stm << std::setw(10) << &n;                 // address of the BSTNode
  stm << "; p:" << std::setw(10) << n.parent; // address of its parent
  stm << "; l:" << std::setw(10) << n.left;   // address of its left child
  stm << "; r:" << std::setw(10) << n.right;  // address of its right child
  stm << "; d:" << n.data;                    // its data field
   stm << "; pr:" << std::setw(10) << n.priority;  // address of its right child
  stm << ']';
  return stm;
}

#endif // BSTNODE_HPP
