package com.wesleycourtney.parse_emails;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
			String line;
			String archive = "e";
			boolean flag = false;
			boolean completeRecord = false;
			System.out.println("Old Serial, New Serial, PO");
			while ((line = br.readLine()) != null) {
				if (flag) {
					if (completeRecord) {
						archive += line + "\n";
						completeRecord = false;
					} else {
						archive += line + ", ";
					}
					flag = false;
				}
				if (line.contentEquals("original serial") || line.contentEquals("new serial number")) {
					flag = true;
				}
				if (line.contentEquals("po")) {
					flag = true;
					completeRecord = true;
				}
			}
			System.out.println(archive);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
