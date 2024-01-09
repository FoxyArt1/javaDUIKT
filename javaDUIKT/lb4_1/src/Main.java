
public class Main {
    public static boolean Palindrome(String str) {
        str = str.replaceAll("\\s", "").toLowerCase();

        String str2 = "";
        for (int i = str.length()-1; i >=0 ; i--) {
            str2 += str.toCharArray()[i];
        }
        if(str.equals(str2)){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        String str = "karate";
        if (Palindrome(str)) {
            System.out.println("It`s a palindrome");
        } else {
            System.out.println("Not a palindrome");
        }
    }
}