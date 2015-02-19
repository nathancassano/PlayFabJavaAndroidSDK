package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class ValidateIOSReceiptRequest
{
	
	
	/// <summary>
	/// base64 encoded receipt data, passed back by the App Store as a result of a successful purchase
	/// </summary>
	
	public String ReceiptData;
	
	/// <summary>
	/// currency used for the purchase
	/// </summary>
	
	public String CurrencyCode;
	
	/// <summary>
	/// amount of the stated currency paid for the object
	/// </summary>
	
	public Integer PurchasePrice;
}
