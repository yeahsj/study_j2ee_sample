package com.openjava.study.rmi;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RMIClassLoader;
import java.rmi.server.UnicastRemoteObject;

public class ComputeEngine implements Compute {

	// public ComputeEngine() {
	// // super();
	// }

	protected ComputeEngine() {
		super();
	}

	@Override
	public <T> T executeTask(Task<T> t) throws RemoteException {
		return t.execute();
	}

	public static void main(String[] args) throws MalformedURLException,
			ClassNotFoundException {
		String userDir = System.getProperty("user.dir");
		System.out.println("userDir is " + userDir);
		// System.setProperty(
		// "java.security.policy",
		// "file:///home/sangjun/code/study/study_j2ee_sample/RMI/tutorial/ttserver/resource/server.policy");

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
			System.out.println(" new security manager");

			Class<?> InterfaceMath = RMIClassLoader
					.loadClass("http://yeahsj.com/html/rmi/server/compute.jar",
							"com.openjava.study.rmi.Compute");
			Class<?> TaskMath = RMIClassLoader
					.loadClass("http://yeahsj.com/html/rmi/server/compute.jar",
							"com.openjava.study.rmi.Task");
		}
		try {
			String name = "Compute";
			Compute engine = new ComputeEngine();
			System.out.println(" start export object");
			Compute stub = (Compute) UnicastRemoteObject
					.exportObject(engine, 0); //这一步将会产生一个服务器进程,会绑定到localhost的某一端口运行
			System.out.println("stub type: " + stub.getClass());
			Registry registry = LocateRegistry.getRegistry();//获取本机RMI注册机			
			registry.rebind(name, stub); //将之前启动的业务服务器绑定到本机RMI注册机
			System.out.println("ComputeEngine bound");
		} catch (Exception e) {
			System.err.println("ComputeEngine exception:");
			e.printStackTrace();
		}
	}
}
