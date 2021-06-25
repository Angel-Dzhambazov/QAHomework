package org.angel.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.swing.text.Utilities;

public class HttpClient
{
	private String baseURl;

	public HttpClient(String baseURl)
	{
		super();
		this.baseURl = baseURl;

	}

	/*
	public int connect(String suffix)
	{
		int status = -999;
		try
		{
			URL url = new URL(baseURl + suffix);
			System.out.println(url.toString());
			connection = (HttpURLConnection) url.openConnection();
			status = connection.getResponseCode();
			System.out.println(status);

		} catch (IOException e)
		{

			e.printStackTrace();
		}
		return status;
	}

	*/

	// TODO make reqeustType to be enum
	public StringBuffer executeRequest(String requestTypeMethod, String suffix)
	{
		int status = -999;


		BufferedReader in;
		StringBuffer content = new StringBuffer();
		try
		{
			URL url = new URL(baseURl + suffix);
			System.out.println(url.toString());
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			status = connection.getResponseCode();
			System.out.println(status);


			connection.setRequestMethod(requestTypeMethod);
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			String inputLine;


			while ((inputLine = in.readLine()) != null)
			{
				content.append(inputLine);
			}
			in.close();
			connection.disconnect();

		} catch (IOException e1)
		{

			e1.printStackTrace();
		}


		return content;

	}

	// execute post execute get

	public void getPetId(int id)
	{

	}

	// post animal
	// put animal/

	// get animal.
}
