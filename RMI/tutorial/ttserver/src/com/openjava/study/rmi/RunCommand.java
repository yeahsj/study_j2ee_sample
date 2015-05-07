package com.openjava.study.rmi;

public class RunCommand {
	public static void main(String[] args) {
		String basePath = "/opt/rmisrv";
		String classpath = basePath + "/classes:" + basePath
				+ "/resource/compute.jar";
		String codebase = "http://yeahsj.com/html/rmi/server/compute.jar";
		String hostname = "yeahsj.com";
		String policy = basePath + "/resource/server.policy";
		String exeClass = "com.openjava.study.rmi.ComputeEngine";
		StringBuilder sb = new StringBuilder();
		sb.append("java");
		sb.append(" -cp ");
		sb.append(classpath);
		sb.append("\\");
		System.out.println(sb.toString());
		sb = new StringBuilder();
		sb.append(" -Djava.rmi.server.codebase=");
		sb.append(codebase);
		sb.append("\\");
		System.out.println(sb.toString());
		sb = new StringBuilder();
		sb.append(" -Djava.rmi.server.hostname=");
		sb.append(hostname);
		sb.append("\\");
		System.out.println(sb.toString());
		sb = new StringBuilder();
		sb.append(" -Djava.security.policy=");
		sb.append(policy);
		sb.append("\\");
		System.out.println(sb.toString());
		sb = new StringBuilder();
		sb.append(" -Djava.security.debug=access,failure");
		sb.append("\\");
		System.out.println(sb.toString());
		sb = new StringBuilder();
		sb.append(" ");
		sb.append(exeClass);
		System.out.println(sb.toString());
	}
}
