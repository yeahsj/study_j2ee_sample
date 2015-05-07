package com.openjava.study.rmi;

import java.math.BigDecimal;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ComputePi {
	public static void main(String args[]) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		try {
			String name = args[2];
			if (null == name || name.equals("")) {
				name = "Compute";
			}
			System.out.println(args[0]);
			Registry registry = LocateRegistry.getRegistry(args[0]);
			Compute comp = (Compute) registry.lookup(name);
			Task<BigDecimal> task = new Pi(Integer.parseInt(args[1]));
			BigDecimal pi = comp.executeTask(task);
			System.out.println(pi);
		} catch (Exception e) {
			System.err.println("ComputePi exception:");
			e.printStackTrace();
		}
	}
}
