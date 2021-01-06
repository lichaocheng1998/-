package Model;

public class Encrypt {
    public static String encrypt(String sourceString,String password){
        char [] p=password.toCharArray();
        int n=p.length;
        char [] c=sourceString.toCharArray();
        int m=c.length;
        for(int k=0;k<m;k++){
            int mima=c[k]+p[k%n];
            c[k]=(char)mima;
        }
        return new String(c);
    }

//    public static void main(String[] args) {
//
//        String mima = Encrypt.encrypt("12315", "mima");
//        System.out.println(mima);
//
//    }
}
