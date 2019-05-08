import java.util.ArrayList;

public abstract class wordFilter {

  protected String [] allowedWords = {"ass", "asswhole", "bitch", "crap", "fuck", "fucker", "motherfucker", "shit"};

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
    protected static final int q11 = 11;
    protected static final int q12 = 12;
    protected static final int q13 = 13;
    protected static final int q14 = 14;
    protected static final int q15 = 15;
    protected static final int q16 = 16;
    protected static final int q17 = 17;
    protected static final int q18 = 18;
    protected static final int q19 = 19;
    protected static final int q20 = 20;
    protected static final int q21 = 21;
    protected static final int q22 = 22;
    protected static final int q23 = 23;
    protected static final int q24 = 24;
    protected static final int q25 = 25;
    protected static final int q26 = 26;
    protected static final int q27 = 27;
    protected static final int q28 = 28;
    protected static final int q29 = 29;
    protected static final int q30 = 30;
    protected static final int q31 = 31;
    protected static final int q32 = 32;
    protected static final int q33 = 33;
    protected static final int q34 = 34;

    
    
    
  //  { a,  b,   c,   d,   e,   f,   g,   h,   i,   j,
  //    k,  l,   m,   n,   o,   p,   q,   r,   s,   t, 
  //    u,  v,   w,   x,   y,   z}
    
    protected int[][] delta = {
      {q1, q9, q14, q34, q34, q14, q34, q34, q34, q34,
       q34, q34, q22, q34, q34, q34, q34, q34, q30, q34,
       q34, q34, q34, q34, q34, q34},
      {q34, q34, q34, q34, q34, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34, q34, q34, q2, q34,
       q34, q34, q34, q34, q34, q34},
      {q34, q34, q34, q34, q34, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34, q34, q34, q3, q34,
       q34, q34, q34, q34, q34, q34},
      {q34, q34, q34, q34, q34, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34, q34, q34, q34, q34,
       q34, q34, q4, q34, q34, q34},
      {q34, q34, q34, q34, q34, q34, q34, q5, q34, q34,
       q34, q34, q34, q34, q34, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34},
      {q34, q34, q34, q34, q34, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q6, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34},
      {q34, q34, q34, q34, q34, q34, q34, q34, q34, q34,
       q34, q7, q34, q34, q34, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34},
      {q34, q34, q34, q34, q8, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34},
      {q34, q34, q34, q34, q34, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34},
      {q34, q34, q34, q34, q34, q34, q34, q34, q10, q34,
       q34, q34, q34, q34, q34, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34},
      {q34, q34, q34, q34, q34, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34, q34, q34, q34, q11,
       q34, q34, q34, q34, q34, q34},
      {q34, q34, q12, q34, q34, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34},
      {q34, q34, q34, q34, q34, q34, q34, q13, q34, q34,
       q34, q34, q34, q34, q34, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34},
      {q34, q34, q34, q34, q34, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34},
      {q34, q34, q34, q34, q34, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34, q34, q15, q34, q34,
       q34, q34, q34, q34, q34, q34},
      {q16, q34, q34, q34, q34, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34},
      {q34, q34, q34, q34, q34, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q17, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34},
      {q34, q34, q34, q34, q34, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34},
      {q34, q34, q34, q34, q34, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34, q34, q34, q34, q34,
       q19, q34, q34, q34, q34, q34},
      {q34, q34, q20, q34, q34, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34},
      {q34, q34, q34, q34, q34, q34, q34, q34, q34, q34,
       q21, q34, q34, q34, q34, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34},
      {q34, q34, q34, q34, q28, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34},
      {q34, q34, q34, q34, q23, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34},
      {q34, q34, q34, q34, q34, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34, q34, q34, q34, q24,
       q34, q34, q34, q34, q34, q34},
      {q34, q34, q34, q34, q34, q34, q34, q25, q34, q34,
       q34, q34, q34, q34, q34, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34},
      {q34, q34, q34, q34, q26, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34},
      {q34, q34, q34, q34, q34, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34, q34, q27, q34, q34,
       q34, q34, q34, q34, q34, q34},
      {q34, q34, q34, q34, q34, q18, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34},
      {q34, q34, q34, q34, q34, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34, q34, q29, q34, q34,
       q34, q34, q34, q34, q34, q34},
      {q34, q34, q34, q34, q34, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34},
      {q34, q34, q34, q34, q34, q34, q34, q31, q34, q34,
       q34, q34, q34, q34, q34, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34},
      {q34, q34, q34, q34, q34, q34, q34, q34, q32, q34,
       q34, q34, q34, q34, q34, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34},
      {q34, q34, q34, q34, q34, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34, q34, q34, q34, q33,
       q34, q34, q34, q34, q34, q34},
      {q34, q34, q34, q34, q34, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34},
      {q34, q34, q34, q34, q34, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34, q34, q34, q34, q34,
       q34, q34, q34, q34, q34, q34},
    };

    abstract void reset();


    abstract void process(String s);


    abstract boolean accepted();

  }