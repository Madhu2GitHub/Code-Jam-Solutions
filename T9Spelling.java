package com.t9.spelling;

import java.io.*;

public class T9Spelling {

	public static void main(String[] args) throws IOException {
		FileReader fr=new FileReader("D://CodeChamp Workspace//C-small-practice.in");
		BufferedReader bufr=new BufferedReader(fr);
		FileWriter fw=new FileWriter("D://CodeChamp Workspace//C-small-practice.out");
		BufferedWriter bufw=new BufferedWriter(fw);
		int N=Integer.parseInt(bufr.readLine());
		String tel[]=new String[11];
		tel[2]="abc";
		tel[3]="def";
		tel[4]="ghi";
		tel[5]="jkl";
		tel[6]="mno";
		tel[7]="pqrs";
		tel[8]="tuv";
		tel[9]="wxyz";
		
		
		for(int i=1;i<=N;i++)
		{
			bufw.write("Case #"+i+": ");
			String line=bufr.readLine();
			int cur=1,prev=0,just=0;
			for(int c=0;c<line.length();c++)
			{				
				if(line.charAt(c) == ' ')
				{
					if(just>0)
						bufw.write(" ");
					just++;
					cur=1;prev=0;
					bufw.write("0");
				}
				else
				{
					just=0;
					for(int t=2;t<10;t++)				
					{
						if(tel[t].contains(""+line.charAt(c)+""))
						{
							cur=t;
							if(cur==prev)
								bufw.write(" ");
							pressBtn(tel[t],t,line.charAt(c),bufw);
							prev=t;
							break;
							
						}
					}
				}
			}
			bufw.write("\n");
		}
		
		bufr.close();
		bufw.close();

	}
	
	public static void pressBtn(String tel,int num,char c,BufferedWriter bw) throws IOException
	{
		int i=-1;
		do
		{
			i++;
			bw.write(Integer.toString(num));
		}while(tel.charAt(i)!=c);
	}

}
