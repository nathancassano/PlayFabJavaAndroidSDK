package com.playfab;

public class Version
{
	public static String ApiRevision = "1.1.0";
	public static String SdkRevision = "1.0.4";

	public static String getVersionString()
	{
		return "JavaSDK-" + SdkRevision + "-" + ApiRevision;
	}
}
