package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class ItemPuchaseRequest
{
	
	
	/// <summary>
	/// unique ItemId of the item to purchase
	/// </summary>
	
	public String ItemId;
	
	/// <summary>
	/// how many of this item to purchase
	/// </summary>
	
	public Integer Quantity;
	
	/// <summary>
	/// title-specific text concerning this purchase
	/// </summary>
	
	public String Annotation;
	
	/// <summary>
	/// items to be upgraded as a result of this purchase (upgraded items are hidden, as they are "replaced" by the new items)
	/// </summary>
	
	public String[] UpgradeFromItems;
}
