package seg;

public class Test {
    public static void main(String[] args) {

        int n = 122334;

        for(int i = 0; i <= 9; i++) {
            int count = 0;
            int temp = n;

            while(temp != 0) {
                int digit = temp % 10;
                if(digit == i) {
                    count++;
                }
                temp /= 10;
            }

            if(count > 0) {
                System.out.println(i + " -> " + count);
            }
        }
    }
}

