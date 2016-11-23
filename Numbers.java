package com.numbers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public class Numbers 
{
	public static void main(String[] args) throws IOException
	{
		String fileName = "D://CodeChamp Workspace//C-large-practice.in";
		String fileName1 = "D://CodeChamp Workspace//C-large-practice.out";
		FileReader fr = new FileReader(fileName); 
		FileWriter fw = new FileWriter(fileName1);
		BufferedReader bufr = new BufferedReader(fr); 
		BufferedWriter bufw = new BufferedWriter(fw); 
		int T=Integer.parseInt(bufr.readLine());
		int[][] res=new int[2][2];
		res[0][0]=3;
		res[0][1]=5;
		res[1][0]=1;
		res[1][1]=3;
		for(int t=1;t<=T;t++)
		{
			int n=Integer.parseInt(bufr.readLine());
			bufw.write("Case #"+t+": ");
			int val[][]=calExp(res,n);
			String result=Integer.toString((2 * val[0][0] + 999) % 1000);
			if(result.length()==1)
				bufw.write("00"+result);
			else if(result.length()==2)
				bufw.write("0"+result);
			else bufw.write(result);
			bufw.write("\n");
		}
		bufr.close();
		bufw.close();
	}

	public static int[][] calExp(int[][] A,int n)
	{
		if(n == 1)
		    return A;
		else
		{
		    if(n%2==0)
			{
				int[][] A1 = calExp(A, n/2);
				return multiply(A1,A1);
			}
			else
			{
				return multiply(A,calExp(A, (n - 1)));
			}	
		}
	}
	
	public static int[][] multiply(int[][] A,int[][] B)
	{
		int C[][]={{0,0},{0,0}};
		for(int i=0;i<2;i++)
			for(int j=0;j<2;j++)
				for(int k=0;k<2;k++)
					C[i][k]=(C[i][k] + A[i][j] * B[j][k]) % 1000;
		return C;		
	}
}
