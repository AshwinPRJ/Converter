package com.vyavharamitra.common.service.implementation;
/**
 * @author : M Mohan
 * @created date : 18 Nov 2017
 * @modified by :
 * @modified date :
 */
import java.math.BigInteger;
import java.util.ArrayList;

public class KeyGeneration {
	public ArrayList<BigInteger> delarKey(Integer number) {
		ArrayList<BigInteger> generatedKeys = new ArrayList<>();
		for (int i = 1; i <= number; i++) {
			long s1 = Math.round(Math.random() * 50000) + 10000;
			long s2 = Math.round(Math.random() * 50000) + 10000;
			long s3 = Math.round(Math.random() * 50000) + 10000;
			long s4 = Math.round(Math.random() * 50000) + 10000;

			String strGenerateKey = "" + s1 + s2 + s3 + s4;
	
			generatedKeys.add(new BigInteger(strGenerateKey));
		}
		return generatedKeys;
	}
	
	
}