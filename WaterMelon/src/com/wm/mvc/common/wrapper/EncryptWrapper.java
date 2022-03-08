//package com.wm.mvc.common.wrapper;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletRequestWrapper;
//
//import com.wm.mvc.common.util.EncryptUtil;
//
//// SuperClass : javax.servlet.http.HttpServletRequestWrapper
//public class EncryptWrapper extends HttpServletRequestWrapper {
//
//	public EncryptWrapper(HttpServletRequest request) {
//		super(request);
//	}
//
//	// Override -> ServletRequestWrapper 항목에 있음
//	// 재정의 하고싶은 메서드를 작성한다.
//	@Override
//	public String getParameter(String name) {
//		// 클라이언트가 전달하는 값중에 비밀번호 name값만 암호화를 처리하고 나머지는 정상적으로 리턴하도록 처리
//		String value = "";
//		
//		if (name.equals("userPwd")) {
//			// 암호화 처리 후 반환
//			value = EncryptUtil.oneWayEnc(super.getParameter(name), "SHA-256");
//		} else {
//			// 정상적으로 반환
//			value = super.getParameter(name);
//		}
//		
//		return value;
//	}
//	
//	
//}
