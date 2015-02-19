package com.playfab;

import java.util.HashMap;
import java.util.Date;


/*
 * A unique instance of an item in a user's inventory
 */
public class ItemInstance
{
	
	
	/// <summary>
	/// unique identifier for the inventory item, as defined in the catalog
	/// </summary>
	
	public String ItemId;
	
	/// <summary>
	/// unique item identifier for this specific instance of the item
	/// </summary>
	
	public String ItemInstanceId;
	
	/// <summary>
	/// class name for the inventory item, as defined in the catalog
	/// </summary>
	
	public String ItemClass;
	
	/// <summary>
	/// timestamp for when this instance was purchased
	/// </summary>
	
	public Date PurchaseDate;
	
	/// <summary>
	/// timestamp for when this instance will expire
	/// </summary>
	
	public Date Expiration;
	
	/// <summary>
	/// total number of remaining uses, if this is a consumable item
	/// </summary>
	
	public Integer RemainingUses;
	
	/// <summary>
	/// game specific comment associated with this instance when it was added to the user inventory
	/// </summary>
	
	public String Annotation;
	
	/// <summary>
	/// catalog version for the inventory item, when this instance was created
	/// </summary>
	
	public String CatalogVersion;
	
	/// <summary>
	/// unique identifier for the parent inventory item, as defined in the catalog, for object which were added from a bundle or container
	/// </summary>
	
	public String BundleParent;
}
