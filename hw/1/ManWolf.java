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
   *  problem and sets up the declaration for the transition funtion
   */
  public abstract class ManWolf {
    protected final static enum State { Q0, Q1, Q2, Q3, Q4, Q5, Q6, Q7, 
                            Q8, Q9, Q10, Q11 }
    
    protected final static alphabet = ['n', 'w', 'g', 'c'];
    
    protected startState = State.Q0;
    protected finalState = State.Q10;

    abstract void reset();
    abstract void process();
    abstract boolean accepted();

  }