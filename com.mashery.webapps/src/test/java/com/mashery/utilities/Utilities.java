package com.mashery.utilities;

import java.net.HttpURLConnection;
import java.net.URL;

public class Utilities {

	public static void verifyLinkActive(String aUrl) {

		try {

			URL url = new URL(aUrl);

			HttpURLConnection HttpURLConnecton = (HttpURLConnection) url.openConnection();

			HttpURLConnecton.setConnectTimeout(2000);

			HttpURLConnecton.connect();

			if (HttpURLConnecton.getResponseCode() == 200) {
				System.out.println("URL " + "- " + aUrl + "- " + HttpURLConnecton.getResponseCode());
			} else if (HttpURLConnecton.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
				System.out.println("URL " + "- " + aUrl + "- " + HttpURLConnection.HTTP_NOT_FOUND);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
