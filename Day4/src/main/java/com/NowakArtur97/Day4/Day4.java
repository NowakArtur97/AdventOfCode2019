package com.NowakArtur97.Day4;

import com.NowakArtur97.Day4.service.api.PasswordDecoder;
import com.NowakArtur97.Day4.service.impl.PasswordDecoderImpl;

public class Day4 
{
	private static final PasswordDecoder passwordDecoder = new PasswordDecoderImpl();
	
    public static void main( String[] args )
    {
    	System.out.println(passwordDecoder.countPossibleAnswers(134792, 675810));
    }
}
