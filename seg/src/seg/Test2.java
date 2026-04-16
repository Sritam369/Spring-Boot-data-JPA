package seg;
public class Test2 {
public static void print(int a) { System.out.println("Primitive: " + a); }
public static void print(Integer a) { System.out.println("Wrapper: " + a); }
public static void main(String[] args) {
int s  = Integer.valueOf("1");
IO.println(s);
}
}


