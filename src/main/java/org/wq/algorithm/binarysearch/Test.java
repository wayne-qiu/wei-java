package org.wq.algorithm.binarysearch;


public class Test {

    private Test(){}

    private Test(int a){}


    public static void main(String[] args) throws Exception {


//        System.out.println(-2 >>> 1);
//
//        new ArrayList<>(2);
//        int bitmask = 0x000F;
//        int val = 0x2222;
//        // prints "2"
//        System.out.println(val & bitmask);


//        String s = "123 45 67 890";
//
//        System.out.println(s.substring(s.length()-1, s.length()));
//
//        System.out.println(s.charAt(0));
//        System.out.println(s.charAt(s.length()-1));
//
//        StringBuffer sb = new StringBuffer();
//
//        s = s.replace(" ", "");
//
//        int i = 0, len = s.length();
//        while(i < len){
//            sb.append(s.substring(i,i+2>len?len:i+2)).append("\n");
//            i=i+2;
//        }
//
//        System.out.println(sb.toString());
//    }

        int sum = -1, sp1 = 1, sp2 = -2, n = 100000, temp = 0;

        if (n == 0 || n == 1) System.out.println(n);
        if (n == 2) System.out.println(sp1 + sp2);

        if (n >= 3) {
            for (int i = 0; i <= n - 3; i++) {
                sum += sp2 - sp1;
                temp = sp2 - sp1;
                sp1 = sp2;
                sp2 = temp;
            }
        }

        System.out.println(sum);
    }
}
