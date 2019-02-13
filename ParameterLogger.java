
/*
 *	Give this guy the list of paramters, and it'll return you a nice Logging code. 
 *  Customize it with your LOG object name, and log level.  
 *  'cuz we all of us hate repetitive work!
 */
public class ParameterLogger {
	public static void main(String a[]) throws Exception{
		System.out.println(
				
				createLogger("int a_EntID, String a_Ownertype,int a_OwnerID, String a_ItemType, int a_ItemID,String a_StartDate"));
	}
	
	 public static String createLogger(String a_parameters) throws Exception
	{
		try{
		String loggerReturn = processParamtersAndReturnLogger(a_parameters,"LOGGER","info",true);
		return loggerReturn;
		}
		
		finally
		{
		}
}

	private static String processParamtersAndReturnLogger(
			String w_allTheParameters,String a_logObjName,String a_logObjLevel,boolean isNewLineReq) {
		String loggerout = a_logObjName + "." +a_logObjLevel + "(";
		String[] singleSplit = w_allTheParameters.split(",");
		for(String a : singleSplit){
			String[] b = a.trim().split(" ");
			loggerout += "\""+b[1] +"\" +" + b[1] ;
			if(isNewLineReq)
				loggerout +="\n +";
			else
				loggerout +="+";
			
		}
		return loggerout +"\"\""+ ");";
	}
}
