package countries;

public class MyMethods {

    public static int charCount(String s, char c) {
        int count = 0;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == c)
                count++;

        return count;
    }

    public static int vowelCount(String s) {
        return charCount(s,'a') +
               charCount(s,'e') +
               charCount(s,'i') +
               charCount(s,'o') +
               charCount(s,'u');
    }
}
