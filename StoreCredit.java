package com.store.credit;
import java.io.*;
public class StoreCredit {

	public static void main(String[] args) throws IOException{
		String fileName = "D://CodeChamp Workspace//A-large-practice.in";
		String fileName1 = "D://CodeChamp Workspace//A-large-practice.out";
		FileReader fr = new FileReader(fileName); 
		FileWriter fw = new FileWriter(fileName1);
		BufferedReader bufr = new BufferedReader(fr); 
		BufferedWriter bufw = new BufferedWriter(fw); 
		int N =Integer.parseInt(bufr.readLine()); 
		for(int i=1;i<=N;i++)
		{
			int C=Integer.parseInt(bufr.readLine());
			int I=Integer.parseInt(bufr.readLine());
			String L[]=bufr.readLine().split(" ");
			int pos1=0,pos2=0;
			boolean done;
			for(int j=0;j<I-1;j++)
			{
				int item1=Integer.parseInt(L[j]);
				done=false;
				for(int k=j+1;k<I;k++)
				{
					int item2=Integer.parseInt(L[k]);
					if(item1+item2 == C)
					{
						if(k<j)
						{	pos1=k+1;
							pos2=j+1;
						}
						else
						{
							pos1=j+1;
							pos2=k+1;
						}
						done=true;
						break;
					}
				}
				if(done)
					break;
			}
			bufw.write("Case #"+i+": "+pos1+" "+pos2+"\n");
		}
		bufr.close();
		bufw.close();

	}

}
