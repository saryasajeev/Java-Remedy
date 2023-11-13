import java.util.Scanner;
class InvalidAmountException extends Exception{
	InvalidAmountException (String str){
		super(str);
	}
}
class InsufficientFundsException extends Exception{
	InsufficientFundsException (String str){
		super(str);
	}
}
	
class Customer{
	long accountnumber;
	String accounttype;
	String customerName;
	long accountBalance;
	Scanner sc=new Scanner(System.in);
	public void setCustomerDetails() {
		System.out.println("Enter the account number");
		accountnumber=sc.nextLong();
		System.out.println("Enter the account type");
	    accounttype=sc.next();	
		System.out.println("Enter the customer Name");
		customerName=sc.next();
		System.out.println("Enter the account opening balance");
		accountBalance=sc.nextLong();
	}
	public void GetCustomerDetails() {
		System.out.println("_______________________________");
		System.out.println("The customer details are");
		System.out.println("Account Number: "+ accountnumber);
		System.out.println("Account Type: "+ accounttype);
		System.out.println("Customer Name: "+ customerName);
		System.out.println("Account Balance: "+ accountBalance);
		System.out.println("_______________________________");
	}
	public void searchAccount(){
	}
}
public class CustomException {
	public static void main(String[]args) {
	Scanner sc=new Scanner (System.in);
	InvalidAmountException AmountException= new InvalidAmountException("Invalid Amount Exception");
	InsufficientFundsException FundsException=new InsufficientFundsException("Insufficient Funds Exception");
	int choice;
	System.out.println("Enter the no of customers");
	int noOfCustomers=sc.nextInt();
	Customer [] customer=new Customer[noOfCustomers];
	for(int i=0;i<noOfCustomers;i++) {
		customer[i]=new Customer();
	    customer[i].setCustomerDetails();
	}
	for(int i=0;i<noOfCustomers;i++) {
	    customer[i].GetCustomerDetails();
	}
	do {
		System.out.println("1.Display account details");
		System.out.println("2..Search by account number");
		System.out.println("3.Deposit the amount\n"
				+ "4.Withdraw the amount\n"
				+ "5.Exit\n"
				+ "Enter your choice ");
		choice=sc.nextInt();
		switch (choice) {
		case 1:{
			for(int i=0;i<noOfCustomers;i++) {
				customer[i].GetCustomerDetails();
			}
			break;}
		case 2:{
         System.out.println("Enter the account number");
         int searchAccount=sc.nextInt();
         for(int i=0;i<noOfCustomers;i++) {
        	 if(customer[i].accountnumber==searchAccount) {
        		 customer[i].GetCustomerDetails();
        		 }
		}
		}
         case 3:{
        	System.out.println("Enter the account number"); 
        	 int searchAccount=sc.nextInt();
        	 try {
        	System.out.println("Enter the amount to deposit");
        	int depositAmount=sc.nextInt();
        	if(depositAmount<0) {
        		throw AmountException;}
        		else {
        	 for(int i=0;i<noOfCustomers;i++) {
            	 if(customer[i].accountnumber==searchAccount) {
            		 customer[i].accountBalance=customer[i].accountBalance+depositAmount;
            				 customer[i].GetCustomerDetails();
            	 }
    
        	 }
        	 
        	 }
        	 }
        	 catch(InvalidAmountException e) {
        		 System.out.println(e.getMessage());
        	 }
        	 break;
        	 }
         case4:{
        	 System.out.println("Enter the account number");
        	 int searchAccount=sc.nextInt();
        	 try {
        		 System.out.println("Enter the amount to withdraw");
        		 int withdrawAmount=sc.nextInt();
        		 if(withdrawAmount<0) {
        			 throw AmountException;
        			 }
        		 else{
        			 for(int i=0;i<noOfCustomers;i++) {
        	        	 if(customer[i].accountnumber==searchAccount) {
        	        		 if(withdrawAmount>customer[i].accountBalance) {
        	        	  throw fundsException;
        	        	 }
        	        		 else {
        	        			 customer[i].accountBalance=customer[i].accountBalance;
        	        		     customer[i].GetCustomerDetails();
        	        		 }
        		 }
        	 }
         
         
	while(choice<4);
	
	

