package com;

import java.util.ArrayList;
import java.util.List;

public class RecursionDemo {

	static int[] s_pack = new int[]{11,8,7,6,5};
	static int[] t_pack = new int[3];
	final static int targetW = 26;
	static List<String> listStr = new ArrayList<String>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] r = getTarget(targetW,0,0,0,0);
//		for(int i = 0 ; i < r.length ;i++){
//			System.out.println(r[i]);
//		}
		String str = "cat";
		printAllP("",str,0);
		int c = 1;
		for(String ds:listStr){
			System.out.println((c++)+"======="+ds);
		}
		System.out.println(power(2,8));
	}
	
	public static void printAllP(String key,String str,int idx){
		String fw = "";
		String tmpStr = "";
		if(idx == 0){
			if(!listStr.contains(key+str)){
				listStr.add(key+str);
			}
			
			fw = str.substring(idx, idx+1);
			tmpStr = str.substring(idx+1);
			if(tmpStr.length() >= 3){
				printAllP(key+fw,tmpStr,0);
			}
			
		}
		else{
			fw = str.substring(idx, idx+1);
			tmpStr = str.substring(0,idx)+str.substring(idx+1);
			if(!listStr.contains(key+fw+tmpStr)){
				listStr.add(key+fw+tmpStr);
			}
			if(tmpStr.length() >= 3){
				printAllP(key+fw,tmpStr,0);
			}
		}
//		for(int i = 0 ; i < tmpStr.length();i++){
			StringBuilder sb = new StringBuilder();
			if(tmpStr.length() < 3){
				String tmp = tmpStr.substring(0, 1);
				sb.append(tmpStr.substring(1)).append(tmp);
				if(!listStr.contains(key+fw+sb.toString())){
					listStr.add(key+fw+sb.toString());
				}
				
			}
			else{
				if(!listStr.contains(key+str)){
					listStr.add(key+str);
				}
				printAllP(key+fw,tmpStr,0);
			}
//		}
		if( idx+1 < str.length()){
			printAllP(key,str,idx+1);
		}
	}
	
	public static double power(double r,int y){
		if(y == 1){
			return r;
		}
		else{
			return power(r*r,y/2);
		}
		
	}
	
	public static int[] getTarget(int target,int n_idx,int s_idx,int t_idx,int an_idx){
		if(s_idx <= 4 && target != s_pack[s_idx]){
			
			if(s_idx <= 4){
				if(t_idx == t_pack.length){
					t_idx = t_pack.length - 1;
				}
				if(target - s_pack[s_idx] > 0){
					t_pack[t_idx] = s_pack[s_idx];
					String o_str = "";
					for(int i = 0 ; i <= t_idx; i++){
						o_str += t_pack[i]+",";
					}
					o_str+="   Target="+target+"   "+t_pack[t_idx]+"is too small";
					target = target - s_pack[s_idx];
					System.out.println(o_str);
				}
				else{
					t_pack[t_idx] = s_pack[s_idx];
					String o_str = "";
					for(int i = 0 ; i <= t_idx; i++){
						o_str += t_pack[i]+",";
					}
					o_str+="   Target="+target+"   "+t_pack[t_idx]+"is too big";
					System.out.println(o_str);
				}
				getTarget(target,n_idx,++s_idx,++t_idx,an_idx);
			}
			
		}
		else if(s_idx <= 4 && target == s_pack[s_idx]){
			t_pack[t_pack.length-1] = s_pack[s_idx];
			String o_str = "";
			for(int i = 0 ; i <= t_idx-1; i++){
				o_str += t_pack[i]+",";
			}
			o_str+="   Target="+target+"   "+t_pack[t_idx-1]+"success";
			System.out.println(o_str);
			return t_pack;
		}
		else if(s_idx > 4){
			if(n_idx >= 4){
				an_idx+=1;
				t_idx = 0;
				getTarget(targetW,an_idx,an_idx,t_idx,an_idx);
			}
			else{
				n_idx += 1;
				t_idx = 1;
				
				getTarget(targetW-t_pack[0],n_idx,++n_idx,t_idx,an_idx);
			}
			
			
			
		}
		return t_pack;
	}
	

}
