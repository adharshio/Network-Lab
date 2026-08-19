package com.example;

public class nice{
	public static void main(String[] args){
		List<PcapNetworkInterface> devices = Pcaps.findAllDevs();
		if(devices == null){
			System.out.println("No Network interface found");
		}
		System.out.println("Available Network");
		for(
	}
}
