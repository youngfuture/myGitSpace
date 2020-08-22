package ex6;
/**
 * @author King老师
 * 加了finally为啥不会异常
 */
public class NoError {
    public static void main(String[] args) {
        NoError noError =new NoError();
        noError.read();
    }
    volatile int kk =0;
    public int read(){
        try {
              int a = 13/0;
            return a;
        }finally {
            return 1;
        }
    }

}
