import java.util.*;

interface MyInterface {
    abstract int add(int a, int b);
  }
  
public class Test {
    public static void main(String[] args) {
      MyInterface addFunction = (a, b) -> a + b; 
      int result = addFunction.add(2, 3); // 直接调用 addFunction(2, 3) 
      System.out.println(result); // 输出 
    }
  }