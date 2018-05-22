package com;

import java.lang.reflect.Method;

public class TestCallMe
{
	public static void main(String[] args)
	{
		try
		{
			Class callMe = Class.forName("com.CallMe");
					
			Object callMeObj = (CallMe)callMe.newInstance(); 
			Method m = callMe.getMethod("maybe", String.class);
			m.invoke(callMeObj, "This is the input argument.");
		}
		catch(ClassNotFoundException cfe)
		{
			cfe.printStackTrace();
		}
		catch(IllegalAccessException iae)
		{
			iae.printStackTrace();
		}
		catch(InstantiationException ie)
		{
			ie.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
