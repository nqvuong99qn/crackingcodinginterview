package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.RandomAccess;

public class EncodeDecode {
	
	Map<String, String> map = new HashMap<>();
	
	String characters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	int count = 6;
	
	public String getKey() {
		String key = "";
		while(count > 0) {
			count--;
			key += characters.charAt(count);
			
		}
		return key;
	}
	
	public String encode(String longUrl) {
		String key = getKey();
		map.put(key, longUrl);
		return "..." + key;
	}
	
	public String decode(String shortUrl) {
		return map.get(shortUrl.replace("...", ""));
	}
	
	
	
	
	public static void main(String[] args) {
		
		System.out.println("say hi!!");
		
		EncodeDecode test = new EncodeDecode();
		
		System.out.println(test.encode("abcde"));
		
		
		System.out.println(test.decode("...543210"));
		
		
	}

}
