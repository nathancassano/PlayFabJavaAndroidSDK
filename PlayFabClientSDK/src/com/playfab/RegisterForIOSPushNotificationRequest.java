package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class RegisterForIOSPushNotificationRequest
{
	
	
	/// <summary>
	/// unique token generated by the Apple Push Notification service when the title registered to receive push notifications
	/// </summary>
	
	public String DeviceToken;
	
	/// <summary>
	/// If true, send a test push message immediately after sucessful registration. Defaults to false.
	/// </summary>
	
	public Boolean SendPushNotificationConfirmation;
	
	/// <summary>
	/// Message to display when confirming push notification.
	/// </summary>
	
	public String ConfirmationMessage;
}
