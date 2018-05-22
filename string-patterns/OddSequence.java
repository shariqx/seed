public class OddSequence
{
/*
    Proudces something like this
          1
         131
        13531
       1357531
      135797531
      135797531
       1357531
        13531
         131
          1

    Generate it for n = 100 or above and we see some great pattern, as
    found in the screenshot attached in the directory.


*/
}
	public static void main(String[] args) throws Exception
	{
	    int n = 10 ;

		int whereTo = 0;
		if(n % 2 == 0)
			whereTo = n/2;
		else 
			whereTo = (n/2) + 1;
		for(int i = 0; i <n; i++)
		{
			int y = 0;
			if(i < whereTo)
				y = n - i;
			else
				y = i + 1;
			while(y > 0)
			{
				System.out.print(" ");
				y--;
			}
			if(i<whereTo)
				System.out.println(gimmeOddNum(i+1,0) + gimmeOddNum(i,1));
			if(i >= whereTo)
				System.out.println(gimmeOddNum(n-i , 0) + gimmeOddNum(n-i - 1,1));
		}
			
	}
	
	
	public static String gimmeOddNum(int howManyOdds,int seq)
	{
		StringBuffer sb= new StringBuffer();
		int res = -1;
		for(int i=0; i<howManyOdds; i++)
		{
			res += 2;
			sb.append(String.valueOf(res));
		}
		if(seq == 1)
			return sb.reverse().toString();
		return sb.toString();
				
	}
}
