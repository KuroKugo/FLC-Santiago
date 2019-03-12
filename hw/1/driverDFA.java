  /**
  *  file: driverDFA.java
  *  author: Christian Santiago
  *  course: CMPT 440
  *  assignemnt: homework 1
  *  due date: March 12, 2019
  *  version 0.1
  *
  *  This file contains the implementation of the ManWolf
  *  class
  */

  public class driverDFA extends ManWolf {
    private int state;

    private static final int q0 = 0;
    private static final int q1 = 1;
    private static final int q2 = 2;
    private static final int q3 = 3;
    private static final int q4 = 4;
    private static final int q5 = 5;
    private static final int q6 = 6;
    private static final int q7 = 7;
    private static final int q8 = 8;
    private static final int q9 = 9;
    private static final int q10 = 10;

    static private int[][] delta = 
    { {q10, q1, q10, q10},
     {q10, q0, q10, q2}, 
     {q3, q10, q5, q1}, 
     {q2, q4, q10, q10},
     {q10, q3, q7, q10},
     {q10, q6, q2, q10},
     {q7, q5, q10, q10},
     {q6, q10, q4, q8},
     {q10, q9, q10, q7},
     {q10, q8, q10, q10},
     {q10, q10, q10, q10} };

    public void reset() {
      // state = STARTSTATE;
      state = q0;
    }

    public boolean accepted() {
      return state == q9;
    }


    public void process(String s) {
      for (int i = 0; i < s.length(); i++) {
         char c = s.charAt(i);
         try {
           if (c == 'w') {
            state = delta[state][0];
           }
           if (c == 'g') {
            state = delta[state][1];
           }
           if (c == 'c') {
            state = delta[state][2];
           }
           if (c == 'n') {
            state = delta[state][3];
           }
         }
         catch (ArrayIndexOutOfBoundsException ex) {
          //  state = ERRORSTATE;
          state = q10;
           } 
      }
    }

    public static void main(String[] args) {

      driverDFA d = new driverDFA();
       
       String s = args[0];
        d.reset();
        d.process(s);
        if (d.accepted()) {
        System.out.printf("That is a solution.\n");
        }
        else {
          System.out.printf("That is not a solution.\n");
        }

    }
  }