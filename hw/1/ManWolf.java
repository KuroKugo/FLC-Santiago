  /**
  *  file: ManWolf.java
  *  author: Christian Santiago
  *  course: CMPT 440
  *  assignemnt: homework 1
  *  due date: March 12, 2019
  *  version 0.1
  *
  *  This file contains the declaration of the abstract
  *  class for the ManWolf problem
  */

  /**
   *  ManWolf
   *  
   *  This class implements the all the states in the ManWolf
   *  problem and sets up the declaration for the required funtions
   */
  public abstract class ManWolf {
    // protected final static enum State { Q0, Q1, Q2, Q3, Q4, Q5, Q6, Q7, 
    //                         Q8, Q9, Q10 }
    
    //protected final static alphabet = ['n', 'w', 'g', 'c'];
    
    // protected final static State STARTSTATE = State.Q0;
    // protected final static State ACCEPTSTATE = State.Q9;
    // protected final static State ERRORSTATE = State.Q10;

    protected static final int q0 = 0;
    protected static final int q1 = 1;
    protected static final int q2 = 2;
    protected static final int q3 = 3;
    protected static final int q4 = 4;
    protected static final int q5 = 5;
    protected static final int q6 = 6;
    protected static final int q7 = 7;
    protected static final int q8 = 8;
    protected static final int q9 = 9;
    protected static final int q10 = 10;

    static protected int[][] delta = 
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
    

    abstract void reset();


    abstract void process(String s);


    abstract boolean accepted();

  }