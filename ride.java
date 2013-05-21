/*
ID: laijuma1
LANG: JAVA
TASK: ride
*/

import java.io.*;
import java.util.*;

class ride
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("ride.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));

		String cometName = f.readLine();
		String groupName = f.readLine();

		int cometCode = getCode(cometName.toCharArray());
		int groupCode = getCode(groupName.toCharArray());

		if(cometCode == groupCode)
		{
		  out.println("GO");
		}
		else
		{
		   out.println("STAY");
	    }

		out.close();
		System.exit(0);
	}

	private static int getCode(char[] name)
	{
		int code = 1;
		for(int i = 0; i < name.length;i ++)
		{
			code = code * (name[i] - 'A' + 1);
		}

		return code % 47;
	}
}