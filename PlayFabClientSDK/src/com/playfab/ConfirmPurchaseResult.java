package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class ConfirmPurchaseResult
{
	
	
	/// <summary>
	/// purchase order identifier
	/// </summary>
	
	public String OrderId;
	
	/// <summary>
	/// date and time of the purchase
	/// </summary>
	
	public Date PurchaseDate;
	
	/// <summary>
	/// array of items purchased
	/// </summary>
	
	public PurchasedItem[] Items;
}
