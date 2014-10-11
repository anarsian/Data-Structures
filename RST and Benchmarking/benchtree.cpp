/*
 * @authors: Anish Narsian, Dhanuk Withana
 * Description: This file 
 * */


#include <stdio.h>
#include <iostream>
#include <string>
#include <set>
#include <vector>
#include <cmath>
#include <algorithm>
#include "RST.hpp"
#include "countint.hpp"
 
using namespace std;
 
/*
 * This is the calc helper method, it does all the mean, std dev
 * calculations
 * */
void calc(double comp[], char** argv, int item){

  double sum , times, avg , sumSquared, var, stdDev;
  sum = times = avg = sumSquared = var = stdDev= 0.0;
  times = (double)atoi(argv[4]);

 
  //sum of the comparisons done in this run
  for(int i = 0; i < times; ++i){
	sum += comp[i];
  }
  avg = sum / times;
 
//sum squared calculation
  for(int i = 0; i < times; ++i){
	sumSquared += (comp[i] * comp[i]);
  }
  var= ((sumSquared / times) - (avg * avg));
 
  // case for nan or negative 
  if(var < 0){
    stdDev = 0;
  }
  else stdDev = sqrt((abs(var)));
 
  // display the results
  printf("%7d  %12.4f  %10.5f \n", item, avg, stdDev);
}
 /*
 * This prints the header as in the readme
 * */
  void printHeader(char** argv)
  {
    cout << "# Benchmarking average number of comparisons for successful find" << endl;
    cout << "# Data structure: " << argv[1] <<endl;
    cout << "# Data: " << argv[2] <<endl;
    cout << "# N is power of 2, minus 1, from 1 to " << argv[3] <<endl;
    cout << "# # Averaging over "<< argv[3]<< " runs for each N" <<endl;
    cout << "#" << endl;
    cout << "# N \t avgcomps \t stdev" << endl;

  }
 


/*
 * This is the main method
 * It takes 5 command line arguments
 * the executable, data STructure, type of data entred
 * the values to enter and no. of average runs
 * */
int main(int argc, char** argv)
{
  // correct command line args
  if(argc != 5) 
  { 
    cout << "Incorrect use" << endl;
    cout << "Use: bst/rst/set sorted/shuffled maxsize runs" << endl;
    cout << "eg:  ./benchtree rst sorted 32768 5 " << endl;
    return -1; 
  }
 
  vector<countint> v;
  const string bst = "bst";
  const string rst = "rst";
  const string sets = "set";
  const string sort = "sorted";
  const string shuffled = "shuffled";
  const int max = atoi(argv[3]);
  const int run = atoi(argv[4]);
   
  // check to make sure arguments are valid
  if(argv[1] != rst && argv[1] != bst && argv[1] != sets)
  { 
    cout << "First argument invalid\n";
    cout << "first argument has to be bst / rst or set\n";
    return -1;
  }
  if(argv[2] != shuffled && argv[2] != sort)
  { 
    cout << "Second argument invalid\n";
    cout << "Second argument has shuffled or sorted\n";
    return -1;
  }
  if(max == 0)
  { 
   cout << "Third argument invalid\n";
   cout << "Third argument has to be greater than zero\n";
   return -1;
  }
  if(run == 0)
  { 
    cout << "Forth argument invalid\n";
    cout << "Forth argument has to be greater than zero\n";
    return -1;
  }
   printHeader(argv); //print header at start
 
  for(int n = 1; n < max; n = n*2 + 1){
    // keep track of the number of comparisons between countints
    double comp[run];
 
    // clear out the vector and insert n number of elements
    v.clear();
    for(int i=0; i<n; ++i){
	 v.push_back(i);
	}
 
    for(int j = 0; j < run; ++j) {
      // create iterators over the vector for inserting purposes
      vector<countint>::iterator vit = v.begin();
      vector<countint>::iterator ven = v.end();
 
      // if the user wants to run diagnostics on a BST
      if(argv[1] == bst)
      { 
        // if the user enterd that the structer have shuffled input
        if(argv[2] == shuffled) random_shuffle(v.begin(),v.end());
         
        BST<countint> b;
        for(vit = v.begin(); vit != ven; ++vit) b.insert(*vit);
 
        countint::clearcount();
        for(vit = v.begin(); vit != ven; ++vit) b.find(*vit);
      }
      // if the user wants to run diagnostics on a RST
      else if(argv[1] == rst)
      { 
        // if the user enterd that the structer have shuffled input
        if(argv[2] == shuffled) random_shuffle(v.begin(),v.end());
         
        RST<countint> r;
        for(vit = v.begin(); vit != ven; ++vit) r.insert(*vit);
 
        countint::clearcount();
        for(vit = v.begin(); vit != ven; ++vit) r.find(*vit);
      }
      // if the user wants to run diagnostics on a SET
      else if(argv[1] == sets)
      { 
        // if the user enterd that the structer have shuffled input
        if(argv[2] == shuffled) random_shuffle(v.begin(),v.end());
         
        set<countint> s;
        for(vit = v.begin(); vit != ven; ++vit) s.insert(*vit);
 
        countint::clearcount();
        for(vit = v.begin(); vit != ven; ++vit) s.find(*vit);
      } 
      comp[j] = (countint::getcount()) / ((double)n);
    }
    calc(comp, argv, n);
  }
 
  // successful return
  return 0;
}







