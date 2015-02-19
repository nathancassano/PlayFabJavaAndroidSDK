package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class SubtractUserVirtualCurrencyRequest
{
	
	
	/// <summary>
	/// name of the virtual currency which is to be decremented
	/// </summary>
	
	public String VirtualCurrency;
	
	/// <summary>
	/// amount to be subtracted from the user balance of the specified virtual currency
	/// </summary>
	
	public Integer Amount;
}
