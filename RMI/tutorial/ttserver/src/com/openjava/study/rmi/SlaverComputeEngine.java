package com.openjava.study.rmi;

import java.net.MalformedURLException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RMIClassLoader;

public class SlaverComputeEngine {
	public static void main(String[] args) throws MalformedURLException,
			ClassNotFoundException {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
			System.out.println(" new security manager");

			Class<?> InterfaceMath = RMIClassLoader.loadClass(
					"http://yeahsj.com/html/rmi/server/compute.jar",
					"com.openjava.study.rmi.Compute");
			Class<?> TaskMath = RMIClassLoader.loadClass(
					"http://yeahsj.com/html/rmi/server/compute.jar",
					"com.openjava.study.rmi.Task");
		}
		try {
			String name = "Compute";
			System.out.println(args[0]);
			Registry remoteRegistry = LocateRegistry.getRegistry(args[0]); //获取远程RMI注册机
			Compute stub = (Compute) remoteRegistry.lookup(name);//从远程RMI注册机获取到业务服务器地址
			System.out.println("stub type: " + stub.getClass());
			Registry localRegistry = LocateRegistry.getRegistry();//获取本地RMI注册机
			localRegistry.rebind("SlaverCompute", stub);//将之前获取的远程业务服务器绑定到本地RMI注册机
			System.out.println("ComputeEngine bound");
		} catch (Exception e) {
			System.err.println("ComputeEngine exception:");
			e.printStackTrace();
		}
	}
}
