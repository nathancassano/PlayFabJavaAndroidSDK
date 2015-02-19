package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class ConsumeItemRequest
{
	
	
	/// <summary>
	/// unique instance identifier of the item to be consumed
	/// </summary>
	
	public String ItemInstanceId;
	
	/// <summary>
	/// number of uses to consume from the item
	/// </summary>
	
	public Integer ConsumeCount;
}
