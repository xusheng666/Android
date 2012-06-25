package xs.ww.ruisi.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class SingtelUtil {
	
	public static HashMap<String, String> map = new HashMap<String, String>();
	
	public void initialMap(){
		map.put("Incoming", "1");
		map.put("Outcoming", "2");
		map.put("Missed", "3");
	}
	
	/**
	 * this method to calculate the total time of the outcoming call
	 * for singtel charging used.
	 * @return
	 */
	public static int totalCallTime(ArrayList<Integer> durationList){
		int totalChargeMin = 0;
		
		for (int i = 0; i < durationList.size(); i++) {
			Integer duration = durationList.get(i);
			
			BigDecimal durationBD = new BigDecimal(duration);
			BigDecimal oneMin = new BigDecimal(60);
			if(duration<60){
				totalChargeMin = totalChargeMin + 1;
			}else{
				int mins = durationBD.divide(oneMin, BigDecimal.ROUND_UP).intValue();
				totalChargeMin = totalChargeMin + mins;
			}
		}
		
		return totalChargeMin;
	}
	
	public static String msAfterBaseDateWithInputYMD(int year, int month, int day){
		final Calendar baseC = Calendar.getInstance();
		baseC.set(1970, 0, 0);
		
		Calendar inputC = Calendar.getInstance();
		inputC.set(year, month, day);
		
		long msBtw = inputC.getTimeInMillis()-baseC.getTimeInMillis();
		return ""+msBtw;
	}
	
	/**
	 * out call for 1688 is free
	 * @param number
	 * @return
	 */
	public static boolean noChargeNumbers(String number){
		ArrayList<String> noChargeList = new ArrayList<String>();
		noChargeList.add("1688");
		return noChargeList.contains(number);
	}
}
