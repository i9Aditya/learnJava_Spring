@FunctionalInterface
interface StringFunc{
    String func(String s);
}

@FunctionalInterface
interface MathFunc{
    int fun(int a);
}


class MyStringOps{
    static String strReverse(String str){
        String result = "";
        for(int i = str.length() - 1;i>=0;i--){
            result += str.charAt(i);
        }
        return result;
    }

    static int strLength(String str){
        return str.length();
    }
}

class MathOps{
    static int reverseNum(int n){
        int ans = 0;

        return ans;
    }
}

public class MethodReferencing {

    static String stringop(StringFunc sf,String s){
        return sf.func(s);
    }
    static int mathF(MathFunc mf,int n){
        return mf.fun(n); 
    }

    public static void main(String[] args){
        String inStr = "Lambda Add Power to JAVA";
        String outStr;

        outStr = stringop(MyStringOps :: strReverse,inStr); //className :: methodName

        System.out.println("Original string: " + inStr);
        System.out.println("String reversed: " + outStr);

        MathFunc fun = n -> {
            int ans = 1;
            for(int i = n;i>0;i--){
                ans *= i;
            }
            return ans;
        };


        int a = mathF(fun, 5);
        System.out.println(a + " = factorial of 5");

        
    }
}
