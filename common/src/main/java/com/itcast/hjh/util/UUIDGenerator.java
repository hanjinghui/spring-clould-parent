package com.itcast.hjh.util;

import java.util.UUID;

public class UUIDGenerator {
	public static String getUUID()
	  {
	    return UUID.randomUUID().toString().replace("-", "");
	  }
}
