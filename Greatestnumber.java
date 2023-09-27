/*******************************************
 *File       :Numberpositive
 *Description: Greatestnumber
 *author     :sarya sajeev
 *version    :1.0
 *Date       :27/09/2023
*******************************************/


import java.util.Scanner;
public class Greatestnumber {
	public static void main(String[]args) {
		int a,b,c;
		Scanner Sc=new Scanner(System.in);
		System.out.println("Input 3 numbers");
		a=Sc.nextInt();
		b=Sc.nextInt();
		c=Sc.nextInt();
		if(a>b&&a>c) {
			System.out.println("The Greatest number is"+a);
		}
			else if(b>a&&b>c) {
				System.out.println("The Greatest number is"+b);
			}
			else {
				System.out.println("The Greatest number is"+c);
			}
				
				}
			
		}
	


