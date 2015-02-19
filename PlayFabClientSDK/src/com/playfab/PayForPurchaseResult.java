package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class PayForPurchaseResult
{
	
	
	/// <summary>
	/// purchase order identifier
	/// </summary>
	
	public String OrderId;
	
	/// <summary>
	/// status of the transaction
	/// </summary>
	
	public TransactionStatus Status;
	
	/// <summary>
	/// virtual currency cost of the transaction
	/// </summary>
	
	public HashMap<String,Integer> VCAmount;
	
	/// <summary>
	/// real world currency for the transaction
	/// </summary>
	
	public String PurchaseCurrency;
	
	/// <summary>
	/// real world cost of the transaction
	/// </summary>
	
	public Integer PurchasePrice;
	
	/// <summary>
	/// local credit applied to the transaction (provider specific)
	/// </summary>
	
	public Integer CreditApplied;
	
	/// <summary>
	/// provider used for the transaction
	/// </summary>
	
	public String ProviderData;
	
	/// <summary>
	/// url to the purchase provider page that details the purchase
	/// </summary>
	
	public String PurchaseConfirmationPageURL;
	
	/// <summary>
	/// current virtual currency totals for the user
	/// </summary>
	
	public HashMap<String,Integer> VirtualCurrency;
}
