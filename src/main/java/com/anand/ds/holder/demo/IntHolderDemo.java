/**
 * 
 */
package com.anand.ds.holder.demo;

//import org.omg.CORBA.IntHolder;

/**
 * @author pursuitanand
 *
 */
public class IntHolderDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int x = 3;
		System.out.println(x);
		callByValueChangeX(x);
		System.out.println(x);
		callByValueChangeX1(x);
		System.out.println(x);
		IntHolder y = new IntHolder(x);
		callByValueChangeX2(y);
		System.out.println(y.value);

	}
	
	private static int callByValueChangeX(int x){
		
		x=x*3;
		System.out.println("inside"+x);
		return (x*3);
	}
	
	private static int callByValueChangeX1(Integer x){
		x=x*3;
		System.out.println("inside"+x);
		return (x*3);
	}
	private static int callByValueChangeX2(IntHolder x){
		x.value=(x.value*3);
		System.out.println("inside"+x.value);
		return (x.value*3);
	}

}

class IntHolder {
    public int value;

    public IntHolder(int value) {
        this.value = value;
    }
}
