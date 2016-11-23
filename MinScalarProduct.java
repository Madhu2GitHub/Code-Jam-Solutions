package com.min.scalar.product;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;


public class MinScalarProduct
{
	public static void main(String[] args) throws IOException 
	{
		String fileName = "D://CodeChamp Workspace//A-small-practice.in";
		String fileName1 = "D://CodeChamp Workspace//A-small-practice.out";
		FileReader fr = new FileReader(fileName); 
		FileWriter fw = new FileWriter(fileName1);
		BufferedReader bufr = new BufferedReader(fr); 
		BufferedWriter bufw = new BufferedWriter(fw);
		int T=Integer.parseInt(bufr.readLine());
		for(int t=1;t<=T;t++)
		{
			int N=Integer.parseInt(bufr.readLine());
			Long arr1[]=new Long[N];
			Long arr2[]=new Long[N];
			String ip1[]=bufr.readLine().split(" ");
			String ip2[]=bufr.readLine().split(" ");
			for(int i=0;i<N;i++)
			{
				arr1[i]=Long.parseLong(ip1[i]);
				arr2[i]=Long.parseLong(ip2[i]);
			}
			Arrays.sort(arr1);
			Arrays.sort(arr2,Collections.reverseOrder());
			long scalarProd=0;
			for(int i=0;i<N;i++)
			{
				System.out.println(arr1[i]+":"+arr2[i]);
				scalarProd+=(arr1[i]*arr2[i]);
			}
			System.out.println("---------------------");
			bufw.write("Case #"+t+": "+scalarProd+"\n");
		}
		bufr.close();
		bufw.close();
		System.out.println("Done");
	}
}

