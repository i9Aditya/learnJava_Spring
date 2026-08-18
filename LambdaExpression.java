interface MyNumber{
    double getVal();
}
interface NumericTest{
    boolean test(int n);
}
interface NumTest2{
    boolean test(int n,int d);
}
public class LambdaExpression{
    
    public static void main(String[] args){
      MyNumber myNum; 
      myNum = () -> 123.45; 
      System.out.println("A fixed value : " + myNum.getVal());
      myNum = () -> Math.random()*100;
    //   System.out.println("Value : " + myNum.getVal());

    NumericTest isEven = n -> (n%2) == 0;
    if(isEven.test(10)) System.out.println("10 is Even");
    if(!isEven.test(9)) System.out.println("9 is not Even");

    NumericTest isNonNeg = (m) -> m >=0;
    if(isNonNeg.test(8)) System.out.println("8 is non Negative");
    if(!isNonNeg.test(-1)) System.out.println("-1 is Negative");
        NumTest2 isFactor = (n,d) -> (n%d) == 0;
        if(isFactor.test(1393,7)) System.out.println("1393 is Divisible by 7");
    }
}
