package StringBuilder;

public class StringPerformance {
    public static void main(String[] args) {
        String series = "";
        for (int i = 0; i < 26; i++) {
            char ch = (char)('a' + i);
            series = series + ch;
        }
        System.out.println(series);
    }
}
//This becomes very inefficient to perform like this b/z series var. will keep pointing to different
//objects at every iteration first a thn ab thn abc thn abcd till abcde...wxy and lastly will give the
//desired result, and also leaving so many garbage values behind and have O(N^2) time complexity.
//So to perform it in efficient way there comes 'StringBuilder' class. Go to that file now.
