package Chapter8;

public class rec {
    public static int mystery(int a, int b)
    {
        if (b == 0)        
            return 0;
        else if (b % 2 == 0)
            return mystery(a + a, b / 2);
        else                
            return mystery(a + a, b / 2) + a;
    }
    
    public static void main(String[] args) {
        System.out.println(mystery(3, 25));
    }
}