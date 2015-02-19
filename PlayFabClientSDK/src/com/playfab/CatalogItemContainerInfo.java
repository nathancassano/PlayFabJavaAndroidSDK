package com.playfab;

import java.util.HashMap;
import java.util.Date;


/*
 * Containers are inventory items that can hold other items defined in the catalog, as well as virtual currency, which is added to the player inventory when the container is unlocked, using the UnlockContainerItem API. The items can be anything defined in the catalog, as well as RandomResultTable objects which will be resolved when the container is unlocked. Containers and their keys should be defined as Consumable (having a limited number of uses) in their catalog defintiions, unless the intent is for the player to be able to re-use them infinitely.
 */
public class CatalogItemContainerInfo
{
	
	
	/// <summary>
	/// ItemId for the catalog item used to unlock the container, if any (if not specified, a call to UnlockContainerItem will open the container, adding the contents to the player inventory and currency balances)
	/// </summary>
	
	public String KeyItemId;
	
	/// <summary>
	/// unique ItemId values for all items which will be added to the player inventory, once the container has been unlocked
	/// </summary>
	
	public String[] ItemContents;
	
	/// <summary>
	/// unique TableId values for all RandomResultTable objects which are part of the container (once unlocked, random tables will be resolved and add the relevant items to the player inventory)
	/// </summary>
	
	public String[] ResultTableContents;
	
	/// <summary>
	/// virtual currency types and balances which will be added to the player inventory when the container is unlocked
	/// </summary>
	
	public HashMap<String,Integer> VirtualCurrencyContents;
}
