public class Timer {



  public static void timerMD1add() {
    MD_1<Integer> md1 = new MD_1<Integer>();
    for(int i = 2000; i< 51000; i+=1000) {
      double totalTime = 0;
      double totalsqtime = 0;
      double seconds = 0;
      int r = 100000/i;
      
      for(int j = 1; j<r; j++) {
        //Start timer
        System.gc();
        //md1 = new MD_1<Integer>();
        long start = System.nanoTime(); 
        // MD_1<Integer> md1 = new MD_1<Integer>();
        for(int k = 1; k<i; k++) 
          md1.add(k);
        long end = System.nanoTime();
        seconds = (end - start) / 1.0e9;
        totalTime += seconds;
        totalsqtime += seconds*seconds;
        //md1 = new MD_1<Integer>();
        //seconds = 0;
      }
      double average = totalTime/r; //Average for 1 run
      double stdDev= Math.sqrt(totalsqtime/r - average*average);
      System.out.println(i+ "  " + average + "  " + "  " + stdDev);
      totalTime = 0;
      totalsqtime = 0;
    }
  }
  
  public static void timerMD2add() {
    for(int i = 10000; i< 51000; i+=1000) {
      double totalTime = 0;
      double totalsqtime = 0;
      double seconds = 0;
      int r = 100000/i;
      for(int j = 1; j<r; j++) {
        //Start timer
        System.gc();
        MD_2<Integer> md2 = new MD_2<Integer>();
        long start = System.nanoTime(); 
        // MD_1<Integer> md1 = new MD_1<Integer>();
        for(int k = 1; k<i; k++) 
          md2.remove(k);
        long end = System.nanoTime();
        seconds = (end - start) / 1.0e9;
        totalTime += seconds;
        totalsqtime += seconds*seconds;
        md2 = new MD_2<Integer>();
        //seconds = 0;
      }
      double average = totalTime/r; //Average for 1 run
      double stdDev= Math.sqrt(totalsqtime/r - average*average);
      System.out.println(i+ "  " + average + "  " + "  " + stdDev);
      totalTime = 0;
      totalsqtime = 0;
    }
  }
  
  public static void main(String[] args) {
   timerMD1add(); 
   System.out.println("time");
   timerMD2add();
  }
  
    
    
 /* int[] N = new int[40];
  for(int i = 1; i<41; i++) {
  N[i] = (i)*100;
  MD_1<Integer> md1 = new MD_1<Integer>();
  //int totalTime = 0;
    for(int j=0; i<N[i]; j++) {
       md1.add(j);
    }
 }
    }*/
 

}
