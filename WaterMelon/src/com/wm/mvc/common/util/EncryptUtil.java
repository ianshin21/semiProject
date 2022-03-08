package com.wm.mvc.common.util;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class EncryptUtil {
	/*
	암호화의 방향성
	  1) 단방향 : 암호화된 평문은 다시 복화화 할 수 없는 암호화 방식이다. (SHA(Secure Hash Algorithm2), MD5(Message-Digest algorithm 5))
	  2) 양방향 : 암호화된 평문을 다시 복호화 할 수 있는 암호화 방식이다. 
	    2-1) 대칭키(비공개키) 방식 : 암/복화에 사용하는 키가 동일하다. (AES(Advanced Encryption Standard), DES(Data Encryption Standard))
	      - 장점 : 속도가 빠르다.
	      - 단점 : 키를 전달하는 과정에서 노출될 가능성이 높다. (키가 털리면 끝..)
	    2-2) 비대칭키(공개키) 방식 : 암/복화에 사용하는 키가 서로 다르다. (RSA)
	      - 장점 : 암/복화하 키가 다르기 때문에 전달 과정에서 노출되어도 복호화 할 수 없다.
	      - 단점 : 속도가 느리다.
	SHA(Secure Hash Algorithm2)
	  1) SHA-256 
	    - SHA-256은 임의의 길이 메시지를 256비트(32바이트)의 축약된 메시지로 만들어내는 해시 알고리즘이다.
	    - SHA-256은 현재가장 많은 분야에서 채택하여 사용되고 있는 암호 방식이다. 출력 속도가 빠르다는 장점을 갖고 있다.
	  2) SHA-512
	  	- SHA-256은 임의의 길이 메시지를 512비트(64바이트)의 축약된 메시지로 만들어내는 해시 알고리즘이다.
	  3)암호화 해시 함수의 안전성을 강화하기 위해 추가로 스트레칭, 솔트 2가지 방법을 사용한다. (이건 궁금하면 찾아보세용^^)
	 */

// 단방향 암호화 (MD2, MD5, SHA, SHA-1, SHA-256, SHA-384, SHA-512을 지원한다.)
	public static String oneWayEnc(String message, String algorithm) {
		String encMessage = "";

		try {
			// 메시지 다이제스트란, 입력 값의 길이에 상관없이 수학적인 연산을 항상 동일한 길이의 해시 값을 만들어 낸다.
			MessageDigest md = MessageDigest.getInstance(algorithm);
			byte[] bytes = message.getBytes(Charset.forName("UTF-8"));

			// 평문을 byte[] 변환하여 메시지 다이제스트로 전달한다.
			md.update(bytes);

			// 암호화 형식에 맞게 변경하여 byte[]로 돌려받은 후 Base64를 사용하여 byte 형식의 데이터를 문자열로 Encoding 한다.
			//  - Base64란 Binary Data를 Text로 바꾸는 Encoding(binary-to-text encoding schemes)의 하나로써 
			//    Binary Data를 Character set에 영향을 받지 않는 공통 ASCII 영역의 문자로만 이루어진 문자열로 바꾸는 Encoding이다.
			//  - Binary Data를 6 bit 씩 자른 뒤 6 bit에 해당하는 문자를 아래 Base64 색인표에서 찾아 치환한다. 
			encMessage = Base64.getEncoder().encodeToString(md.digest());

			System.out.println(
					"Original Message : " + message + " >>>>> " + algorithm + " Encoding Message : " + encMessage);

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return encMessage;
	}
}
