package org.angel.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class RestTest
{
	private static String basicURLtoExecute;

	public static void main(String[] args) throws IOException
	{
		System.out.println("Hello Move Digital!");

		// this is post method to create pet
		postAnimalByIDandName(23, "Pet23", "sold");

		// this is GET method to check if created pet is seen.
		getPetByID(23);

		System.out.println("end");

	}

	private static void getPetByID(int id) throws MalformedURLException, IOException, ProtocolException
	{
		int petID = id;
		basicURLtoExecute = Constants.petStoreURL + Constants.suffixAccessPet + "/" + petID;
		URL url = new URL(basicURLtoExecute);
		System.out.println(url.toString());
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
	}

	private static void postAnimalByIDandName(int id, String name, String status)
			throws MalformedURLException, IOException, ProtocolException
	{
		System.out.println("we will execute post command for pet:");
		System.out.println("ID = " + id + " name = " + name + " status = " + status);
		basicURLtoExecute = Constants.petStoreURL + Constants.suffixAccessPet;
		URL url = new URL(basicURLtoExecute);
		HttpURLConnection http = (HttpURLConnection) url.openConnection();
		http.setRequestMethod("POST");
		http.setDoOutput(true);
		http.setRequestProperty("accept", "application/json");
		http.setRequestProperty("Content-Type", "application/xml");

		String data = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<Pet>\n	<id>" + id
				+ "</id>\n	<Category>\n		<id>" + id + "</id>\n		<name>" + name
				+ "</name>\n	</Category>\n	<name>" + name + "</name>\n	<tags>\n		<Tag>\n			<id>" + id
				+ "</id>\n			<name>" + name + "</name>\n		</Tag>\n	</tags>\n	<status>" + status
				+ "</status>\n</Pet>";

		byte[] out = data.getBytes(StandardCharsets.UTF_8);

		OutputStream stream = http.getOutputStream();
		stream.write(out);

		System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
		http.disconnect();

		System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
		http.disconnect();
	}
}
