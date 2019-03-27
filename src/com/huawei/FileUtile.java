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
		// �����֣�����Ϊ��λ��ȡ�ļ��������ڶ������еĸ�ʽ���ļ� 
				Map<Integer, CrossDomain> crossMap=new HashMap<>();
				BufferedReader reader=null;
				try {
					
						reader = new BufferedReader(new FileReader(myFile)); 
						String tempString = null;  
						int line = 1;  
						// һ�ζ���һ�У�ֱ������nullΪ�ļ�����  
						while ((tempString = reader.readLine()) != null) {  
						    
						    if(!tempString.contains("#")){
						    	// ��ʾ�к�  
							    System.out.println("line " + line + ": " + tempString);  
							    tempString= tempString.substring(1, tempString.length()-1);
							    System.out.println("��ȡ��line " + line + ": " + tempString);  
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
					System.out.println("FileNotFoundException:�ļ�Ѱ���쳣");
					e.printStackTrace();
				}catch (IOException e) {
					// TODO: handle exception
					System.out.println("IOException:�ļ���ȡ�쳣");
					e.printStackTrace();
				}
				
				finally {
					try {
						reader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("IOException:�ļ��ر��쳣");
						e.printStackTrace();
					}
				}
				return crossMap;
	}

	private static Map<Integer, RoadDomain> readRoadFile(File myFile) {
		// �����֣�����Ϊ��λ��ȡ�ļ��������ڶ������еĸ�ʽ���ļ� 
				Map<Integer, RoadDomain> roadMap=new HashMap<>();
				BufferedReader reader=null;
				try {
					
						reader = new BufferedReader(new FileReader(myFile)); 
						String tempString = null;  
						int line = 1;  
						// һ�ζ���һ�У�ֱ������nullΪ�ļ�����  
						while ((tempString = reader.readLine()) != null) {  
						    
						    if(!tempString.contains("#")){
						    	// ��ʾ�к�  
							    System.out.println("line " + line + ": " + tempString);  
							    tempString= tempString.substring(1, tempString.length()-1);
							    System.out.println("��ȡ��line " + line + ": " + tempString);  
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
					System.out.println("FileNotFoundException:�ļ�Ѱ���쳣");
					e.printStackTrace();
				}catch (IOException e) {
					// TODO: handle exception
					System.out.println("IOException:�ļ���ȡ�쳣");
					e.printStackTrace();
				}
				
				finally {
					try {
						reader.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("IOException:�ļ��ر��쳣");
						e.printStackTrace();
					}
				}
				return roadMap;
	}

	private static Map<Integer, CarDomain> readCarFile(File myFile) {
		// �����֣�����Ϊ��λ��ȡ�ļ��������ڶ������еĸ�ʽ���ļ� 
		Map<Integer, CarDomain> carMap=new HashMap<>();
		BufferedReader reader=null;
		try {
			
				reader = new BufferedReader(new FileReader(myFile)); 
				String tempString = null;  
				int line = 1;  
				// һ�ζ���һ�У�ֱ������nullΪ�ļ�����  
				while ((tempString = reader.readLine()) != null) {  
				    
				    if(!tempString.contains("#")){
				    	// ��ʾ�к�  
					    System.out.println("line " + line + ": " + tempString);  
					    tempString= tempString.substring(1, tempString.length()-1);
					    System.out.println("��ȡ��line " + line + ": " + tempString);  
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
			System.out.println("FileNotFoundException:�ļ�Ѱ���쳣");
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
			System.out.println("IOException:�ļ���ȡ�쳣");
			e.printStackTrace();
		}
		
		finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("IOException:�ļ��ر��쳣");
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
			    // �����ļ�(ǰ����Ŀ¼�Ѵ��ڣ������ڣ����½�Ŀ¼���ļ���) 
					answerFile.createNewFile(); 
			} 
			
		    pw = new PrintWriter(new FileWriter(answerFile,true));   
			for (String string : anwser) {
				
				pw.println(string);      // ���� 
			}
			 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pw.close();
		}
	}

	 

}
