package com.atella.java.programma;

import java.io.FileNotFoundException;

public class TryCatchTest01 {

	@SuppressWarnings("finally")
	public static int test01(){
		int status = 0;
		try{
			System.out.println("A");
			status = 1;
			//throw new FileNotFoundException();
		}catch(Exception e){
			System.out.println("B");
			status = 2;
		}finally{
			System.out.println("C");
			return status;
		}
	}
	
	public static void main(String args[]){
		System.out.println(test01());
		Object obj = new Object();
		
	}
}
