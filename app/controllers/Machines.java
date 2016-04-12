package controllers;

import java.net.InetAddress;
import java.net.UnknownHostException;

public enum Machines implements MachineName {
	
	LocalComputer(){

		@Override
		public String getMachineName() {
			// TODO Auto-generated method stub
			return "M1";
		}

		@Override
		public String getMachineIP() {
			// TODO Auto-generated method stub
			String hostname = "Unknown";
			InetAddress addr = null;
			try
			{
			    
			    addr = InetAddress.getLocalHost();
			    hostname = addr.getHostName();
			}
			catch (UnknownHostException ex)
			{
			    System.out.println("Hostname can not be resolved");
			}
			return addr.toString();
		}
		
	},
	
	Slave1(){

		@Override
		public String getMachineName() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getMachineIP() {
			// TODO Auto-generated method stub
			return null;
		}
		
	},
	Slave2(){

		@Override
		public String getMachineName() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getMachineIP() {
			// TODO Auto-generated method stub
			return null;
		}
		
	},
	Slave3(){

		@Override
		public String getMachineName() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getMachineIP() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	

}
