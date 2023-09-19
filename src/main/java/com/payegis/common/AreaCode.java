package com.payegis.common;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AreaCode {

    private static AreaCode areaCode = null;

    public synchronized static AreaCode getInstance() {
        if (areaCode == null) {
            areaCode = new AreaCode();
        }

        return areaCode;
    }

    public List<Map<String, String>> readCode(String filename) {
        List<Map<String, String>> codeInfo = new ArrayList<Map<String, String>>();

        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(new File(filename)), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String lineStr = bufferedReader.readLine();
            String[] lineInfo = null;

            while (lineStr != null) {
                lineInfo = lineStr.trim().split(" ");
                // Address addrObj = new Address(lineInfo[0], lineInfo[1], lineInfo[2]);
                Map<String, String> map = new HashMap<String, String>();
                // JSONObject jsonObject = new JSONObject();
                // jsonObject.put("code", lineInfo[0]);	//行政区划代码

                for (int i = 0; i < lineInfo.length; i++) {
                    if (0 == i) {
                        map.put("code", lineInfo[i]);
                    } else if (1 == i) {
                        // 省、直辖市、自治区
                        map.put("province", lineInfo[i]);
                    } else if (2 == i) {
                        // 地级市、直辖市市辖区
                        map.put("city", lineInfo[i]);
                    } else if (3 == i) {
                        // 地级市区、县
                        map.put("area", lineInfo[3]);
                    }

                }
                codeInfo.add(map);

                lineStr = bufferedReader.readLine();
            }
            bufferedReader.close();
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("file not found exception, msg is " + e.toString());
        } catch (IOException e) {
            System.out.println("Error for ioexception, msg is " + e.toString());
        }
        return codeInfo;
    }


    public List<Map<String, String>> foreign(String filename) {
        List<Map<String, String>> foreignInfo = new ArrayList<>();

        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(new File(filename)), "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String lineStr = bufferedReader.readLine();
            String[] lineInfo = null;

            while (lineStr != null) {
                lineInfo = lineStr.trim().split(" ");
                Map<String, String> map = new HashMap<String, String>();

                map.put("fullCountryName", lineInfo[0]);
                map.put("simpleCountryName", lineInfo[1]);
                map.put("CityName", lineInfo[2]);
                foreignInfo.add(map);

                lineStr = bufferedReader.readLine();
            }
            bufferedReader.close();
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("file not found exception, msg is " + e.toString());
        } catch (IOException e) {
            System.out.println("Error for ioexception, msg is " + e.toString());
        }
        return foreignInfo;
    }

    public static void main(String[] args) {
//		AreaCode areaCode = new AreaCode();
        /**
         List<Map<String, String>> cInfo = areaCode.readCode(ConfigFileUtil.getString("FILE_PCR"));
         for(Map<String, String> temp : cInfo) {
         System.out.println(temp.get("province") + "_" + temp.get("city") + "_" + temp.get("area"));
         //			System.out.println(temp.getProvince() + "_" + temp.getCity() + "_" + temp.getArea());
         }
         */

		/*List<Map<String, String>> fInfo = areaCode.foreign(ConfigFileUtil.getString("FILE_FOREIGN"));
		for (Map<String, String> temp : fInfo) {
			System.out.println(temp.get("fullCountryName") + "_" + temp.get("simpleCountryName") + "_" + temp.get("CityName"));
		}*/

    }
}
