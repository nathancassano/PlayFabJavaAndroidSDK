package com.playfab;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


/*
 * APIs which provide the full range of PlayFab features available to the client - authentication, account and data management, inventory, friends, matchmaking, reporting, and platform-specific functionality
 */
public class ClientAPI
{
	private final String preference_name = "playfab";
	private static String AuthKey = null;
	
	private String Url;
	private String TitleId;
	private Context context;

	public ClientAPI(Context c)
	{
		context = c;
		
		int playfab_titleid_id = context.getResources().getIdentifier("playfab_titleid", "string", context.getPackageName() );
		
		TitleId = context.getString(playfab_titleid_id);
	
		boolean useDev = false;
		try {
			int playfab_use_development_environment_id = context.getResources().getIdentifier("playfab_use_development_environment", "bool", context.getPackageName() );
			useDev = context.getResources().getBoolean( playfab_use_development_environment_id );
		} catch (Exception e) {}
	
		if( useDev )
		{
			int playfab_development_environment_url = context.getResources().getIdentifier("playfab_development_environment_url", "string", context.getPackageName() );
			Url = context.getString(playfab_development_environment_url);
		}
		else
		{
			int playfab_production_environment_url_id = context.getResources().getIdentifier("playfab_production_environment_url", "string", context.getPackageName() );
			Url = context.getString(playfab_production_environment_url_id);
		}

		if( ! Url.startsWith("http") )
                        Url = "https://" + TitleId + Url;
		
		SharedPreferences pref = context.getSharedPreferences(preference_name, Context.MODE_PRIVATE);
		AuthKey = pref.getString("AuthKey", null);
	}
	
	private void setAuthKey(String value)
	{
		if( value != null && value.length() != 0 )
		{
			AuthKey = value;
			SharedPreferences pref = context.getSharedPreferences(preference_name, Context.MODE_PRIVATE);
			pref.edit()
			.putString("AuthKey", AuthKey)
			.commit();
		}
	}

	public boolean isAuthenticated()
	{
		return AuthKey != null;	
	}

	interface ErrorCallback
	{
		public void OnError( PlayFabError error );
	}

	public interface LoginWithAndroidDeviceID extends ErrorCallback { public void OnResult(LoginResult result); }
	public interface LoginWithFacebook extends ErrorCallback { public void OnResult(LoginResult result); }
	public interface LoginWithGameCenter extends ErrorCallback { public void OnResult(LoginResult result); }
	public interface LoginWithGoogleAccount extends ErrorCallback { public void OnResult(LoginResult result); }
	public interface LoginWithIOSDeviceID extends ErrorCallback { public void OnResult(LoginResult result); }
	public interface LoginWithPlayFab extends ErrorCallback { public void OnResult(LoginResult result); }
	public interface LoginWithSteam extends ErrorCallback { public void OnResult(LoginResult result); }
	public interface RegisterPlayFabUser extends ErrorCallback { public void OnResult(RegisterPlayFabUserResult result); }
	public interface AddUsernamePassword extends ErrorCallback { public void OnResult(AddUsernamePasswordResult result); }
	public interface GetAccountInfo extends ErrorCallback { public void OnResult(GetAccountInfoResult result); }
	public interface GetPlayFabIDsFromFacebookIDs extends ErrorCallback { public void OnResult(GetPlayFabIDsFromFacebookIDsResult result); }
	public interface GetUserCombinedInfo extends ErrorCallback { public void OnResult(GetUserCombinedInfoResult result); }
	public interface LinkAndroidDeviceID extends ErrorCallback { public void OnResult(LinkAndroidDeviceIDResult result); }
	public interface LinkFacebookAccount extends ErrorCallback { public void OnResult(LinkFacebookAccountResult result); }
	public interface LinkGameCenterAccount extends ErrorCallback { public void OnResult(LinkGameCenterAccountResult result); }
	public interface LinkIOSDeviceID extends ErrorCallback { public void OnResult(LinkIOSDeviceIDResult result); }
	public interface LinkSteamAccount extends ErrorCallback { public void OnResult(LinkSteamAccountResult result); }
	public interface SendAccountRecoveryEmail extends ErrorCallback { public void OnResult(SendAccountRecoveryEmailResult result); }
	public interface UnlinkAndroidDeviceID extends ErrorCallback { public void OnResult(UnlinkAndroidDeviceIDResult result); }
	public interface UnlinkFacebookAccount extends ErrorCallback { public void OnResult(UnlinkFacebookAccountResult result); }
	public interface UnlinkGameCenterAccount extends ErrorCallback { public void OnResult(UnlinkGameCenterAccountResult result); }
	public interface UnlinkIOSDeviceID extends ErrorCallback { public void OnResult(UnlinkIOSDeviceIDResult result); }
	public interface UnlinkSteamAccount extends ErrorCallback { public void OnResult(UnlinkSteamAccountResult result); }
	public interface UpdateEmailAddress extends ErrorCallback { public void OnResult(UpdateEmailAddressResult result); }
	public interface UpdatePassword extends ErrorCallback { public void OnResult(UpdatePasswordResult result); }
	public interface UpdateUserTitleDisplayName extends ErrorCallback { public void OnResult(UpdateUserTitleDisplayNameResult result); }
	public interface GetFriendLeaderboard extends ErrorCallback { public void OnResult(GetLeaderboardResult result); }
	public interface GetLeaderboard extends ErrorCallback { public void OnResult(GetLeaderboardResult result); }
	public interface GetLeaderboardAroundCurrentUser extends ErrorCallback { public void OnResult(GetLeaderboardAroundCurrentUserResult result); }
	public interface GetUserData extends ErrorCallback { public void OnResult(GetUserDataResult result); }
	public interface GetUserPublisherData extends ErrorCallback { public void OnResult(GetUserDataResult result); }
	public interface GetUserPublisherReadOnlyData extends ErrorCallback { public void OnResult(GetUserDataResult result); }
	public interface GetUserReadOnlyData extends ErrorCallback { public void OnResult(GetUserDataResult result); }
	public interface GetUserStatistics extends ErrorCallback { public void OnResult(GetUserStatisticsResult result); }
	public interface UpdateUserData extends ErrorCallback { public void OnResult(UpdateUserDataResult result); }
	public interface UpdateUserPublisherData extends ErrorCallback { public void OnResult(UpdateUserDataResult result); }
	public interface UpdateUserStatistics extends ErrorCallback { public void OnResult(UpdateUserStatisticsResult result); }
	public interface GetCatalogItems extends ErrorCallback { public void OnResult(GetCatalogItemsResult result); }
	public interface GetStoreItems extends ErrorCallback { public void OnResult(GetStoreItemsResult result); }
	public interface GetTitleData extends ErrorCallback { public void OnResult(GetTitleDataResult result); }
	public interface GetTitleNews extends ErrorCallback { public void OnResult(GetTitleNewsResult result); }
	public interface AddUserVirtualCurrency extends ErrorCallback { public void OnResult(ModifyUserVirtualCurrencyResult result); }
	public interface ConfirmPurchase extends ErrorCallback { public void OnResult(ConfirmPurchaseResult result); }
	public interface ConsumeItem extends ErrorCallback { public void OnResult(ConsumeItemResult result); }
	public interface GetUserInventory extends ErrorCallback { public void OnResult(GetUserInventoryResult result); }
	public interface PayForPurchase extends ErrorCallback { public void OnResult(PayForPurchaseResult result); }
	public interface PurchaseItem extends ErrorCallback { public void OnResult(PurchaseItemResult result); }
	public interface RedeemCoupon extends ErrorCallback { public void OnResult(RedeemCouponResult result); }
	public interface StartPurchase extends ErrorCallback { public void OnResult(StartPurchaseResult result); }
	public interface SubtractUserVirtualCurrency extends ErrorCallback { public void OnResult(ModifyUserVirtualCurrencyResult result); }
	public interface UnlockContainerItem extends ErrorCallback { public void OnResult(UnlockContainerItemResult result); }
	public interface AddFriend extends ErrorCallback { public void OnResult(AddFriendResult result); }
	public interface GetFriendsList extends ErrorCallback { public void OnResult(GetFriendsListResult result); }
	public interface RemoveFriend extends ErrorCallback { public void OnResult(RemoveFriendResult result); }
	public interface SetFriendTags extends ErrorCallback { public void OnResult(SetFriendTagsResult result); }
	public interface RegisterForIOSPushNotification extends ErrorCallback { public void OnResult(RegisterForIOSPushNotificationResult result); }
	public interface ValidateIOSReceipt extends ErrorCallback { public void OnResult(ValidateIOSReceiptResult result); }
	public interface GetCurrentGames extends ErrorCallback { public void OnResult(CurrentGamesResult result); }
	public interface GetGameServerRegions extends ErrorCallback { public void OnResult(GameServerRegionsResult result); }
	public interface Matchmake extends ErrorCallback { public void OnResult(MatchmakeResult result); }
	public interface StartGame extends ErrorCallback { public void OnResult(StartGameResult result); }
	public interface AndroidDevicePushNotificationRegistration extends ErrorCallback { public void OnResult(AndroidDevicePushNotificationRegistrationResult result); }
	public interface ValidateGooglePlayPurchase extends ErrorCallback { public void OnResult(ValidateGooglePlayPurchaseResult result); }
	public interface LogEvent extends ErrorCallback { public void OnResult(LogEventResult result); }
	public interface AddSharedGroupMembers extends ErrorCallback { public void OnResult(AddSharedGroupMembersResult result); }
	public interface CreateSharedGroup extends ErrorCallback { public void OnResult(CreateSharedGroupResult result); }
	public interface GetPublisherData extends ErrorCallback { public void OnResult(GetPublisherDataResult result); }
	public interface GetSharedGroupData extends ErrorCallback { public void OnResult(GetSharedGroupDataResult result); }
	public interface RemoveSharedGroupMembers extends ErrorCallback { public void OnResult(RemoveSharedGroupMembersResult result); }
	public interface UpdateSharedGroupData extends ErrorCallback { public void OnResult(UpdateSharedGroupDataResult result); }
	public interface RefreshPSNAuthToken extends ErrorCallback { public void OnResult(EmptyResult result); }
	public interface GetCloudScriptUrl extends ErrorCallback { public void OnResult(GetCloudScriptUrlResult result); }
	public interface RunCloudScript extends ErrorCallback { public void OnResult(RunCloudScriptResult result); }
	
	
	
	// Signs the user in using the Android device identifier, returning a session identifier that can subsequently be used for API calls which require an authenticated user 
	public void LoginWithAndroidDeviceID(LoginWithAndroidDeviceIDRequest request, final LoginWithAndroidDeviceID resultCallback)
	{
		request.TitleId = TitleId;

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<LoginResult> success = new JsonSuccess<LoginResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<LoginResult>>(){}.getType() );

					LoginResult result = (LoginResult) success.data;

					setAuthKey( result.SessionTicket );

					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/LoginWithAndroidDeviceID", serializedJSON, null, null, callback);

	}
	// Signs the user in using a Facebook access token, returning a session identifier that can subsequently be used for API calls which require an authenticated user 
	public void LoginWithFacebook(LoginWithFacebookRequest request, final LoginWithFacebook resultCallback)
	{
		request.TitleId = TitleId;

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<LoginResult> success = new JsonSuccess<LoginResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<LoginResult>>(){}.getType() );

					LoginResult result = (LoginResult) success.data;

					setAuthKey( result.SessionTicket );

					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/LoginWithFacebook", serializedJSON, null, null, callback);

	}
	// Signs the user in using an iOS Game Center player identifier, returning a session identifier that can subsequently be used for API calls which require an authenticated user 
	public void LoginWithGameCenter(LoginWithGameCenterRequest request, final LoginWithGameCenter resultCallback)
	{
		request.TitleId = TitleId;

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<LoginResult> success = new JsonSuccess<LoginResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<LoginResult>>(){}.getType() );

					LoginResult result = (LoginResult) success.data;

					setAuthKey( result.SessionTicket );

					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/LoginWithGameCenter", serializedJSON, null, null, callback);

	}
	// Signs the user in using a Google account access token, returning a session identifier that can subsequently be used for API calls which require an authenticated user 
	public void LoginWithGoogleAccount(LoginWithGoogleAccountRequest request, final LoginWithGoogleAccount resultCallback)
	{
		request.TitleId = TitleId;

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<LoginResult> success = new JsonSuccess<LoginResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<LoginResult>>(){}.getType() );

					LoginResult result = (LoginResult) success.data;

					setAuthKey( result.SessionTicket );

					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/LoginWithGoogleAccount", serializedJSON, null, null, callback);

	}
	// Signs the user in using the vendor-specific iOS device identifier, returning a session identifier that can subsequently be used for API calls which require an authenticated user 
	public void LoginWithIOSDeviceID(LoginWithIOSDeviceIDRequest request, final LoginWithIOSDeviceID resultCallback)
	{
		request.TitleId = TitleId;

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<LoginResult> success = new JsonSuccess<LoginResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<LoginResult>>(){}.getType() );

					LoginResult result = (LoginResult) success.data;

					setAuthKey( result.SessionTicket );

					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/LoginWithIOSDeviceID", serializedJSON, null, null, callback);

	}
	// Signs the user into the PlayFab account, returning a session identifier that can subsequently be used for API calls which require an authenticated user 
	public void LoginWithPlayFab(LoginWithPlayFabRequest request, final LoginWithPlayFab resultCallback)
	{
		request.TitleId = TitleId;

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<LoginResult> success = new JsonSuccess<LoginResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<LoginResult>>(){}.getType() );

					LoginResult result = (LoginResult) success.data;

					setAuthKey( result.SessionTicket );

					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/LoginWithPlayFab", serializedJSON, null, null, callback);

	}
	// Signs the user in using a Steam authentication ticket, returning a session identifier that can subsequently be used for API calls which require an authenticated user 
	public void LoginWithSteam(LoginWithSteamRequest request, final LoginWithSteam resultCallback)
	{
		request.TitleId = TitleId;

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<LoginResult> success = new JsonSuccess<LoginResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<LoginResult>>(){}.getType() );

					LoginResult result = (LoginResult) success.data;

					setAuthKey( result.SessionTicket );

					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/LoginWithSteam", serializedJSON, null, null, callback);

	}
	// Registers a new Playfab user account, returning a session identifier that can subsequently be used for API calls which require an authenticated user 
	public void RegisterPlayFabUser(RegisterPlayFabUserRequest request, final RegisterPlayFabUser resultCallback)
	{
		request.TitleId = TitleId;

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<RegisterPlayFabUserResult> success = new JsonSuccess<RegisterPlayFabUserResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<RegisterPlayFabUserResult>>(){}.getType() );

					RegisterPlayFabUserResult result = (RegisterPlayFabUserResult) success.data;

					setAuthKey( result.SessionTicket );

					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/RegisterPlayFabUser", serializedJSON, null, null, callback);

	}
	// Adds playfab username/password auth to an existing semi-anonymous account created via a 3rd party auth method. 
	public void AddUsernamePassword(AddUsernamePasswordRequest request, final AddUsernamePassword resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<AddUsernamePasswordResult> success = new JsonSuccess<AddUsernamePasswordResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<AddUsernamePasswordResult>>(){}.getType() );

					AddUsernamePasswordResult result = (AddUsernamePasswordResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/AddUsernamePassword", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Retrieves the user's PlayFab account details 
	public void GetAccountInfo(GetAccountInfoRequest request, final GetAccountInfo resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<GetAccountInfoResult> success = new JsonSuccess<GetAccountInfoResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<GetAccountInfoResult>>(){}.getType() );

					GetAccountInfoResult result = (GetAccountInfoResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/GetAccountInfo", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Retrieves the unique PlayFab identifiers for the given set of Facebook identifiers. 
	public void GetPlayFabIDsFromFacebookIDs(GetPlayFabIDsFromFacebookIDsRequest request, final GetPlayFabIDsFromFacebookIDs resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<GetPlayFabIDsFromFacebookIDsResult> success = new JsonSuccess<GetPlayFabIDsFromFacebookIDsResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<GetPlayFabIDsFromFacebookIDsResult>>(){}.getType() );

					GetPlayFabIDsFromFacebookIDsResult result = (GetPlayFabIDsFromFacebookIDsResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/GetPlayFabIDsFromFacebookIDs", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Retrieves all requested data for a user in one unified request. By default, this API returns all  data for the locally signed-in user. The input parameters may be used to limit the data retrieved any any subset of the available data, as well as retrieve the available data for a different user. Note that certain data, including inventory, virtual currency balances, and personally identifying information, may only be retrieved for the locally signed-in user. In the example below, a request is made for the account details, virtual currency balances, and specified user data for the locally signed-in user. 
	public void GetUserCombinedInfo(GetUserCombinedInfoRequest request, final GetUserCombinedInfo resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<GetUserCombinedInfoResult> success = new JsonSuccess<GetUserCombinedInfoResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<GetUserCombinedInfoResult>>(){}.getType() );

					GetUserCombinedInfoResult result = (GetUserCombinedInfoResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/GetUserCombinedInfo", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Links the Android device identifier to the user's PlayFab account 
	public void LinkAndroidDeviceID(LinkAndroidDeviceIDRequest request, final LinkAndroidDeviceID resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<LinkAndroidDeviceIDResult> success = new JsonSuccess<LinkAndroidDeviceIDResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<LinkAndroidDeviceIDResult>>(){}.getType() );

					LinkAndroidDeviceIDResult result = (LinkAndroidDeviceIDResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/LinkAndroidDeviceID", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Links the Facebook account associated with the provided Facebook access token to the user's PlayFab account 
	public void LinkFacebookAccount(LinkFacebookAccountRequest request, final LinkFacebookAccount resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<LinkFacebookAccountResult> success = new JsonSuccess<LinkFacebookAccountResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<LinkFacebookAccountResult>>(){}.getType() );

					LinkFacebookAccountResult result = (LinkFacebookAccountResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/LinkFacebookAccount", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Links the Game Center account associated with the provided Game Center ID to the user's PlayFab account 
	public void LinkGameCenterAccount(LinkGameCenterAccountRequest request, final LinkGameCenterAccount resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<LinkGameCenterAccountResult> success = new JsonSuccess<LinkGameCenterAccountResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<LinkGameCenterAccountResult>>(){}.getType() );

					LinkGameCenterAccountResult result = (LinkGameCenterAccountResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/LinkGameCenterAccount", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Links the vendor-specific iOS device identifier to the user's PlayFab account 
	public void LinkIOSDeviceID(LinkIOSDeviceIDRequest request, final LinkIOSDeviceID resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<LinkIOSDeviceIDResult> success = new JsonSuccess<LinkIOSDeviceIDResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<LinkIOSDeviceIDResult>>(){}.getType() );

					LinkIOSDeviceIDResult result = (LinkIOSDeviceIDResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/LinkIOSDeviceID", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Links the Steam account associated with the provided Steam authentication ticket to the user's PlayFab account 
	public void LinkSteamAccount(LinkSteamAccountRequest request, final LinkSteamAccount resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<LinkSteamAccountResult> success = new JsonSuccess<LinkSteamAccountResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<LinkSteamAccountResult>>(){}.getType() );

					LinkSteamAccountResult result = (LinkSteamAccountResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/LinkSteamAccount", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Forces an email to be sent to the registered email address for the user's account, with a link allowing the user to change the password 
	public void SendAccountRecoveryEmail(SendAccountRecoveryEmailRequest request, final SendAccountRecoveryEmail resultCallback)
	{
		
		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<SendAccountRecoveryEmailResult> success = new JsonSuccess<SendAccountRecoveryEmailResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<SendAccountRecoveryEmailResult>>(){}.getType() );

					SendAccountRecoveryEmailResult result = (SendAccountRecoveryEmailResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/SendAccountRecoveryEmail", serializedJSON, null, null, callback);

	}
	// Unlinks the related Android device identifier from the user's PlayFab account 
	public void UnlinkAndroidDeviceID(UnlinkAndroidDeviceIDRequest request, final UnlinkAndroidDeviceID resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<UnlinkAndroidDeviceIDResult> success = new JsonSuccess<UnlinkAndroidDeviceIDResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<UnlinkAndroidDeviceIDResult>>(){}.getType() );

					UnlinkAndroidDeviceIDResult result = (UnlinkAndroidDeviceIDResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/UnlinkAndroidDeviceID", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Unlinks the related Facebook account from the user's PlayFab account 
	public void UnlinkFacebookAccount(UnlinkFacebookAccountRequest request, final UnlinkFacebookAccount resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<UnlinkFacebookAccountResult> success = new JsonSuccess<UnlinkFacebookAccountResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<UnlinkFacebookAccountResult>>(){}.getType() );

					UnlinkFacebookAccountResult result = (UnlinkFacebookAccountResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/UnlinkFacebookAccount", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Unlinks the related Game Center account from the user's PlayFab account 
	public void UnlinkGameCenterAccount(UnlinkGameCenterAccountRequest request, final UnlinkGameCenterAccount resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<UnlinkGameCenterAccountResult> success = new JsonSuccess<UnlinkGameCenterAccountResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<UnlinkGameCenterAccountResult>>(){}.getType() );

					UnlinkGameCenterAccountResult result = (UnlinkGameCenterAccountResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/UnlinkGameCenterAccount", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Unlinks the related iOS device identifier from the user's PlayFab account 
	public void UnlinkIOSDeviceID(UnlinkIOSDeviceIDRequest request, final UnlinkIOSDeviceID resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<UnlinkIOSDeviceIDResult> success = new JsonSuccess<UnlinkIOSDeviceIDResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<UnlinkIOSDeviceIDResult>>(){}.getType() );

					UnlinkIOSDeviceIDResult result = (UnlinkIOSDeviceIDResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/UnlinkIOSDeviceID", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Unlinks the related Steam account from the user's PlayFab account 
	public void UnlinkSteamAccount(UnlinkSteamAccountRequest request, final UnlinkSteamAccount resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<UnlinkSteamAccountResult> success = new JsonSuccess<UnlinkSteamAccountResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<UnlinkSteamAccountResult>>(){}.getType() );

					UnlinkSteamAccountResult result = (UnlinkSteamAccountResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/UnlinkSteamAccount", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Updates the local user's email address in PlayFab 
	public void UpdateEmailAddress(UpdateEmailAddressRequest request, final UpdateEmailAddress resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<UpdateEmailAddressResult> success = new JsonSuccess<UpdateEmailAddressResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<UpdateEmailAddressResult>>(){}.getType() );

					UpdateEmailAddressResult result = (UpdateEmailAddressResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/UpdateEmailAddress", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Updates the local user's password in PlayFab 
	public void UpdatePassword(UpdatePasswordRequest request, final UpdatePassword resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<UpdatePasswordResult> success = new JsonSuccess<UpdatePasswordResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<UpdatePasswordResult>>(){}.getType() );

					UpdatePasswordResult result = (UpdatePasswordResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/UpdatePassword", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Updates the title specific display name for the user 
	public void UpdateUserTitleDisplayName(UpdateUserTitleDisplayNameRequest request, final UpdateUserTitleDisplayName resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<UpdateUserTitleDisplayNameResult> success = new JsonSuccess<UpdateUserTitleDisplayNameResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<UpdateUserTitleDisplayNameResult>>(){}.getType() );

					UpdateUserTitleDisplayNameResult result = (UpdateUserTitleDisplayNameResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/UpdateUserTitleDisplayName", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Retrieves a list of ranked friends of the current player for the given statistic, starting from the indicated point in the leaderboard 
	public void GetFriendLeaderboard(GetFriendLeaderboardRequest request, final GetFriendLeaderboard resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<GetLeaderboardResult> success = new JsonSuccess<GetLeaderboardResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<GetLeaderboardResult>>(){}.getType() );

					GetLeaderboardResult result = (GetLeaderboardResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/GetFriendLeaderboard", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Retrieves a list of ranked users for the given statistic, starting from the indicated point in the leaderboard 
	public void GetLeaderboard(GetLeaderboardRequest request, final GetLeaderboard resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<GetLeaderboardResult> success = new JsonSuccess<GetLeaderboardResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<GetLeaderboardResult>>(){}.getType() );

					GetLeaderboardResult result = (GetLeaderboardResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/GetLeaderboard", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Retrieves a list of ranked users for the given statistic, centered on the currently signed-in user 
	public void GetLeaderboardAroundCurrentUser(GetLeaderboardAroundCurrentUserRequest request, final GetLeaderboardAroundCurrentUser resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<GetLeaderboardAroundCurrentUserResult> success = new JsonSuccess<GetLeaderboardAroundCurrentUserResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<GetLeaderboardAroundCurrentUserResult>>(){}.getType() );

					GetLeaderboardAroundCurrentUserResult result = (GetLeaderboardAroundCurrentUserResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/GetLeaderboardAroundCurrentUser", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Retrieves the title-specific custom data for the user which is readable and writable by the client 
	public void GetUserData(GetUserDataRequest request, final GetUserData resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<GetUserDataResult> success = new JsonSuccess<GetUserDataResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<GetUserDataResult>>(){}.getType() );

					GetUserDataResult result = (GetUserDataResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/GetUserData", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Retrieves the publisher-specific custom data for the user which is readable and writable by the client 
	public void GetUserPublisherData(GetUserDataRequest request, final GetUserPublisherData resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<GetUserDataResult> success = new JsonSuccess<GetUserDataResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<GetUserDataResult>>(){}.getType() );

					GetUserDataResult result = (GetUserDataResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/GetUserPublisherData", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Retrieves the publisher-specific custom data for the user which can only be read by the client 
	public void GetUserPublisherReadOnlyData(GetUserDataRequest request, final GetUserPublisherReadOnlyData resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<GetUserDataResult> success = new JsonSuccess<GetUserDataResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<GetUserDataResult>>(){}.getType() );

					GetUserDataResult result = (GetUserDataResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/GetUserPublisherReadOnlyData", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Retrieves the title-specific custom data for the user which can only be read by the client 
	public void GetUserReadOnlyData(GetUserDataRequest request, final GetUserReadOnlyData resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<GetUserDataResult> success = new JsonSuccess<GetUserDataResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<GetUserDataResult>>(){}.getType() );

					GetUserDataResult result = (GetUserDataResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/GetUserReadOnlyData", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Retrieves the details of all title-specific statistics for the user 
	public void GetUserStatistics(GetUserStatisticsRequest request, final GetUserStatistics resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<GetUserStatisticsResult> success = new JsonSuccess<GetUserStatisticsResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<GetUserStatisticsResult>>(){}.getType() );

					GetUserStatisticsResult result = (GetUserStatisticsResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/GetUserStatistics", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Creates and updates the title-specific custom data for the user which is readable and writable by the client 
	public void UpdateUserData(UpdateUserDataRequest request, final UpdateUserData resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<UpdateUserDataResult> success = new JsonSuccess<UpdateUserDataResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<UpdateUserDataResult>>(){}.getType() );

					UpdateUserDataResult result = (UpdateUserDataResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/UpdateUserData", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Creates and updates the publisher-specific custom data for the user which is readable and writable by the client 
	public void UpdateUserPublisherData(UpdateUserDataRequest request, final UpdateUserPublisherData resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<UpdateUserDataResult> success = new JsonSuccess<UpdateUserDataResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<UpdateUserDataResult>>(){}.getType() );

					UpdateUserDataResult result = (UpdateUserDataResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/UpdateUserPublisherData", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Updates the values of the specified title-specific statistics for the user 
	public void UpdateUserStatistics(UpdateUserStatisticsRequest request, final UpdateUserStatistics resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<UpdateUserStatisticsResult> success = new JsonSuccess<UpdateUserStatisticsResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<UpdateUserStatisticsResult>>(){}.getType() );

					UpdateUserStatisticsResult result = (UpdateUserStatisticsResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/UpdateUserStatistics", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Retrieves the specified version of the title's catalog of virtual goods, including all defined properties 
	public void GetCatalogItems(GetCatalogItemsRequest request, final GetCatalogItems resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<GetCatalogItemsResult> success = new JsonSuccess<GetCatalogItemsResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<GetCatalogItemsResult>>(){}.getType() );

					GetCatalogItemsResult result = (GetCatalogItemsResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/GetCatalogItems", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Retrieves the set of items defined for the specified store, including all prices defined 
	public void GetStoreItems(GetStoreItemsRequest request, final GetStoreItems resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<GetStoreItemsResult> success = new JsonSuccess<GetStoreItemsResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<GetStoreItemsResult>>(){}.getType() );

					GetStoreItemsResult result = (GetStoreItemsResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/GetStoreItems", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Retrieves the key-value store of custom title settings 
	public void GetTitleData(GetTitleDataRequest request, final GetTitleData resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<GetTitleDataResult> success = new JsonSuccess<GetTitleDataResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<GetTitleDataResult>>(){}.getType() );

					GetTitleDataResult result = (GetTitleDataResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/GetTitleData", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Retrieves the title news feed, as configured in the developer portal 
	public void GetTitleNews(GetTitleNewsRequest request, final GetTitleNews resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<GetTitleNewsResult> success = new JsonSuccess<GetTitleNewsResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<GetTitleNewsResult>>(){}.getType() );

					GetTitleNewsResult result = (GetTitleNewsResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/GetTitleNews", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Increments the user's balance of the specified virtual currency by the stated amount 
	public void AddUserVirtualCurrency(AddUserVirtualCurrencyRequest request, final AddUserVirtualCurrency resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<ModifyUserVirtualCurrencyResult> success = new JsonSuccess<ModifyUserVirtualCurrencyResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<ModifyUserVirtualCurrencyResult>>(){}.getType() );

					ModifyUserVirtualCurrencyResult result = (ModifyUserVirtualCurrencyResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/AddUserVirtualCurrency", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Confirms with the payment provider that the purchase was approved (if applicable) and adjusts inventory and virtual currency balances as appropriate 
	public void ConfirmPurchase(ConfirmPurchaseRequest request, final ConfirmPurchase resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<ConfirmPurchaseResult> success = new JsonSuccess<ConfirmPurchaseResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<ConfirmPurchaseResult>>(){}.getType() );

					ConfirmPurchaseResult result = (ConfirmPurchaseResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/ConfirmPurchase", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Consume uses of a consumable item. When all uses are consumed, it will be removed from the player's inventory. 
	public void ConsumeItem(ConsumeItemRequest request, final ConsumeItem resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<ConsumeItemResult> success = new JsonSuccess<ConsumeItemResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<ConsumeItemResult>>(){}.getType() );

					ConsumeItemResult result = (ConsumeItemResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/ConsumeItem", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Retrieves the user's current inventory of virtual goods 
	public void GetUserInventory(GetUserInventoryRequest request, final GetUserInventory resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<GetUserInventoryResult> success = new JsonSuccess<GetUserInventoryResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<GetUserInventoryResult>>(){}.getType() );

					GetUserInventoryResult result = (GetUserInventoryResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/GetUserInventory", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Selects a payment option for purchase order created via StartPurchase 
	public void PayForPurchase(PayForPurchaseRequest request, final PayForPurchase resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<PayForPurchaseResult> success = new JsonSuccess<PayForPurchaseResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<PayForPurchaseResult>>(){}.getType() );

					PayForPurchaseResult result = (PayForPurchaseResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/PayForPurchase", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Buys a single item with virtual currency. You must specify both the virtual currency to use to purchase, as well as what the client believes the price to be. This lets the server fail the purchase if the price has changed. 
	public void PurchaseItem(PurchaseItemRequest request, final PurchaseItem resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<PurchaseItemResult> success = new JsonSuccess<PurchaseItemResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<PurchaseItemResult>>(){}.getType() );

					PurchaseItemResult result = (PurchaseItemResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/PurchaseItem", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Adds the virtual goods associated with the coupon to the user's inventory 
	public void RedeemCoupon(RedeemCouponRequest request, final RedeemCoupon resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<RedeemCouponResult> success = new JsonSuccess<RedeemCouponResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<RedeemCouponResult>>(){}.getType() );

					RedeemCouponResult result = (RedeemCouponResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/RedeemCoupon", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Creates an order for a list of items from the title catalog 
	public void StartPurchase(StartPurchaseRequest request, final StartPurchase resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<StartPurchaseResult> success = new JsonSuccess<StartPurchaseResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<StartPurchaseResult>>(){}.getType() );

					StartPurchaseResult result = (StartPurchaseResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/StartPurchase", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Decrements the user's balance of the specified virtual currency by the stated amount 
	public void SubtractUserVirtualCurrency(SubtractUserVirtualCurrencyRequest request, final SubtractUserVirtualCurrency resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<ModifyUserVirtualCurrencyResult> success = new JsonSuccess<ModifyUserVirtualCurrencyResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<ModifyUserVirtualCurrencyResult>>(){}.getType() );

					ModifyUserVirtualCurrencyResult result = (ModifyUserVirtualCurrencyResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/SubtractUserVirtualCurrency", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Unlocks a container item in the user's inventory and consumes a key item of the type indicated by the container item 
	public void UnlockContainerItem(UnlockContainerItemRequest request, final UnlockContainerItem resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<UnlockContainerItemResult> success = new JsonSuccess<UnlockContainerItemResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<UnlockContainerItemResult>>(){}.getType() );

					UnlockContainerItemResult result = (UnlockContainerItemResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/UnlockContainerItem", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Adds the PlayFab user, based upon a match against a supplied unique identifier, to the friend list of the local user 
	public void AddFriend(AddFriendRequest request, final AddFriend resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<AddFriendResult> success = new JsonSuccess<AddFriendResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<AddFriendResult>>(){}.getType() );

					AddFriendResult result = (AddFriendResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/AddFriend", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Retrieves the current friend list for the local user, constrained to users who have PlayFab accounts 
	public void GetFriendsList(GetFriendsListRequest request, final GetFriendsList resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<GetFriendsListResult> success = new JsonSuccess<GetFriendsListResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<GetFriendsListResult>>(){}.getType() );

					GetFriendsListResult result = (GetFriendsListResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/GetFriendsList", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Removes a specified user from the friend list of the local user 
	public void RemoveFriend(RemoveFriendRequest request, final RemoveFriend resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<RemoveFriendResult> success = new JsonSuccess<RemoveFriendResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<RemoveFriendResult>>(){}.getType() );

					RemoveFriendResult result = (RemoveFriendResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/RemoveFriend", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Updates the tag list for a specified user in the friend list of the local user 
	public void SetFriendTags(SetFriendTagsRequest request, final SetFriendTags resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<SetFriendTagsResult> success = new JsonSuccess<SetFriendTagsResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<SetFriendTagsResult>>(){}.getType() );

					SetFriendTagsResult result = (SetFriendTagsResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/SetFriendTags", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Registers the iOS device to receive push notifications 
	public void RegisterForIOSPushNotification(RegisterForIOSPushNotificationRequest request, final RegisterForIOSPushNotification resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<RegisterForIOSPushNotificationResult> success = new JsonSuccess<RegisterForIOSPushNotificationResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<RegisterForIOSPushNotificationResult>>(){}.getType() );

					RegisterForIOSPushNotificationResult result = (RegisterForIOSPushNotificationResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/RegisterForIOSPushNotification", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Validates with the Apple store that the receipt for an iOS in-app purchase is valid and that it matches the purchased catalog item 
	public void ValidateIOSReceipt(ValidateIOSReceiptRequest request, final ValidateIOSReceipt resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<ValidateIOSReceiptResult> success = new JsonSuccess<ValidateIOSReceiptResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<ValidateIOSReceiptResult>>(){}.getType() );

					ValidateIOSReceiptResult result = (ValidateIOSReceiptResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/ValidateIOSReceipt", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Get details about all current running game servers matching the given parameters. 
	public void GetCurrentGames(CurrentGamesRequest request, final GetCurrentGames resultCallback)
	{
		
		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<CurrentGamesResult> success = new JsonSuccess<CurrentGamesResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<CurrentGamesResult>>(){}.getType() );

					CurrentGamesResult result = (CurrentGamesResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/GetCurrentGames", serializedJSON, null, null, callback);

	}
	//  Get details about the regions hosting game servers matching the given parameters. 
	public void GetGameServerRegions(GameServerRegionsRequest request, final GetGameServerRegions resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<GameServerRegionsResult> success = new JsonSuccess<GameServerRegionsResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<GameServerRegionsResult>>(){}.getType() );

					GameServerRegionsResult result = (GameServerRegionsResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/GetGameServerRegions", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Attempts to locate a game session matching the given parameters. Note that parameters specified in the search are required (they are not weighting factors). If a slot is found in a server instance matching the parameters, the slot will be assigned to that player, removing it from the availabe set. In that case, the information on the game session will be returned, otherwise the Status returned will be GameNotFound. Note that EnableQueue is deprecated at this time. 
	public void Matchmake(MatchmakeRequest request, final Matchmake resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<MatchmakeResult> success = new JsonSuccess<MatchmakeResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<MatchmakeResult>>(){}.getType() );

					MatchmakeResult result = (MatchmakeResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/Matchmake", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Start a new game server with a given configuration, add the current player and return the connection information. 
	public void StartGame(StartGameRequest request, final StartGame resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<StartGameResult> success = new JsonSuccess<StartGameResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<StartGameResult>>(){}.getType() );

					StartGameResult result = (StartGameResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/StartGame", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Registers the Android device to receive push notifications 
	public void AndroidDevicePushNotificationRegistration(AndroidDevicePushNotificationRegistrationRequest request, final AndroidDevicePushNotificationRegistration resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<AndroidDevicePushNotificationRegistrationResult> success = new JsonSuccess<AndroidDevicePushNotificationRegistrationResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<AndroidDevicePushNotificationRegistrationResult>>(){}.getType() );

					AndroidDevicePushNotificationRegistrationResult result = (AndroidDevicePushNotificationRegistrationResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/AndroidDevicePushNotificationRegistration", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Validates a Google Play purchase and gives the corresponding item to the player. 
	public void ValidateGooglePlayPurchase(ValidateGooglePlayPurchaseRequest request, final ValidateGooglePlayPurchase resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<ValidateGooglePlayPurchaseResult> success = new JsonSuccess<ValidateGooglePlayPurchaseResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<ValidateGooglePlayPurchaseResult>>(){}.getType() );

					ValidateGooglePlayPurchaseResult result = (ValidateGooglePlayPurchaseResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/ValidateGooglePlayPurchase", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Logs a custom analytics event 
	public void LogEvent(LogEventRequest request, final LogEvent resultCallback)
	{
		
		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<LogEventResult> success = new JsonSuccess<LogEventResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<LogEventResult>>(){}.getType() );

					LogEventResult result = (LogEventResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/LogEvent", serializedJSON, null, null, callback);

	}
	// Adds users to the set of those able to update both the shared data, as well as the set of users in the group. Only users in the group can add new members. 
	public void AddSharedGroupMembers(AddSharedGroupMembersRequest request, final AddSharedGroupMembers resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<AddSharedGroupMembersResult> success = new JsonSuccess<AddSharedGroupMembersResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<AddSharedGroupMembersResult>>(){}.getType() );

					AddSharedGroupMembersResult result = (AddSharedGroupMembersResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/AddSharedGroupMembers", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Requests the creation of a shared group object, containing key/value pairs which may be updated by all members of the group. Upon creation, the current user will be the only member of the group. 
	public void CreateSharedGroup(CreateSharedGroupRequest request, final CreateSharedGroup resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<CreateSharedGroupResult> success = new JsonSuccess<CreateSharedGroupResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<CreateSharedGroupResult>>(){}.getType() );

					CreateSharedGroupResult result = (CreateSharedGroupResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/CreateSharedGroup", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Retrieves the key-value store of custom publisher settings 
	public void GetPublisherData(GetPublisherDataRequest request, final GetPublisherData resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<GetPublisherDataResult> success = new JsonSuccess<GetPublisherDataResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<GetPublisherDataResult>>(){}.getType() );

					GetPublisherDataResult result = (GetPublisherDataResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/GetPublisherData", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Retrieves data stored in a shared group object, as well as the list of members in the group. Non-members of the group may use this to retrieve group data, including membership, but they will not receive data for keys marked as private. 
	public void GetSharedGroupData(GetSharedGroupDataRequest request, final GetSharedGroupData resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<GetSharedGroupDataResult> success = new JsonSuccess<GetSharedGroupDataResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<GetSharedGroupDataResult>>(){}.getType() );

					GetSharedGroupDataResult result = (GetSharedGroupDataResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/GetSharedGroupData", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Removes users from the set of those able to update the shared data and the set of users in the group. Only users in the group can remove members. If as a result of the call, zero users remain with access, the group and its associated data will be deleted. 
	public void RemoveSharedGroupMembers(RemoveSharedGroupMembersRequest request, final RemoveSharedGroupMembers resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<RemoveSharedGroupMembersResult> success = new JsonSuccess<RemoveSharedGroupMembersResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<RemoveSharedGroupMembersResult>>(){}.getType() );

					RemoveSharedGroupMembersResult result = (RemoveSharedGroupMembersResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/RemoveSharedGroupMembers", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Adds, updates, and removes data keys for a shared group object. If the permission is set to Public, all fields updated or added in this call will be readable by users not in the group. By default, data permissions are set to Private. Regardless of the permission setting, only members of the group can update the data. 
	public void UpdateSharedGroupData(UpdateSharedGroupDataRequest request, final UpdateSharedGroupData resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<UpdateSharedGroupDataResult> success = new JsonSuccess<UpdateSharedGroupDataResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<UpdateSharedGroupDataResult>>(){}.getType() );

					UpdateSharedGroupDataResult result = (UpdateSharedGroupDataResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/UpdateSharedGroupData", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Uses the supplied OAuth code to refresh the internally cached player PSN auth token 
	public void RefreshPSNAuthToken(RefreshPSNAuthTokenRequest request, final RefreshPSNAuthToken resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<EmptyResult> success = new JsonSuccess<EmptyResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<EmptyResult>>(){}.getType() );

					EmptyResult result = (EmptyResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/RefreshPSNAuthToken", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Gets the title-specific url for Cloud Script servers. Must be called before making any calls to RunCloudScript. 
	public void GetCloudScriptUrl(GetCloudScriptUrlRequest request, final GetCloudScriptUrl resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<GetCloudScriptUrlResult> success = new JsonSuccess<GetCloudScriptUrlResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<GetCloudScriptUrlResult>>(){}.getType() );

					GetCloudScriptUrlResult result = (GetCloudScriptUrlResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/GetCloudScriptUrl", serializedJSON, "X-Authorization", AuthKey, callback);

	}
	// Triggers a particular server action 
	public void RunCloudScript(RunCloudScriptRequest request, final RunCloudScript resultCallback)
	{
		if (AuthKey == null)
		{
			if ( resultCallback != null)			{
				PlayFabError error = new PlayFabError();
				error.PlayFabError = PlayFabError.NotAuthenticated;
				error.ErrorMessage = "Must be logged in to call this method";
				resultCallback.OnError( error );
			}
			return;
		}

		final Gson gson = new Gson();
		String serializedJSON = gson.toJson(request);

		HTTP.HTTPCallback callback = new HTTP.HTTPCallback()
		{
			public void onResult(Object resultObject )
			{
				if ( resultObject instanceof PlayFabError )
				{			
					if( resultObject != null && resultCallback != null)
					{
						resultCallback.OnError( (PlayFabError) resultObject );
					}
					return;
				}

				if( resultObject != null )
				{
					String resultRawJson = (String) resultObject;
					
					JsonSuccess<RunCloudScriptResult> success = new JsonSuccess<RunCloudScriptResult>();

					success = new Gson().fromJson(resultRawJson, new TypeToken<JsonSuccess<RunCloudScriptResult>>(){}.getType() );

					RunCloudScriptResult result = (RunCloudScriptResult) success.data;

					
					if( resultCallback != null )
					{
						resultCallback.OnResult( result );
					}
				}
			}
		};
		
		HTTP http = new HTTP();
		http.Post(Url+"/Client/RunCloudScript", serializedJSON, "X-Authorization", AuthKey, callback);

	}
}
