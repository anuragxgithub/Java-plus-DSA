// Note: This is an alternative way using less for loop you can do it by printing separate col and spaces of each triangle as your wish
public class P19_GG {
    public static void main(String[] args) {
        printPattern(5);
    }
    static void printPattern(int n) {
        for (int row = 1; row <= n; row++) {
            for (int col = 1; col <= row*2; col++) {
                System.out.print("*");
                if(col==(row*2)/2 && row<n) {
                    for (int spaces = 1; spaces <= (n-row)*2; spaces++) {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
        for (int row = (n-1); row >= 1; row--) {
            for (int col = 1; col <= (row*2); col++) {
                System.out.print("*");
                 if(col == (row*2)/2) {
                     for (int spaces = 1; spaces <= (n-row)*2; spaces++) {
                         System.out.print(" ");
                     }
                }
            }
            System.out.println();
        }
        /* THIS ONE IS NOT SOLVED BY ME

        for(int i=1;i<=2*n-1;i++){
            int stars=i;
            int spaces=2*n-i*2;
            if(i>n){
                stars=2*n-i;
                spaces=i*2-n*2;
            }
            for(int j=1;j<=stars;j++){
                System.out.print("*");
            }
            for(int j=1;j<=spaces;j++){
                System.out.print(" ");

            }
            for(int j=1;j<=stars;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        */
    }
}
