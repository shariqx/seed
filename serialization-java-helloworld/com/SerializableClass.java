package com;

import java.io.Serializable;

public class SerializableClass implements Serializable
{
	StringBuffer sb = new StringBuffer() ; 
	
	public SerializableClass()
	{
		sb.append("Test");
	}
	
	public String readSb()
	{
		return sb.toString(); 
	}
}
