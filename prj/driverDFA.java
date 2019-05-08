import java.util.ArrayList;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class driverDFA extends wordFilter {
    private int state;
    private int transState;
    private Pattern regex = Pattern.compile("[a-z]*");
    private int a = (int) 'a';
    int[][] deltaTrans;
    private ArrayList<Integer> accept = new ArrayList<Integer>(Arrays.asList(q3, q8, q13, q17, q21, q29, q33));
    private ArrayList<Integer> acceptedStates = new ArrayList<>();

    public void reset() {
      // state = STARTSTATE;
      state = q0;

    }

    public boolean accepted() {
      // return state == q9;
      // return accept.contains(state);
      return acceptedStates.contains(state);
    }


    public void process(String s) {
      String str = s.toLowerCase();
      Matcher m = regex.matcher(str);
      boolean match = m.matches();
      System.out.println(match);
      if (match)
      {
        for (int i = 0; i < str.length(); i++) {
          char c = s.charAt(i);
          int letter = (int) c;
          try {
              int nextState = letter - a;
              state = deltaTrans[state][nextState];
          }
          catch (ArrayIndexOutOfBoundsException ex) {
            //  state = ERRORSTATE;
            state = q34;
            }
            
        }
      }
      else
      {
        state = q34;
      }
    }

    public void createTransition() {
      int transitions = 0;
      String[] words;

      words = allowedWords;
      for (String word : words) {
        transitions += word.length();
      }
      
      deltaTrans = new int[transitions + 26][26];
      int errorState = deltaTrans.length - 1;
      String testWord = words[0];

      System.out.println(" " + transitions);

      for (int i = 0; i < 26; i ++) {
        deltaTrans[0][i] = i + 1;
        System.out.println(" Delta: [0][" + i + "] = " + (i + 1));
      }
      for (int i = 1; i < deltaTrans.length; i ++) {
        for (int j = 0; j < 26; j ++) {
          deltaTrans[i][j] =  errorState;
        }
        System.out.println(" Transition at index: deltaTrans[" + i + "] has been filled with " + errorState);
      }

      for (int d = 0; d < allowedWords.length; d ++) {
        for (int i = 0; i < allowedWords[d].length(); i++) {
          char c = allowedWords[d].charAt(i);
          int letter = (int) c;
          int nextState = letter - a;
          try {
            System.out.println(allowedWords[d] + " current Delta: [" + transState + "][" + nextState + "]");
            if (i == 0) {
              transState = deltaTrans[0][nextState];
            } else {
                if (deltaTrans[transState][nextState] == errorState) {
                  deltaTrans[transState][nextState] = 26 + i + d;
                  System.out.println("Calc next State " + deltaTrans[transState][nextState]);
                  if (i + 1 == allowedWords[d].length()) {
                    acceptedStates.add(deltaTrans[transState][nextState]);
                  }
                }
                transState = deltaTrans[transState][nextState];
              }
            } catch (ArrayIndexOutOfBoundsException ex) {
            //  state = ERRORSTATE;
            transState = errorState;
          }
          System.out.println(allowedWords[d] + " next state: " + transState);
        }
      }
    }

    public static void main(String[] args) {
        String s = args[0];
      driverDFA d = new driverDFA();
      d.createTransition();

      d.reset();
      d.process(s);
      if (d.accepted()) {
      System.out.printf("You said a bad word\n");
      }
      else {
        System.out.printf("That is not a bad word.\n");
      }

    }
  }