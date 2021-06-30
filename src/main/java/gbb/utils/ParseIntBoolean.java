package gbb.utils;

public class ParseIntBoolean {
    public static boolean parseIntBoolean(String st){
        try {
            Integer.parseInt(st);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
