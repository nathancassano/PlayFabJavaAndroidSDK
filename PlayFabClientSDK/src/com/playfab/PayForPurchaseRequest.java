package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class PayForPurchaseRequest
{
	
	
	/// <summary>
	/// purchase order identifier returned from StartPurchase
	/// </summary>
	
	public String OrderId;
	
	/// <summary>
	/// payment provider to use to fund the purchase
	/// </summary>
	
	public String ProviderName;
	
	/// <summary>
	/// currency to use to fund the purchase
	/// </summary>
	
	public String Currency;
}
