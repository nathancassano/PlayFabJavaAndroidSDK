package com.playfab;

import java.util.HashMap;
import java.util.Date;


/*
 * A store entry that list a catalog item at a particular price
 */
public class StoreItem
{
	
	
	/// <summary>
	/// unique identifier of the item as it exists in the catalog - note that this must exactly match the ItemId from the catalog
	/// </summary>
	
	public String ItemId;
	
	/// <summary>
	/// catalog version for this item
	/// </summary>
	
	public String CatalogVersion;
	
	/// <summary>
	/// price of this item in virtual currencies and "RM" (the base Real Money purchase price, in USD pennies)
	/// </summary>
	
	public HashMap<String,Integer> VirtualCurrencyPrices;
	
	/// <summary>
	/// override prices for this item for specific currencies
	/// </summary>
	
	public HashMap<String,Integer> RealCurrencyPrices;
}
