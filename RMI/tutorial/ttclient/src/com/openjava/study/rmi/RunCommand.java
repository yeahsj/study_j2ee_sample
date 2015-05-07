package com.openjava.study.rmi;

public class RunCommand {
	public static void main(String[] args) {
		String basePath = "/opt/rmiclt";
		String classpath = basePath + "/classes:" + basePath +"/resource/compute.jar";
		String hostname = "yeahsj.com";
		String policy = basePath + "/resource/client.policy";
		String exeClass = "com.openjava.study.rmi.ComputePi";
		StringBuilder sb = new StringBuilder();
		
		
		
		sb.append("java");
		sb.append(" -cp ");
		sb.append(classpath);
		sb.append("\\");
		System.out.println( sb );
		sb = new StringBuilder();
		sb.append(" -Djava.security.policy=");
		sb.append(policy);
		sb.append("\\");
		System.out.println( sb );
		sb = new StringBuilder();
		sb.append(" -Djava.security.debug=access,failure");
		sb.append("\\ ");
		System.out.println( sb );
		sb = new StringBuilder();
		sb.append(exeClass);
		sb.append(" ");
		sb.append(hostname);
		sb.append(" ");
		sb.append(45);
		System.out.println(sb.toString());
	}
}
