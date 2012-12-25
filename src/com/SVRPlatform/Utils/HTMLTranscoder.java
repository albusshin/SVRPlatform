package com.SVRPlatform.Utils;

public class HTMLTranscoder {
	public static String transcode(String source) {
		String transcoded;
		transcoded = source.replace("<", "&lt;");
		transcoded = transcoded.replace(">", "&gt;");
		
		return transcoded;
	}
}
