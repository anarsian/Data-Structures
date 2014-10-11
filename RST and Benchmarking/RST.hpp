/*
 * @author: ANish Narsian, Dhanuk Withana
 * Description: This is the file called RST.hpp it has 
 * the insert method. The RST uses a random key to sort
 * elements
 * */

#ifndef RST_HPP
#define RST_HPP
#include "BST.hpp"
#include <ctime>
#include <cstdlib>


template <typename Data>
class RST : public BST<Data> {
/////////////////////////
public:

/*
 * This is the main insert method
 * @return: boolean true if insert passed
 *
 **/

virtual bool insert(const Data& item){

if(this->root == NULL){
  this->root = new BSTNode<Data>(item); 
  this->isize++;
  return true;        

}

BSTNode<Data>* currNode = this->root;

while(true){
  if(currNode->data < item){
        //right subtree
     if(currNode->right == NULL){
        currNode->right = new BSTNode<Data>(item); 
        currNode->right->parent = currNode;
        this->isize++;
        return checkPRotate(currNode->right);
     }
     else        
           currNode = (BSTNode<Data>*)currNode->right; 
      }
 else if(item < currNode->data){
        //left subtree
    if(currNode->left == NULL){
        currNode->left = new BSTNode<Data>(item); 
        currNode->left->parent = currNode;
        this->isize++;
        return checkPRotate(currNode->left); 
     }
     else {        
           currNode =(BSTNode<Data>*) currNode->left; 
     }
        

 }
        else return false;
 }
}

/////////////////////
private:

/*
 * This is the rotateLeft method
 * */

BSTNode<Data>* rotateLeft( BSTNode<Data>* node )
  {
    // create a pointer the actual node to rotate
    BSTNode<Data>* curr = node->right;
    
    // deal with the child pointers
    if(curr->left) curr->left->parent = node;
    node->right = curr->left;
    curr->left = node;
    
    // deal with the parent pointers
    curr->parent = node->parent;
    if(curr->parent)
    {
      if(node->parent->left == node) node->parent->left = curr;
      else if(node->parent->right == node) node->parent->right = curr;
    }
    node->parent = curr;
    
    // return a pointer to the node that was being rotated
    return curr;
  }


/*
 * This is the rotateRight method
 * */

 BSTNode<Data>* rotateRight( BSTNode<Data>* node )
  {
    // create a pointer the actual node to rotate
    BSTNode<Data>* curr = node->left;

    // deal with the child pointers
    if(curr->right) curr->right->parent = node;
    node->left = curr->right;
    curr->right = node;

    // deal with the parent pointers
    curr->parent = node->parent;
    if(curr->parent)
    {
      if(node->parent->left == node) node->parent->left = curr;
      else if(node->parent->right == node) node->parent->right = curr;
    }
    node->parent = curr;

    // return a pointer to the node that was being rotated
    return curr;
  }



//Priority checking and rotation:
//

/*
 * This checks the priority and calls
 * RotateLeft and Right based on conditions
 * */

bool checkPRotate(BSTNode<Data>* item) {
  while(item->parent && getPriority(item->parent) < getPriority(item)) {
    if(item->parent->left == item && item->parent->parent == 0) {
      this->root = rotateRight(item->parent); //Rotate Right
      return true;
    }
    else if(item->parent->right == item && item->parent->parent == 0) {
 
      this->root = rotateLeft(item->parent); //Rotate left
      return true;
    }
    else if(item->parent->left == item)
      item = rotateRight(item->parent); //Rotate right
    else if(item->parent->right == item)
      item = rotateLeft(item->parent);  //Rotate left
  }
  return true;
}

/*
 * This is the getPriority method
 * */
int getPriority(BSTNode<Data>* a) {
  return((BSTNode<Data>*)a)->priority;  
}


};

#endif
