// Perform some accuracy tests using StrMath class
// You may have to import the package if you went with that option, but I just put the code in the same directory
// Note that there is an extra check commented off the end of the test arrays to check for leading zeros.  Many programs might fail on that.
//

class TestStrMath{
    
    // Test cases A[i] + B[i] = Radd[i]
    // Test cases A[i] * B[i] = Rmult[i]
    // Test cases A[i]! = Rfact[i] 

    private static String[] A = {"0","1","10","11","23","54"}; // ,"0011"};
    private static String[] B = {"5","505","2","13","101","1146"}; //,"000002"};
    private static String[] Radd={"5","506","12","24","124","1200"}; //,"12"};
    private static String[] Rmult={"0","505","20","143","2323","61884"}; //,"20"};
    private static String[] Rfact={"1","1","3628800","39916800","25852016738884976640000","230843697339241380472092742683027581083278564571807941132288000000000000"}; //,"3628800"};
    
    public static void main(String [] args){
	StrMath stm = new StrMath(); // not important if your StrMath functions are all public static
	for(int i=0;i<A.length;i++){
	    myTest(stm,i,"+");
	    myTest(stm,i,"*");
	    myTest(stm,i,"!");
	}
    }
    
    private static void myTest(StrMath s, int i, String op){
	String r;
	if(op.equals("+")){
	    r = s.StrAdd(A[i],B[i]);
	    System.out.println(r + " = " + A[i] + op + B[i]);
	    if(r.equals(Radd[i]))
		System.out.println("Success!");
	    else System.out.println("Fail!");
	}

    	if(op.equals("*")){
	    r = s.StrMult(A[i],B[i]);
	    System.out.println(r + " = " + A[i] + op + B[i]);
	    if(r.equals(Rmult[i]))
		System.out.println("Success!");
	    else System.out.println("Fail!");
	}

    	if(op.equals("!")){
	    r = s.StrFact(A[i]);
	    System.out.println(r + " = " + A[i] + op);
	    if(r.equals(Rfact[i]))
		System.out.println("Success!");
	    else System.out.println("Fail!");
			       
	}
    }
}

/*  Output from my test run
5 = 0+5
Success!
0 = 0*5
Success!
1 = 0!
Success!
506 = 1+505
Success!
505 = 1*505
Success!
1 = 1!
Success!
12 = 10+2
Success!
20 = 10*2
Success!
3628800 = 10!
Success!
24 = 11+13
Success!
143 = 11*13
Success!
39916800 = 11!
Success!
124 = 23+101
Success!
2323 = 23*101
Success!
25852016738884976640000 = 23!
Success!
1200 = 54+1146
Success!
61884 = 54*1146
Success!
230843697339241380472092742683027581083278564571807941132288000000000000 = 54!
Success!

 */  //end output
