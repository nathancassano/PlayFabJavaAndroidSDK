=== PlayFabJavaAndroidSDK ===

Unoffical PlayFab SDK for Android Java.
PlayFab® is a registered trademark of PlayFab, Inc.

=== Project configuration ===

1. Include the playfab-1.0.4.jar in your project along with the gson.jar dependency.

2. Add a playfab.xml file in your project resources. Change the playfab_titleid to your PlayFab TitleId.
res/values/playfab.xml

```xml
<resources>
    <string name="playfab_titleid">test</string>
    <bool name="playfab_use_development_environment">True</bool>
    <string name="playfab_development_environment_url">.playfabsandbox.com</string>
    <string name="playfab_production_environment_url">.playfabapi.com</string>
</resources>
```

=== Example Code ===

Here is a quick API usage code sample. 

```java
import com.playfab.*;
...

ClientAPI playfab = new ClientAPI(MyActivity.this);

LoginWithAndroidDeviceIDRequest request = new LoginWithAndroidDeviceIDRequest();
request.AndroidDevice = Build.MANUFACTURER + " " + Build.MODEL;
request.AndroidDeviceId = Secure.getString(getContentResolver(), Secure.ANDROID_ID);
request.OS = Build.VERSION.RELEASE;
request.CreateAccount = true;

LoginWithAndroidDeviceID resultCallback = new LoginWithAndroidDeviceID()
{
    @Override
    public void OnResult(LoginResult result)
    {
        android.util.Log.v("PLAYFAB", result.toString());
    }

    @Override
    public void OnError(PlayFabError error)
    {
        android.util.Log.e("PLAYFAB", error.ErrorMessage );
    }
};

playfab.LoginWithAndroidDeviceID(request, resultCallback);
```
