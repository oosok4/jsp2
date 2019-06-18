package kr.or.ddit.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookieUtil {
	
	

	private static final Logger logger = LoggerFactory
			.getLogger(CookieUtil.class);
	
	public static String cookieString; // 분석할 쿠키 문자열

	/**
	 * Method : setCookieString 작성자 : PC17 변경이력 :
	 * 
	 * @param cookieString
	 *            Method 설명 : 분석할 쿠키 문자열을 받는다.
	 */
	public static void setCookieString(String cookieString) {
		CookieUtil.cookieString = cookieString;

	}

	/**
	 * Method : getCookie 작성자 : PC17 변경이력 :
	 * 
	 * @param cookie
	 * @return Method 설명 : 쿠키 문자열에서 특정 쿠키 값을 가져온다.
	 */
	//파싱?! 
	public static String getCookie(String cookie) {
		// "userId=brown; rememberme=true; test=testValue"
		// cookie = "userId"
		
		String[] cookieArray = CookieUtil.cookieString.split("; ");
		String cookieValue = "";
		
		for (String str : cookieArray) {
			//cookieName = cookieValue
			//cookieArray[0] = "userId=brown"
			//cookieArray[1] = "rememberme=true"
			//cookieArray[2] = "test=testValue"
			logger.debug("str : " + str);
			
			//userId = brown
			//userI ==> "", "brown"
			
			//"userId=brown" startWidt("userI=")
			if(str.startsWith(cookie+"=")){
				String[] cookieStr = str.split("=");
				cookieValue = cookieStr[1];
				break;
				
//				for (String str2 : cookieStr) {
//					logger.debug("cookieStr : " + str2);
//					//cookieStr[0] = "userId"
//					//cookieStr[1] = "true"
//				}
				
			}
		}
		return cookieValue;
		
	}

}
