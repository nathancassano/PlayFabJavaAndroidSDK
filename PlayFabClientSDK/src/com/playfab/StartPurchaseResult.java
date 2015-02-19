package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class StartPurchaseResult
{
	
	
	/// <summary>
	/// purchase order identifier
	/// </summary>
	
	public String OrderId;
	
	/// <summary>
	/// cart items to be purchased
	/// </summary>
	
	public CartItem[] Contents;
	
	/// <summary>
	/// available methods by which the user can pay
	/// </summary>
	
	public PaymentOption[] PaymentOptions;
	
	/// <summary>
	/// current virtual currency totals for the user
	/// </summary>
	
	public HashMap<String,Integer> VirtualCurrencyBalances;
}
