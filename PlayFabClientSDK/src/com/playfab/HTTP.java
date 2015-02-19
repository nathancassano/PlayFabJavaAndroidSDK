package com.playfab;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.os.AsyncTask;

public class HTTP extends AsyncTask<String, Object, Object>
{
	public interface HTTPCallback
	{
		public void onResult(Object result);
	}

	private HTTPCallback callback;

	public class PlayFabJsonSuccess<ResultT>
	{
		public int code;
		public String status;
		public ResultT data;
	}

	public class PlayFabJsonError
	{
		public int code;
		public String status;
		public String error;
		public int errorCode;
		public String errorMessage;
		public HashMap<String, String[]> errorDetails = null;
	}

	public void Post(String url, String data, String authType, String authKey, HTTPCallback callback)
	{
		this.callback = callback;

		execute(url, data, authType, authKey);
	}

	protected Object doInBackground(String... params)
	{
		String url = params[0];
		String data = params[1];
		String authType = params[2];
		String authKey = params[3];

		HttpPost method;
		try
		{
			method = new HttpPost( new URI(url) );
		} catch (URISyntaxException e)
		{
			PlayFabError error = new PlayFabError();
			error.PlayFabError = PlayFabError.ConnectionError;
			error.ErrorMessage = e.getMessage();
			return error;
		}

		DefaultHttpClient client = new DefaultHttpClient();
		client.getParams().setParameter(HttpConnectionParams.CONNECTION_TIMEOUT, Integer.valueOf(10000) );
		client.getParams().setParameter(HttpConnectionParams.SO_TIMEOUT, Integer.valueOf(10000) );

		StringEntity entity = null;
		try
		{
			entity = new StringEntity(data);
			entity.setContentType("application/json");
		} catch (UnsupportedEncodingException e)
		{
			PlayFabError error = new PlayFabError();
			error.PlayFabError = PlayFabError.ConnectionError;
			error.ErrorMessage = e.getMessage();
			return error;
		}

		method.setEntity(entity);

		method.addHeader("Content-Type", "application/json");
		if ( authType != null )
			method.addHeader(authType, authKey);
		method.addHeader("X-ReportErrorAsSuccess", "true");
		method.addHeader("X-PlayFabSDK", Version.getVersionString ());

		HttpResponse res = null;
		try
		{
			res = client.execute(method);
		} catch (Exception e)
		{
			PlayFabError error = new PlayFabError();
			error.PlayFabError = PlayFabError.ConnectionError;
			error.ErrorMessage = e.getMessage();
			return error;
		} 

		StatusLine status = res.getStatusLine();

		int statusCode = status.getStatusCode();
		String httpResponseString = null;

		try
		{
			httpResponseString = EntityUtils.toString( res.getEntity() );
		} catch (Exception e)
		{
			PlayFabError error = new PlayFabError();
			error.PlayFabError = PlayFabError.ConnectionError;
			error.ErrorMessage = e.getMessage();
			return error;
		} 
		
		if ( statusCode != HttpStatus.SC_OK )
		{
			PlayFabError error = new PlayFabError();
			
			if (  ( httpResponseString == null || ( httpResponseString != null && httpResponseString.length() == 0 ) ) || statusCode == HttpStatus.SC_NOT_FOUND )
			{
				error.HttpCode = statusCode;
				error.HttpStatus = status.toString();
				return error;
			}
			
			JsonError errorResult = null;
			
			try
			{
				errorResult = new Gson().fromJson(httpResponseString, new TypeToken<JsonError>(){}.getType() );
			}
			catch (Exception e )
			{
				error.HttpCode = statusCode;
				error.HttpStatus = status.toString();
				error.PlayFabError = PlayFabError.JsonParseError;
				error.ErrorMessage = e.getMessage();
				return error;
			}
			
			error.HttpCode = errorResult.code;
			error.HttpStatus = errorResult.status;
			error.PlayFabError = errorResult.errorCode;
			error.ErrorMessage = errorResult.errorMessage;
			error.ErrorDetails = errorResult.errorDetails;
			
			return error;
		}
		
		if ( httpResponseString == null || ( httpResponseString != null && httpResponseString.length() == 0 ) )
		{
			PlayFabError error = new PlayFabError();
			error.PlayFabError = PlayFabError.Unknown;
			error.ErrorMessage = "Internal server error";
			return error;
		}

		// Success
		return httpResponseString;

	}
	
	protected void onPostExecute(Object result) 
	{
		this.callback.onResult( result );
	}
}
