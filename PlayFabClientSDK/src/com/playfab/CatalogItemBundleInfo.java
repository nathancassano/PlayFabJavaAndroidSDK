package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class CatalogItemBundleInfo
{
	
	
	/// <summary>
	/// unique ItemId values for all items which will be added to the player inventory when the bundle is added
	/// </summary>
	
	public String[] BundledItems;
	
	/// <summary>
	/// unique TableId values for all RandomResultTable objects which are part of the bundle (random tables will be resolved and add the relevant items to the player inventory when the bundle is added)
	/// </summary>
	
	public String[] BundledResultTables;
	
	/// <summary>
	/// virtual currency types and balances which will be added to the player inventory when the bundle is added
	/// </summary>
	
	public HashMap<String,Integer> BundledVirtualCurrencies;
}
