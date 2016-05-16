package home.generictests;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class IoTest {

	public int solution(String flName) {
		try ( FileInputStream fis = new FileInputStream(flName);
				BufferedReader brdr = new BufferedReader(new InputStreamReader(fis))) {
			System.out.println("Here");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	return 1;
	}
	
	public static void main(String[] args) {
		String ret = new Reverse().reverse("abcdefg54321");
		System.out.println(ret);

	}
 }

