package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class CatalogItemConsumableInfo
{
	
	
	/// <summary>
	/// number of times this object can be used, after which it will be removed from the player inventory
	/// </summary>
	
	public Integer UsageCount;
	
	/// <summary>
	/// duration in seconds for how long the item will remain in the player inventory - once elapsed, the item will be removed
	/// </summary>
	
	public Integer UsagePeriod;
	
	/// <summary>
	/// all inventory item instances in the player inventory sharing a non-null UsagePeriodGroup have their UsagePeriod values added together, and share the result - when that period has elapsed, all the items in the group will be removed
	/// </summary>
	
	public String UsagePeriodGroup;
}
