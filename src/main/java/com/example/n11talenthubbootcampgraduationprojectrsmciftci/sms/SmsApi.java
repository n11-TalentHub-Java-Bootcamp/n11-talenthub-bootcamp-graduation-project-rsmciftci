package com.example.n11talenthubbootcampgraduationprojectrsmciftci.sms;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.N11TalenthubBootcampGraduationProjectRsmciftciApplication;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.config.SmsApiConfig;
import com.example.n11talenthubbootcampgraduationprojectrsmciftci.datasource.SmsApiDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Component
public class SmsApi {



	public static String excutePost( String message, String phoneNumber){


		ApplicationContext ctx = new AnnotationConfigApplicationContext(SmsApiConfig.class);
		SmsApiDataSource smsApiDataSource = ctx.getBean(SmsApiDataSource.class);
		String username = smsApiDataSource.getUsername();
		String password = smsApiDataSource.getPassword();

		String targetURL = "http://api.iletimerkezi.com/v1/send-sms";
		String xml = "<request>";
		xml += "<authentication>";
		xml += "<username>";
		xml += username;
		xml +=	"</username>";
		xml += "<password>";
		xml += password;
		xml += "</password>";
		xml += "</authentication>";
		xml += "<order>";
		xml += "<sender>RasimCiftci</sender>";
		xml += "<sendDateTime></sendDateTime>";
		xml += "<message>";
		xml += "        <text><![CDATA[";
		xml += message;
		xml += "]]></text>";
		xml += "<receipents>";
		xml += "<number>";
		xml += phoneNumber;
		xml += "</number>";
		xml += "</receipents>";
		xml += "</message>";
		xml += "</order>";
		xml += "</request>";
		
		String urlParameters = null;
		try {
			urlParameters = "data=" + URLEncoder.encode(xml,"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	    URL url;
	
	    HttpURLConnection connection = null;  
	
	    try {
	
	      //Create connection
	      url = new URL(targetURL);
	
	      connection = (HttpURLConnection)url.openConnection();
	      connection.setRequestMethod("POST");
	      connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
	      connection.setRequestProperty("Content-Length", "" + Integer.toString(urlParameters.getBytes().length));
	      connection.setRequestProperty("Content-Language", "UTF-8");  
	      connection.setUseCaches (false);
	      connection.setDoInput(true);
	      connection.setDoOutput(true);
	
	      //Send request
	      DataOutputStream wr = new DataOutputStream (connection.getOutputStream ());
	      wr.writeBytes (urlParameters);
	      wr.flush ();
	      wr.close ();
	      
	      //System.out.println(connection.getResponseMessage());
	      //Get Response
	      InputStream is = connection.getInputStream();
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is,"UTF-8"));
	      StringBuffer response = new StringBuffer(); 
			
	      while((rd.readLine()) != null) {
	        response.append(rd.readLine());
	      }
	
	      rd.close();

	      return response.toString();
	      
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	return null;
	    } finally {
	    	if(connection != null) {
	    		connection.disconnect(); 
	    	}
	    }
	
	  }
	
}
