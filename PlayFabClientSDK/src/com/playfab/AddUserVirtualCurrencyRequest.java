package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class AddUserVirtualCurrencyRequest
{
	
	
	/// <summary>
	/// name of the virtual currency which is to be incremented
	/// </summary>
	
	public String VirtualCurrency;
	
	/// <summary>
	/// amount to be added to the user balance of the specified virtual currency
	/// </summary>
	
	public Integer Amount;
}
