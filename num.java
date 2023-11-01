import java.util.Scanner;
public class Main {
  public static void main(String[] args){
   int i,num,sum=0;
   {
   Scanner sc= new Scanner(System.in);  
        System.out.print("Input a number");  
         num=sc.nextInt();
}
  System.out.println("The first n natural numbers are:"+num);
  
 for(i=1;i<=num;i++)
   {
     System.out.println(i);
     sum+=i;
   }
   System.out.println("The Sum of Natural Number upto "+num+" terms: "+sum);

}
}
