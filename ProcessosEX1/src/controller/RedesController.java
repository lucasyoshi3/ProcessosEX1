package controller;

import java.io.*;
import java.util.Arrays;

public class RedesController {
	
	public RedesController() {
		super();
	}
	
	public String os() {
		String os=System.getProperty("os.name");
		return os;
	}
	
	public void ip(String os) {
		
		String leitor;
		String ipconfig=null;
		if(os=="Linux") {
			ipconfig="ifconfig";
		}else {
			ipconfig="IPCONFIG";
		}
		
		String [] adaptadorDiv=new String[2];
		String adaptador=null;
		String[] ipv=new String[2];
		try {
			Process ip=Runtime.getRuntime().exec(ipconfig);
			BufferedReader input = new BufferedReader(new InputStreamReader(ip.getInputStream()));
			while ((leitor = input.readLine()) != null) {
				adaptadorDiv=leitor.split("daptador");
				
				if(adaptadorDiv[0].equals("A")) {
					adaptador=leitor;
				}
				ipv=leitor.split("IPv4. . . . . . . .  . . . . . . . : ");
				if(ipv.length==2) {
					System.out.println(adaptador+" "+ipv[1]);
				}
            }
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void ping(String os) {
		String leitor;
		String verPing=null;
		String []mediaPing=new String[3];
		if(os=="Linux") {
			verPing="ping -4 -c 10 www.google.com.br";
		}else {
			verPing="ping -4 -n 10 www.google.com.br";
		}
		try {
			Process ping=Runtime.getRuntime().exec(verPing);
			BufferedReader input=new BufferedReader(new InputStreamReader(ping.getInputStream()));
			while((leitor=input.readLine())!=null) {
				mediaPing=leitor.split("ms");
				if(mediaPing.length==3) {
					mediaPing=mediaPing[2].split("=");
					System.out.println("Media ping: "+mediaPing[1]+"ms");
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
