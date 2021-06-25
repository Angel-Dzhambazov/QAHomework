package org.angel.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestTest
{
	private static String basicURLtoExecute;

	public static void main(String[] args) throws IOException
	{
		System.out.println("Hello Move Digital!");

		// TODO replace with try catch later
		int petID = 16;
		basicURLtoExecute = Constants.petStoreURL + Constants.suffixAccessPet + petID;
		URL url = new URL(basicURLtoExecute);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");

		int status = con.getResponseCode();
		System.out.println(status);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer content = new StringBuffer();
		while ((inputLine = in.readLine()) != null)
		{
			content.append(inputLine);
		}

		System.out.println(content);

		in.close();

		con.disconnect();

		System.out.println("end");


	}
}
