package org.sheida;

import net.webservicex.www.GeoIPService;
import net.webservicex.www.GeoIPServiceSoap;
import net.webservicex.www.GeoIPServiceLocator;

import java.io.IOException;
import java.rmi.RemoteException;

import net.webservicex.www.GeoIP;

public class IPLocationFinder {

	public static void main (String [] args ) {
	
		if (args.length != 1) {
			System.out.println ("you need to pass the IP address");
		} else {
			String ipAddress = args[0];
			GeoIPServiceLocator ipServiceloc = new GeoIPServiceLocator();
			try {
			GeoIPServiceSoap stub = ipServiceloc.getGeoIPServiceSoap();
			GeoIP geo = stub.getGeoIP(ipAddress);
		    System.out.println (geo.getCountryName());
			} catch ( javax.xml.rpc.ServiceException | IOException e) {
				
			}
		}
	}
}
