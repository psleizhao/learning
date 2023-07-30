public class Conversion {
	private double number;
	private int signBit;
	private int exponent;
	private int significand;
	private String a;
	public Conversion() {
		number=0;
		signBit=0;
		exponent=127;
		significand=0;
	}
	public Conversion(double number) {
		this.number=number;
		signBit=0;
		exponent=127;
		significand=0;
	}
	
	public void inputNumber() {
		double input;
		input=User.inputDouble("Enter a decimal number: ");
		number=input;
	}
	public void convert() {
		System.out.print("Convert the decimal "+number+" to binary conversion ");
		String binary ="";
		int front=(int)number;
		double temp=number-front;
		for(int i=0;i<24;i++) {
			binary=(front%2)+binary;
			front=front/2;
			if(front==0) {
				break;
			}
		}
		String backbinary="";
		for(int i=0;i<23;i++) {
			temp=temp*2;
			int a=(int)temp;
			backbinary=backbinary+a;
			if(temp>=1) {
				temp--;
			}
		}
		binary=binary+"."+backbinary;
		String finalans=binary.substring(0,25);
		a=finalans;
		System.out.println(a);
	}
	public void ex() {
		String b="";
		System.out.print("Normalized the number "+a);
		
		if(a.charAt(0)=='0') {
		while(a.charAt(0)=='0'||a.charAt(0)=='.') {
			if(a.charAt(0)=='0'){
				a =a.substring(1);
				
			}else if(a.charAt(0)=='.') {
				a=a.substring(1,2)+"."+a.substring(2);
				exponent--;
			}
		}
		System.out.println(a);
		b=a.substring(2)+"00000000000000000000000";
		b=b.substring(0,23);
		System.out.println(" to 1."+b+" with exponent "+exponent);
		}else {
			for(int i=0;i<25;i++) {
				if(a.charAt(i)=='.'){
					exponent=127+i-1;
					b=a.substring(1,i)+a.substring(i+1);
					b=b.substring(0,23);
					break;
				}
			}
			System.out.println(" to 1."+b+" with exponent "+exponent);
		}
		String temp="";
		for(int i=0;i<8;i++) {
			temp=(exponent%2)+temp;
			exponent=exponent/2;
		}
		System.out.println("Covert exponent to binary : "+temp);
		System.out.println("Converted the mantissa/significand to \"hidden bit\" format : "+b);
		
		String tt=signBit+temp.substring(0,3)+temp.substring(3,7)+temp.substring(7,8)+b.substring(0,3)+b.substring(3,7)+b.substring(7,11)+b.substring(11,15)+b.substring(15,19)+b.substring(19,23);
		System.out.print("Result in binary (32-bits) : ");
		System.out.println(signBit+temp.substring(0,3)+" "+temp.substring(3,7)+" "+temp.substring(7,8)+b.substring(0,3)+" "+b.substring(3,7)+" "+b.substring(7,11)+" "+b.substring(11,15)+" "+b.substring(15,19)+" "+b.substring(19,23));
		System.out.print("Result in Hexadecimal : ");
		for(int i=0;i<=7;i++) {
			System.out.print(hex(tt.substring(4*i,4*i+4))+" ");
		}
	}
	public void checkSignBit() {
		if(number<0) {
			signBit=1;
			System.out.printf("Since %f is negative so the sign bit is 1",number);
			System.out.println();
			number=0-number;
		}else {
			System.out.printf("Since %f is positive so the sign bit is 0",number);
			System.out.println();
			signBit=0;
		}
	}
	public String hex(String input) {
		switch(input) {
		  case "0001":
		    return "1";
		  case "0010":
			return "2";
		  case "0011":
			return "3";
		  case "0100":
			return "4";
		  case "0101":
		    return "5";
		  case "0110":
			return "6";
		  case "0111":
		    return "7";
		  case "1000":
			return "8";
		  case "1001":
		    return "9";
		  case "1010":
			return "A";
		  case "1011":
		    return "B";
		  case "1100":
			return "C";
		  case "1101":
			return "D";
		  case "1110":
			return "E";
		  case "1111":
		    return "F";
		  default:
			  return "0";
		}
	}
}
