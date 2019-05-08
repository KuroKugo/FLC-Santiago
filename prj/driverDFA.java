import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class driverDFA extends wordFilter {
    private int errorState;
    private int state;
    private int transState;
    private ArrayList<String> alphabet = new ArrayList<>();
    private Pattern regex = Pattern.compile("[a-z]*");
    private int a = (int) 'a';
    int[][] deltaTrans;
    // private ArrayList<Integer> accept = new ArrayList<Integer>(Arrays.asList(q3, q8, q13, q17, q21, q29, q33));
    private ArrayList<Integer> acceptedStates = new ArrayList<>();
    private ArrayList<String> wordList = new ArrayList<>();

    public void reset() {
      // state = STARTSTATE;
      // state = q0;
      state = 0;
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
      // System.out.println(match);
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
            state = errorState;
            }
            
        }
      }
      else
      {
        state = errorState;
      }
    }

    public void createTransition() {
      int transitions = 0;
      String[] words;

      for (String word : wordList) {
        transitions += word.length();
      }
      
      deltaTrans = new int[transitions + 36][36];
      errorState = deltaTrans.length - 1;

      // System.out.println(" " + transitions);

      for (int i = 0; i < 26; i ++) {
        deltaTrans[0][i] = i + 1;
        // System.out.println(" Delta: [0][" + i + "] = " + (i + 1));
      }
      for (int i = 1; i < deltaTrans.length; i ++) {
        for (int j = 0; j < 26; j ++) {
          deltaTrans[i][j] =  errorState;
        }
        // System.out.println(" Transition at index: deltaTrans[" + i + "] has been filled with " + errorState);
      }

      transitions = 0;

      for (int d = 0; d < wordList.size(); d ++) {
        for (int i = 0; i < wordList.get(d).length(); i++) {
          char c = wordList.get(d).charAt(i);
          int letter = (int) c;
          int nextState = letter - a;
          try {
            // System.out.println(wordList.get(d) + " current Delta: [" + transState + "][" + nextState + "]");
            if (i == 0) {
              transState = deltaTrans[0][nextState];
            } else {
                if (deltaTrans[transState][nextState] == errorState) {
                  deltaTrans[transState][nextState] = 26 + transitions;
                  // System.out.println("Calc next State " + deltaTrans[transState][nextState]);
                  if (i + 1 == wordList.get(d).length()) {
                    acceptedStates.add(deltaTrans[transState][nextState]);
                  }
                }
                transState = deltaTrans[transState][nextState];
              }
            } catch (ArrayIndexOutOfBoundsException ex) {
            //  state = ERRORSTATE;
            transState = errorState;
          }
          // System.out.println(wordList.get(d) + " next state: " + transState);
          transitions++;
        }
      }
    }

    public void addWord(String word) {
		
      BufferedWriter writer;
      
      try {
        writer = new BufferedWriter(new FileWriter("./censor.txt", true));
        if (!wordList.contains(word)) {
          writer.write(word);
          writer.newLine();
          System.out.printf("The word " + word + " has been added to the filter.\n");
        }
        writer.flush();
        
        writer.close();
      }
      catch (IOException e) {
        e.printStackTrace();
      }	
    }

    public void loadWordList() {
      BufferedReader reader;
      try {
        reader = new BufferedReader(new FileReader("./censor.txt"));
        
        String line = reader.readLine();
        
        while(line != null) {
          System.out.println(line);
          wordList.add(line);
          line = reader.readLine();
        }
        
        reader.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    public void printWordList () {
      for (String word : wordList) {
        // System.out.println("  " + word + "  ");
      }
    }

    public static void main(String[] args) {
      boolean inputMode = true;
      boolean filterMode = false;
      String s = "";
      driverDFA d = new driverDFA();
      System.out.println("-----------------------------------------");

      System.out.println("Welcome to the Profanity Filter");
      System.out.println("Current words in the Profanity Filter");

      d.loadWordList();
      System.out.println("-----------------------------------------");
      d.printWordList();

      Scanner scanner = new Scanner(System.in);
      try {
          while (inputMode) {
              System.out.print("Add words by entering a word");
              System.out.println("or exit input mode by entering \"exit\"");
              String line = scanner.next();
              if (line.equals("exit")) {
                inputMode = false;
                filterMode = true;
              } else {
                d.addWord(line);
              }
          }
      } catch(IllegalStateException | NoSuchElementException e) {
          // System.in has been closed
          System.out.println("System.in was closed; exiting");
      }

      System.out.println("-----------------------------------------");
      System.out.println("Current words in the Profanity Filter");
      d.loadWordList();
      System.out.println("To test the filter enter a word");
      System.out.println("-----------------------------------------");
      d.createTransition();

      while (filterMode) {
        System.out.println("Enter a word and I will tell you if it is a bad word.");
        System.out.println("Or exit by entering \"exit\"");
        String line = scanner.next();
        s = line;

        d.reset();
        d.process(s);
        if (d.accepted()) {
        System.out.println("You said a bad word\n");
        }
        else {
          System.out.println("That is not a bad word.\n");
        }
        if (s.equals("exit")) {
          filterMode = false;
        }
      }

      System.out.println("-----------------------------------------");
    }
  }