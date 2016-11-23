package com.reverse.words;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReverseWords {

	public static void main(String[] args)  throws IOException{
		String fileName = "D://CodeChamp Workspace//B-small-practice.in";
		String fileName1 = "D://CodeChamp Workspace//B-small-practice.out";
		FileReader fr = new FileReader(fileName); 
		FileWriter fw = new FileWriter(fileName1);
		BufferedReader bufr = new BufferedReader(fr); 
		BufferedWriter bufw = new BufferedWriter(fw); 
		int N =Integer.parseInt(bufr.readLine()); 
		for(int i=1;i<=N;i++)
		{
			bufw.write("Case #"+i+": ");
			String words[]=bufr.readLine().split(" ");
			if(words.length==1)
			{
				bufw.write(words[0]);
			}
			else
			{				
				for(int j=words.length-1; j>=0;j--)
				{
					bufw.write(words[j]);
					if(j!=0)
						bufw.write(" ");
				}				
			}
			if(i!=N)
				bufw.write("\n");			
		}
		bufr.close();
		bufw.close();

	}

}
