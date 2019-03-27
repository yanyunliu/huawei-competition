package com.huawei;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class FileUtile {
    
	public static Map<String, Map> readFile(String carPath, String roadPath, String crossPath) {
		Map<String, Map> catalog=new HashMap<>();
		File carFile = new File(carPath);
		File roadFile = new File(roadPath);
		File crossFile = new File(crossPath); 
		
		Map<Integer, CarDomain> carMap =readCarFile(carFile);
		Map<Integer, RoadDomain> roadMap =readRoadFile(roadFile);
		Map<Integer, CrossDomain> crossMap =readCrossFile(crossFile);
		
		catalog.put("car", carMap);
		catalog.put("road", roadMap);
		catalog.put("cross", crossMap);
		
		return catalog;
	}

	private static Map<Integer, CrossDomain> readCrossFile(File myFile) {
		// 第三种：以行为单位读取文件，常用于读面向行的格式化文件 
				Map<Integer, CrossDomain> crossMap=new HashMap<>();
				BufferedReader reader=null;
				try {
					
						reader = new BufferedReader(new FileReader(myFile)); 
						String tempString = null;  
						int line = 1;  
						// 一次读入一行，直到读入null为文件结束  
						while ((tempString = reader.readLine()) != null) {  
						    
						    if(!tempString.contains("#")){
						    	// 显示行号  
							    System.out.println("line " + line + ": " + tempString);  
							    tempString= tempString.substring(1, tempString.length()-1);
							    System.out.println("截取后：line " + line + ": " + tempString);  
							    String[] strArray=tempString.split(",");
							    
							    trimStrArray(strArray);
							    
							    int[] roadArray=new int[4];
							    for (int i = 0; i < roadArray.length; ) {
									 roadArray[i]=Integer.valueOf(strArray[++i]);
									
								}
							    crossMap.put(Integer.valueOf(strArray[0]), 
							    		new CrossDomain(Integer.valueOf(strArray[0]),roadArray));
							    
							    
						    }
						    
						    line++;  
						}  
						
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println("FileNotFoundException:文件寻找异常");
					e.printStackTrace();
				}catch (IOException e) {
					// TODO: handle exception
					System.out.println("IOException:文件读取异常");
					e.printStackTrace();
				}
				
				finally {
					try {
						reader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("IOException:文件关闭异常");
						e.printStackTrace();
					}
				}
				return crossMap;
	}

	private static Map<Integer, RoadDomain> readRoadFile(File myFile) {
		// 第三种：以行为单位读取文件，常用于读面向行的格式化文件 
				Map<Integer, RoadDomain> roadMap=new HashMap<>();
				BufferedReader reader=null;
				try {
					
						reader = new BufferedReader(new FileReader(myFile)); 
						String tempString = null;  
						int line = 1;  
						// 一次读入一行，直到读入null为文件结束  
						while ((tempString = reader.readLine()) != null) {  
						    
						    if(!tempString.contains("#")){
						    	// 显示行号  
							    System.out.println("line " + line + ": " + tempString);  
							    tempString= tempString.substring(1, tempString.length()-1);
							    System.out.println("截取后：line " + line + ": " + tempString);  
							    String[] strArray=tempString.split(",");
							    
							    trimStrArray(strArray);
							    
							    
							    roadMap.put(Integer.valueOf(strArray[0]), 
							    		new RoadDomain(Integer.valueOf(strArray[0]), 
							    				      Integer.valueOf(strArray[1]),
							    				      Integer.valueOf(strArray[2]), 
							    				      Integer.valueOf(strArray[3]), 
							    				      Integer.valueOf(strArray[4]),
							    				      Integer.valueOf(strArray[5]),
							    				      Integer.valueOf(strArray[6]) 
							    				));
							    
							    
						    }
						    
						    line++;  
						}  
						
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println("FileNotFoundException:文件寻找异常");
					e.printStackTrace();
				}catch (IOException e) {
					// TODO: handle exception
					System.out.println("IOException:文件读取异常");
					e.printStackTrace();
				}
				
				finally {
					try {
						reader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("IOException:文件关闭异常");
						e.printStackTrace();
					}
				}
				return roadMap;
	}

	private static Map<Integer, CarDomain> readCarFile(File myFile) {
		// 第三种：以行为单位读取文件，常用于读面向行的格式化文件 
		Map<Integer, CarDomain> carMap=new HashMap<>();
		BufferedReader reader=null;
		try {
			
				reader = new BufferedReader(new FileReader(myFile)); 
				String tempString = null;  
				int line = 1;  
				// 一次读入一行，直到读入null为文件结束  
				while ((tempString = reader.readLine()) != null) {  
				    
				    if(!tempString.contains("#")){
				    	// 显示行号  
					    System.out.println("line " + line + ": " + tempString);  
					    tempString= tempString.substring(1, tempString.length()-1);
					    System.out.println("截取后：line " + line + ": " + tempString);  
					    String[] strArray=tempString.split(",");
					    
					    trimStrArray(strArray);
					    
					    
					    carMap.put(Integer.valueOf(strArray[0]), 
					    		new CarDomain(Integer.valueOf(strArray[0]), 
					    				      Integer.valueOf(strArray[1]),
					    				      Integer.valueOf(strArray[2]), 
					    				      Integer.valueOf(strArray[3]), 
					    				      Integer.valueOf(strArray[4])));
					    
					    
				    }
				    
				    line++;  
				}  
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("FileNotFoundException:文件寻找异常");
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
			System.out.println("IOException:文件读取异常");
			e.printStackTrace();
		}
		
		finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("IOException:文件关闭异常");
				e.printStackTrace();
			}
		}
		return carMap;
	}

	private static void trimStrArray(String[] strArray) {
		for (int i=0;i<strArray.length;i++) {
	    	strArray[i] =strArray[i].trim();
		}	
	}

	public static void write(String answerPath, String[] anwser) {
		 
		File answerFile = new File(answerPath);
		PrintWriter pw =null;
		try {
			if (!answerFile.exists()) {
			    // 创建文件(前提是目录已存在，若不在，需新建目录即文件夹) 
					answerFile.createNewFile(); 
			} 
			
		    pw = new PrintWriter(new FileWriter(answerFile,true));   
			for (String string : anwser) {
				
				pw.println(string);      // 换行 
			}
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pw.close();
		}
	}

	 

}
