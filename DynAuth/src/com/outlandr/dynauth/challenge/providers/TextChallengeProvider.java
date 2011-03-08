package com.outlandr.dynauth.challenge.providers;

import com.outlandr.dynauth.challenge.ChallengeProviderBase;
import com.outlandr.dynauth.user.Info;


public abstract class TextChallengeProvider extends ChallengeProviderBase {

	public abstract String getChallenge(Info info);
}
