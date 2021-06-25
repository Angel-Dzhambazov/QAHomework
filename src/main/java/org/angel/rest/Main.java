package org.angel.rest;

import java.io.IOException;

public class Main
{
	public static void main(String[] args)
	{
		HttpClient httpClient = new HttpClient(Constants.petStoreURL);

		//System.out.println(httpClient.executeRequest(Constants.GET, Constants.suffixAccessPet + "16"));

		System.out.println(httpClient.executeRequest("GET", Constants.suffixAccessPet + "16"));


	}
}
