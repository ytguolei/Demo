package com;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String[] msg = "2,NGAP00001752,EP,DD32,SPSD,0,TR2,GA,,0,2016-12-25 10:00:00,2016-12-25 09:30:10".split(",");
//		System.out.print(msg.length);
		
//		long youNumber = 999999999999999999L;      

	    // 0 代表前面补充0      

	    // 4 代表长度为4      

	    // d 代表参数为正数型      

//	    String str = String.format("%06d", youNumber);      

//	    System.out.println(str); // 0001
		Calendar calendat = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-ddThh:mm:ss");
		String dateStr = sdf.format(calendat.getTime());
	    System.out.println(dateStr);
	}

}
