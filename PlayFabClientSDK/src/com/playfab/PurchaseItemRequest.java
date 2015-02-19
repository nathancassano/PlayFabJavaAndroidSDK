package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class PurchaseItemRequest
{
	
	
	/// <summary>
	/// unique ItemId of the item to purchase
	/// </summary>
	
	public String ItemId;
	
	/// <summary>
	/// virtual currency to use to purchase the item
	/// </summary>
	
	public String VirtualCurrency;
	
	/// <summary>
	/// price the client expects to pay for the item (in case a new catalog or store was uploaded, with new prices)
	/// </summary>
	
	public Integer Price;
	
	/// <summary>
	/// catalog version for the items to be purchased (defaults to most recent version
	/// </summary>
	
	public String CatalogVersion;
	
	/// <summary>
	/// store to buy this item through. If not set, prices default to those in the catalog.
	/// </summary>
	
	public String StoreId;
}
