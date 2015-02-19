package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class PaymentOption
{
	
	
	/// <summary>
	/// specific currency to use to fund the purchase
	/// </summary>
	
	public String Currency;
	
	/// <summary>
	/// name of the purchase provider for this option
	/// </summary>
	
	public String ProviderName;
	
	/// <summary>
	/// amount of the specified currency needed for the purchase
	/// </summary>
	
	public Integer Price;
	
	/// <summary>
	/// amount of existing credit the user has with the provider
	/// </summary>
	
	public Integer StoreCredit;
}
