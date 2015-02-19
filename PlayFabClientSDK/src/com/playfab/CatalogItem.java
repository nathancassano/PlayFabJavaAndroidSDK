package com.playfab;

import java.util.HashMap;
import java.util.Date;


/*
 * A purchasable item from the item catalog
 */
public class CatalogItem
{
	
	
	/// <summary>
	/// unique identifier for this item
	/// </summary>
	
	public String ItemId;
	
	/// <summary>
	/// class to which the item belongs
	/// </summary>
	
	public String ItemClass;
	
	/// <summary>
	/// catalog item for this item
	/// </summary>
	
	public String CatalogVersion;
	
	/// <summary>
	/// text name for the item, to show in-game
	/// </summary>
	
	public String DisplayName;
	
	/// <summary>
	/// text description of item, to show in-game
	/// </summary>
	
	public String Description;
	
	/// <summary>
	/// price of this item in virtual currencies and "RM" (the base Real Money purchase price, in USD pennies)
	/// </summary>
	
	public HashMap<String,Integer> VirtualCurrencyPrices;
	
	/// <summary>
	/// override prices for this item for specific currencies
	/// </summary>
	
	public HashMap<String,Integer> RealCurrencyPrices;
	
	/// <summary>
	/// list of item tags
	/// </summary>
	
	public String[] Tags;
	
	/// <summary>
	/// game specific custom data
	/// </summary>
	
	public String CustomData;
	
	/// <summary>
	/// array of ItemId values which are evaluated when any item is added to the player inventory - if all items in this array are present, the this item will also be added to the player inventory
	/// </summary>
	
	public String[] GrantedIfPlayerHas;
	
	/// <summary>
	/// defines the consumable properties (number of uses, timeout) for the item
	/// </summary>
	
	public CatalogItemConsumableInfo Consumable;
	
	/// <summary>
	/// defines the container properties for the item - what items it contains, including random drop tables and virtual currencies, and what item (if any) is required to open it via the UnlockContainerItem API
	/// </summary>
	
	public CatalogItemContainerInfo Container;
	
	/// <summary>
	/// defines the bundle properties for the item - bundles are items which contain other items, including random drop tables and virtual currencies
	/// </summary>
	
	public CatalogItemBundleInfo Bundle;
}
