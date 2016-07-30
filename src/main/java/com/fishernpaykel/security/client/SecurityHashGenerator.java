package com.fishernpaykel.security.client;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.logging.Logger;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;


/**
 * This method will generate HMACSHA256 hash from user's inputs requested. 
 *
 */
public class SecurityHashGenerator 
{

	private static final Logger log = Logger.getLogger(SecurityHashGenerator.class.getName());
	
    public static void main( String[] args )
    {
    	System.out.println("##############################################");
    	System.out.println("##############################################");
        System.out.println("##                                          ##");
        System.out.println("##    HMACSHA256 Hash/Signature generator   ##");
        System.out.println("##                                          ##");
    	System.out.println("##############################################");
    	System.out.println("##############################################");
    	System.out.println();
    	System.out.println(" Kindly enter details as prompted: ");
    	System.out.println();

    	try 
    	(
    		// To read data from System.in
    	    Scanner reader = new Scanner(System.in);
    	)
    	{
	    	// 1. Name
	    	// This requests for name from the user
	    	System.out.print("     Enter your name : ");
	    	// Scans the next token of the input as a String
	    	String name = reader.nextLine(); 
	    	
	    	
	    	// 2. Email
	    	// This requests for email from the user
	    	System.out.print("Enter your e-mail id : ");
	    	// Scans the next token of the input as a String
	    	String email = reader.next(); 
	    	
	    	
	    	// 3. Country
	    	// This requests for country name from the user
	    	System.out.print("  Enter your address : ");
	    	// Scans the next token of the input as a String
	    	String address = reader.next(); 
    	

	    	System.out.println();
    		System.out.println("The hash/signature for your data entered is: ");
			System.out.println(sign(name+","+email+","+address, "SECRET_KEY"));
			
		} 
    	catch (InvalidKeyException | NoSuchAlgorithmException | UnsupportedEncodingException e) 
    	{
			log.severe(e.getMessage());
		}
    }
    
	private static final String sign(final String data, final String secretKey) 
    		throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException
	{
		final String HMAC_SHA256 = "HmacSHA256";
		final SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), HMAC_SHA256);
		final Mac mac = Mac.getInstance(HMAC_SHA256);
		mac.init(secretKeySpec);
		final byte[] rawHmac = mac.doFinal(data.getBytes("UTF-8"));
		
		return DatatypeConverter.printBase64Binary(rawHmac).replace("\n", "");
	}
}
