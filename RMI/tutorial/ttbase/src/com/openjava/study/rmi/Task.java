package com.openjava.study.rmi;

public interface Task<T> {
	T execute();
}