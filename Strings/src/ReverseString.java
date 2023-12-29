public class ReverseString {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder("abcd");
        reverse(builder);
    }

    static void reverse(StringBuilder builder) {
        for (int i = 0; i < builder.length()/2; i++) {
            int start = i, end = builder.length() -i-1;
            char startChar = builder.charAt(start);
            char endChar = builder.charAt(end);
            builder.setCharAt(end, startChar);
            builder.setCharAt(start, endChar);
        }
        System.out.println(builder);
    }

}
