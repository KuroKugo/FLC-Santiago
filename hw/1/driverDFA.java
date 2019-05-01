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