package com.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

public class Demo {
	static List<Map<String,Object>> result = null;
	static List<Map<String,Object>> result2 = null;
	 
	public static void main(String[] args){
		result = new ArrayList<Map<String,Object>>();
		result2 = new ArrayList<Map<String,Object>>();
		
		Map<String, Object> map5 = new HashMap<String, Object>();
	    map5.put("menu", "AAA1");
	    map5.put("parentMenu", "AAA");
	    map5.put("name", "AAA1");
	    
	    Map<String, Object> map6 = new HashMap<String, Object>();
	    map6.put("menu", "BBB1");
	    map6.put("parentMenu", "BBB");
	    map6.put("name", "BBB1");
	    
	    Map<String, Object> map7 = new HashMap<String, Object>();
	    map7.put("menu", "111_A");
	    map7.put("parentMenu", "111");
	    map7.put("name", "111_A");
	    
	    Map<String, Object> map8 = new HashMap<String, Object>();
	    map8.put("menu", "BBB1");
	    map8.put("parentMenu", "222");
	    map8.put("name", "BBB1");
	    
	    Map<String, Object> map9 = new HashMap<String, Object>();
	    map9.put("menu", "AAAA");
	    map9.put("parentMenu", "AAA1");
	    map9.put("name", "AAAA");
	    
	    Map<String, Object> map10 = new HashMap<String, Object>();
	    map10.put("menu", "AAAAA");
	    map10.put("parentMenu", "111_A");
	    map10.put("name", "AAAAA");
	    
	    
	    Map<String, Object> map11 = new HashMap<String, Object>();
	    map11.put("menu", "AAAAA666");
	    map11.put("parentMenu", "AAAAA");
	    map11.put("name", "AAAAA666");
	    
	    Map<String, Object> map12 = new HashMap<String, Object>();
	    map12.put("menu", "AAAAA777");
	    map12.put("parentMenu", "AAAAA");
	    map12.put("name", "AAAAA777");
	    
	    Map<String, Object> map13 = new HashMap<String, Object>();
	    map13.put("menu", "AAAAA777555");
	    map13.put("parentMenu", "AAAAA777");
	    map13.put("name", "AAAAA777555");
	    
	    Map<String, Object> map14 = new HashMap<String, Object>();
	    map14.put("menu", "AAAAA777444555");
	    map14.put("parentMenu", "AAAAA777555");
	    map14.put("name", "AAAAA777444555");
	    
	    Map<String, Object> map3 = new HashMap<String, Object>();
	    map3.put("menu", "AAA");
	    map3.put("parentMenu", "111");
	    map3.put("name", "AAA");
	    
	    Map<String, Object> map4 = new HashMap<String, Object>();
	    map4.put("menu", "BBB");
	    map4.put("parentMenu", "222");
	    map4.put("name", "BBB");
	    Map<String, Object> map1 = new HashMap<String, Object>();
	    map1.put("menu","111");
	    map1.put("parentMenu", "");
	    map1.put("name", "111");
	    //map1.put("children", map3);
	    
	    Map<String, Object> map2 = new HashMap<String, Object>();
	    map2.put("menu", "222");
	    map2.put("parentMenu", "");
	    map2.put("name", "222");
	    //map2.put("children", map4);
	    result.add(map1);
	    result.add(map2);
	    result.add(map3);
	    result.add(map4);
	    result.add(map5);
	    result.add(map6);
	    result.add(map7);
	    result.add(map8);
	    result.add(map9);
	    result.add(map10);
	    result.add(map11);
	    result.add(map12);
	    result.add(map13);
	    result.add(map14);
	    //result2.add(map1);
	    //result2.add(map2);
	    
		String str = "Hello,World";
		String str1 = "UN000000000000000002";
		String cs = "";
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		System.out.println(convertStr(cs,str,str.length()-1));
		System.out.println(str1.length());
		System.out.println(add(0,1));
		//System.out.println(JSONArray.fromObject(result).toString());
		//System.out.println(JSONArray.fromObject(result2).toString());
		System.out.println(JSONArray.fromObject(genList("")).toString());
	}
	
	public static String convertStr(String sb,String str,int index){
		if(index == 0){
			sb += str.substring(index,index+1);
			return sb.toString();
		}
		else{
			
			sb += str.substring(index,index+1);
			return convertStr(sb,str,--index);
		}
	}
	public static int add(int sum,int index){
		if(index == 10){
			sum += index;
			return sum;
		}
		else{
			sum += index;
			return add(sum,++index);
		}
		
	}
	
	public static List<Map<String,Object>> genList(String parentMenu){
		List<Map<String,Object>> result1 = new ArrayList<Map<String,Object>>();
		for(int i = 0 ; i < result.size() ; i++){
			Map<String,Object> map = result.get(i);
			if(map.get("parentMenu").toString().equals(parentMenu)){
				Map<String,Object> childMap = genChildrenList(map);
				result1.add(childMap);
			}
		}
		return result1;
		
		
	}
	
	public static Map<String,Object> genChildrenList(Map<String,Object> parentMap){
		List<Map<String,Object>> childrenList = new ArrayList<Map<String,Object>>();
		for(int i = 0 ; i < result.size() ; i++){
			Map<String,Object> map = result.get(i);
			if(parentMap.get("menu").toString().equals(map.get("parentMenu").toString())){
				childrenList.add(map);
				genChildrenList(map);
			}
			else{
				if(childrenList.size() > 0){
					parentMap.put("children", childrenList);
				}
			}
		}
		return parentMap;
		
	}
}
