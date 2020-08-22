package others;

public class Clinit {
    public static int cout = 0;
    static
    {
        for (int i=0; i<100; i++)
        {
            cout += i;
        }
    }
}
