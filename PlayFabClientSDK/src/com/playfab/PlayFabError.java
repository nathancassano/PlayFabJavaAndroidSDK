package com.playfab;

import java.util.List;
import java.util.HashMap;

public class PlayFabError
{
	public static final int Unknown = 1;
	public static final int ConnectionError = 2;
	public static final int JsonParseError = 3;
	public static final int Success = 0;
	public static final int InvalidParams = 1000;
	public static final int AccountNotFound = 1001;
	public static final int AccountBanned = 1002;
	public static final int InvalidUsernameOrPassword = 1003;
	public static final int InvalidTitleId = 1004;
	public static final int InvalidEmailAddress = 1005;
	public static final int EmailAddressNotAvailable = 1006;
	public static final int InvalidUsername = 1007;
	public static final int InvalidPassword = 1008;
	public static final int UsernameNotAvailable = 1009;
	public static final int InvalidSteamTicket = 1010;
	public static final int AccountAlreadyLinked = 1011;
	public static final int LinkedAccountAlreadyClaimed = 1012;
	public static final int InvalidFacebookToken = 1013;
	public static final int AccountNotLinked = 1014;
	public static final int FailedByPaymentProvider = 1015;
	public static final int CouponCodeNotFound = 1016;
	public static final int InvalidContainerItem = 1017;
	public static final int ContainerNotOwned = 1018;
	public static final int KeyNotOwned = 1019;
	public static final int InvalidItemIdInTable = 1020;
	public static final int InvalidReceipt = 1021;
	public static final int ReceiptAlreadyUsed = 1022;
	public static final int ReceiptCancelled = 1023;
	public static final int GameNotFound = 1024;
	public static final int GameModeNotFound = 1025;
	public static final int InvalidGoogleToken = 1026;
	public static final int UserIsNotPartOfDeveloper = 1027;
	public static final int InvalidTitleForDeveloper = 1028;
	public static final int TitleNameConflicts = 1029;
	public static final int UserisNotValid = 1030;
	public static final int ValueAlreadyExists = 1031;
	public static final int BuildNotFound = 1032;
	public static final int PlayerNotInGame = 1033;
	public static final int InvalidTicket = 1034;
	public static final int InvalidDeveloper = 1035;
	public static final int InvalidOrderInfo = 1036;
	public static final int RegistrationIncomplete = 1037;
	public static final int InvalidPlatform = 1038;
	public static final int UnknownError = 1039;
	public static final int SteamApplicationNotOwned = 1040;
	public static final int WrongSteamAccount = 1041;
	public static final int TitleNotActivated = 1042;
	public static final int RegistrationSessionNotFound = 1043;
	public static final int NoSuchMod = 1044;
	public static final int FileNotFound = 1045;
	public static final int DuplicateEmail = 1046;
	public static final int ItemNotFound = 1047;
	public static final int ItemNotOwned = 1048;
	public static final int ItemNotRecycleable = 1049;
	public static final int ItemNotAffordable = 1050;
	public static final int InvalidVirtualCurrency = 1051;
	public static final int WrongVirtualCurrency = 1052;
	public static final int WrongPrice = 1053;
	public static final int NonPositiveValue = 1054;
	public static final int InvalidRegion = 1055;
	public static final int RegionAtCapacity = 1056;
	public static final int ServerFailedToStart = 1057;
	public static final int NameNotAvailable = 1058;
	public static final int InsufficientFunds = 1059;
	public static final int InvalidDeviceID = 1060;
	public static final int InvalidPushNotificationToken = 1061;
	public static final int NoRemainingUses = 1062;
	public static final int InvalidPaymentProvider = 1063;
	public static final int PurchaseInitializationFailure = 1064;
	public static final int DuplicateUsername = 1065;
	public static final int InvalidBuyerInfo = 1066;
	public static final int NoGameModeParamsSet = 1067;
	public static final int BodyTooLarge = 1068;
	public static final int ReservedWordInBody = 1069;
	public static final int InvalidTypeInBody = 1070;
	public static final int InvalidRequest = 1071;
	public static final int ReservedEventName = 1072;
	public static final int InvalidUserStatistics = 1073;
	public static final int NotAuthenticated = 1074;
	public static final int StreamAlreadyExists = 1075;
	public static final int ErrorCreatingStream = 1076;
	public static final int StreamNotFound = 1077;
	public static final int InvalidAccount = 1078;
	public static final int PurchaseDoesNotExist = 1080;
	public static final int InvalidPurchaseTransactionStatus = 1081;
	public static final int APINotEnabledForGameClientAccess = 1082;
	public static final int NoPushNotificationARNForTitle = 1083;
	public static final int BuildAlreadyExists = 1084;
	public static final int BuildPackageDoesNotExist = 1085;
	public static final int BuildIsActive = 1086;
	public static final int CustomAnalyticsEventsNotEnabledForTitle = 1087;
	public static final int InvalidSharedGroupId = 1088;
	public static final int NotAuthorized = 1089;
	public static final int MissingTitleGoogleProperties = 1090;
	public static final int InvalidItemProperties = 1091;
	public static final int InvalidPSNAuthCode = 1092;
	public static final int InvalidItemId = 1093;
	public static final int PushNotEnabledForAccount = 1094;
	public static final int PushServiceError = 1095;
	public static final int ReceiptDoesNotContainInAppItems = 1096;
	public static final int ReceiptContainsMultipleInAppItems = 1097;
	public static final int InvalidBundleID = 1098;
	public static final int JavascriptException = 1099;
	public static final int InvalidSessionTicket = 1100;
	public static final int UnableToConnectToDatabase = 1101;
	public static final int InternalServerError = 1110;
	public static final int InvalidReportDate = 1111;
	public static final int ReportNotAvailable = 1112;
	public static final int DatabaseThroughputExceeded = 1113;
	public static final int InvalidLobbyId = 1114;
	public static final int InvalidGameTicket = 1115;
	public static final int ExpiredGameTicket = 1116;
	public static final int GameTicketDoesNotMatchLobby = 1117;
	public static final int LinkedDeviceAlreadyClaimed = 1118;
	public static final int DeviceAlreadyLinked = 1119;
	public static final int DeviceNotLinked = 1120;
	public static final int PartialFailure = 1121;
	public static final int PublisherNotSet = 1122;
	
	public int HttpCode;
	public String HttpStatus;
	public int PlayFabError;
	public String ErrorMessage;
	public HashMap<String, String[] > ErrorDetails;
}
