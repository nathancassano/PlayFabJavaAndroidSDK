package com.playfab;

import java.util.HashMap;
import java.util.Date;


public class AndroidDevicePushNotificationRegistrationRequest
{
	
	
	/// <summary>
	/// the Registration ID provided by the Google Cloud Messaging service when the title registered to receive push notifications (see the GCM documentation, here: http://developer.android.com/google/gcm/client.html)
	/// </summary>
	
	public String DeviceToken;
	
	/// <summary>
	/// If true, send a test push message immediately after sucessful registration. Defaults to false.
	/// </summary>
	
	public Boolean SendPushNotificationConfirmation;
	
	/// <summary>
	/// Message to display when confirming push notification.
	/// </summary>
	
	public String ConfirmationMessege;
}
