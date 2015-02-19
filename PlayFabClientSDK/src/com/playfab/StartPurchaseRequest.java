package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class StartPurchaseRequest
{
	
	
	/// <summary>
	/// catalog version for the items to be purchased. Defaults to most recent catalog.
	/// </summary>
	
	public String CatalogVersion;
	
	/// <summary>
	/// store through which to purchase items. If not set, prices will be pulled from the catalog itself.
	/// </summary>
	
	public String StoreId;
	
	/// <summary>
	/// the set of items to purchase
	/// </summary>
	
	public ItemPuchaseRequest[] Items;
}
