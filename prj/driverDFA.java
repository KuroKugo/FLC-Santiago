import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class driverDFA extends wordFilter {
    private int state;
    private Pattern regex = Pattern.compile("[a-z]*");
    private int a = (int) 'a';
    private ArrayList<Integer> accept = new ArrayList<Integer>(Arrays.asList(q3, q8, q13, q17, q21, q29, q33));

    public void reset() {
      // state = STARTSTATE;
      state = q0;

    }

    public boolean accepted() {
      // return state == q9;
      return accept.contains(state);
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
              state = delta[state][nextState];
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

    public static void main(String[] args) {
      String s = args[0];
      driverDFA d = new driverDFA();

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