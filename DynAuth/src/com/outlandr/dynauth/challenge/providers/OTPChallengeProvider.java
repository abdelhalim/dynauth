package com.outlandr.dynauth.challenge.providers;

import com.outlandr.dynauth.challenge.ChallengeProviderBase;
import com.yubico.client.v1.YubicoClient;

public class OTPChallengeProvider extends ChallengeProviderBase {


	public OTPChallengeProvider() {
		ID = "com.outlandr.dynauth.otp";
	}
	
	@Override
	public boolean validateResponse(String response) {
		int authId = Integer.parseInt("28");
		String otp = response;
		
		YubicoClient yc = new YubicoClient(authId);
		if (yc.verify(otp)) {
			// verified otp
			return true;
		} else {
			// Failed to verify otp
			return false;
		}
	}

	@Override
	public String getChallenge() {
		return "Enter your OTP:";
	}

}
