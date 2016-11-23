package com.milkshake;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestCode {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("D://CodeChamp Workspace//B-small-practice.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("D://CodeChamp Workspace//B-small-practice.out"));
		String str=br.readLine();
		int noOfCases = Integer.parseInt(str);
		for(int cases=1;cases<=noOfCases;cases++){
			int noOfFlavors = Integer.parseInt(br.readLine());
			int flavorBatch[] = new int[noOfFlavors];
			int noOfCustomers = Integer.parseInt(br.readLine());
			List<Customer> customers = new ArrayList<Customer>();
			for(int req=1;req<=noOfCustomers;req++){
				String s = br.readLine();
				String[] custReq = s.split(" ");
				Customer c = new Customer();
				Request[] list = new Request[Integer.parseInt(custReq[0])];
				int i=1;
				for(int re=0;re<Integer.parseInt(custReq[0]);re++){
					Request r = new Request();
					r.setFlavor(Integer.parseInt(custReq[i]));
					r.setIsMalted(Integer.parseInt(custReq[i+1]));
					i+=2;
					list[re] = r;
				}
				c.setRequests(list);
				customers.add(c);
			}
			/*for(Customer c : customers){
				System.out.println(c.getNoOfRequests());
				for(Request r : c.getRequests()){
					System.out.println(r.getFlavor() + " " + r.getIsMalted());
				}
				System.out.println();
			}*/
			String result = satisfyCustomers(cases, flavorBatch, customers);
			bw.append(result);
		}
		bw.close();
		
	}

	private static String satisfyCustomers(int cases, int[] flavorBatch, List<Customer> customers) throws IOException {
		
		int satisfied = 0;
		boolean impossible = false;
		boolean possible = false;
		while (!impossible && !possible) {
			satisfied = 0;
			for (int j=0; j<customers.size(); ++j) {
				if (customers.get(j).satisfied(flavorBatch)) {
					satisfied++;
				} else {
					for (int k=0; k<customers.get(j).getRequests().length; ++k) {
						if (customers.get(j).getRequests()[k].getIsMalted() == 1) {
							flavorBatch[customers.get(j).getRequests()[k].getFlavor()-1] = 1;
						}
					}
					if (!customers.get(j).satisfied(flavorBatch)) {
						impossible = true;
					}
					break;
				}
			}
			if (satisfied == customers.size()) {
				possible = true;
			}
		}
		if (impossible) {
			return "Case #" + (cases) + ": IMPOSSIBLE\n";
		} else {
			String str = "Case #" + (cases) + ":" ;
			for (int j=0; j<flavorBatch.length; ++j) {
				str+= " " + flavorBatch[j];
			}
			str+="\n";
			return str;
		}
		
	}
}
class Request {
	private int flavor;
	private int isMalted;
	public int getFlavor() {
		return flavor;
	}
	public void setFlavor(int flavor) {
		this.flavor = flavor;
	}
	public int getIsMalted() {
		return isMalted;
	}
	public void setIsMalted(int isMalted) {
		this.isMalted = isMalted;
	}
}
class Customer {
	private Request[] requests;
	public Request[] getRequests() {
		return requests;
	}
	public void setRequests(Request[] requests) {
		this.requests = requests;
	}
	public boolean satisfied(int[] batch) {
		for (int i=0; i<requests.length; ++i) {
			if (requests[i].getIsMalted() == batch[requests[i].getFlavor()-1]) {
				return true;
			}
		}
		return false;
	}
}