package convertor;

public class Digit_or
{
	public static boolean digit_or_string(String s)
	{
		boolean status=false;
		try
		{
			for(int i=0;i<=s.length()-1;i++)
			{
				if(Character.isDigit(s.charAt(i))==true)
				{
					status=true;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}

}
