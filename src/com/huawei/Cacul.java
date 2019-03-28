package com.huawei;

 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cacul {
	 public static void main(String[] args) {
		 String carPath = "E:\\文档\\赛事\\华为软件精英挑战赛\\2019软挑-初赛-SDK1\\SDK\\SDK_java1\\bin\\config\\car.txt";
	        String roadPath = "E:\\文档\\赛事\\华为软件精英挑战赛\\2019软挑-初赛-SDK1\\SDK\\SDK_java1\\bin\\config\\road.txt";
	        String crossPath = "E:\\文档\\赛事\\华为软件精英挑战赛\\2019软挑-初赛-SDK1\\SDK\\SDK_java1\\bin\\config\\cross.txt";
	        String answerPath = "E:\\文档\\赛事\\华为软件精英挑战赛\\2019软挑-初赛-SDK1\\SDK\\SDK_java1\\bin\\config\\answer.txt";
	        cacul(carPath, roadPath, crossPath, answerPath);
	        
	}

	public static void cacul(String carPath, String roadPath, String crossPath, String answerPath) {
//		读取文件初始化数据
		Map<String, Map> catalog= FileUtile.readFile(carPath,roadPath,crossPath);
		Map<Integer,CarDomain> carMap=catalog.get("car");
		Map<Integer,RoadDomain> roadMap=catalog.get("road");
		Map<Integer,CrossDomain> crossMap=catalog.get("cross");
		
		crossMap.get(10).setObstacle(carMap.size()/2);
		
        String[] anwser=new String [carMap.size()];
		int k=0;
		
		int carId=0;
		List<Integer> roadArray=null; 
		CarDomain carDomain=null;
		CrossDomain startCrossDomain=null;
		
		Map<Integer,CrossDomain> TCrossDomainMap=new HashMap<>();
		int roadTopTemp=0;
		int roadlenthTemp=0;
		
//	            计算每辆车的路线 
		for (Map.Entry<Integer,CarDomain> entry : carMap.entrySet()) {
//			获得车辆
			carId=entry.getKey();
			carDomain=entry.getValue();
			
			  System.out.println("车辆id = " + carId + ", 车辆 = " + carDomain); 
//			  初始化所有路口      crossMap   FT_flag标记     最短路径shortStartToHere   并且清空 前缀索引prefixCrossId
			 for (Map.Entry<Integer,CrossDomain> entryCrossDomain :  crossMap.entrySet()) {
				 entryCrossDomain.getValue().setTP_Flag("T");
				 entryCrossDomain.getValue().setShortStartToHere(-1);
				 entryCrossDomain.getValue().setPrefixCrossId(-1);
				 entryCrossDomain.getValue().setPrefixRoadId(-1);
				 
			 }
//			 初始化该车辆的初始路口
			 startCrossDomain=crossMap.get(carDomain.getCrossStartId());
			 startCrossDomain.setTP_Flag("T");
			 startCrossDomain.setShortStartToHere(0);
			 startCrossDomain.setPrefixCrossId(0); 
//			 清空t集合
			 TCrossDomainMap.clear();
			 TCrossDomainMap.put(startCrossDomain.getCrossId(), startCrossDomain);
			 
 
//			  初始化该车的所有道路的最短时间（不考虑其他车） 最短时间的计算有点问题 问题不大
			 for (Map.Entry<Integer,RoadDomain> entryRoadDomain :  roadMap.entrySet()) {
				 roadTopTemp=entryRoadDomain.getValue().getRoadSpeedTop();
				 roadlenthTemp=entryRoadDomain.getValue().getRoadLength();
				 entryRoadDomain.getValue().setShortTime(
						 roadTopTemp>carDomain.getSpeedTop()? roadlenthTemp/carDomain.getSpeedTop():roadlenthTemp/roadTopTemp);
			 }
			 
//			 计算 该车 路线
			 roadArray=oneCarRoutCacul(roadMap,crossMap,TCrossDomainMap,carDomain); 
              
			 StringBuffer stringBuffer=new StringBuffer("(");
              stringBuffer.append(carDomain.getCarId());
              stringBuffer.append(","); 
              stringBuffer.append(carDomain.getPlanTime());
              stringBuffer.append(",");
			 for (int i = roadArray.size()-1,j=2; i >-1; i--) {
				 stringBuffer.append(roadArray.get(i));
				 stringBuffer.append(",");
			 }
			 stringBuffer.delete(stringBuffer.length()-1,stringBuffer.length());
			 stringBuffer.append(")");
			 
			 System.out.println("arr:"+stringBuffer.toString());
			 anwser[k++]=stringBuffer.toString();
		}
		
		
//		写入答案
        FileUtile.write(answerPath,anwser);
	}

	private static List<Integer> oneCarRoutCacul(Map<Integer, RoadDomain> roadMap, Map<Integer, CrossDomain> crossMap,
			Map<Integer, CrossDomain> tCrossDomainMap, CarDomain carDomain) {
		
		CrossDomain endCrossDomain=crossMap.get(carDomain.getCrossEndId());
		CrossDomain minTCross=getMinTCross(tCrossDomainMap);
		if("P".equals(endCrossDomain.getTP_Flag())||endCrossDomain.getCrossId()==(minTCross.getCrossId())){
			System.out.println("结束了");
			List<Integer> roadArray=new ArrayList<>(); 
			CrossDomain next=endCrossDomain;
			for (int i=0;carDomain.getCrossStartId()!=next.getCrossId();i++) {
				System.out.println("carDomain:"+carDomain);
				System.out.println("next:"+next);
				roadArray.add(next.getPrefixRoadId());
				next=crossMap.get(next.getPrefixCrossId());
			}
			System.out.println("结束");
			return roadArray; 
			
		}else{
			minTCross.setTP_Flag("P");
			 
//			从tCrossDomainMap移除该p标记的路口
			tCrossDomainMap.remove(minTCross.getCrossId());
			int[] roadArray=minTCross.getRoadArray();
			CrossDomain adjacentCrossDomain=null;
			int newTempShortStartToHere=0;
//			处理四条相邻道路对应的路口  
			for(int i=0;i<roadArray.length;i++){
				if(roadArray[i]!=-1){
					int obstacle =crossMap.get(roadMap.get(roadArray[i]).getRoadStartCrossId()).getObstacle();
					if( roadMap.get(roadArray[i]).getRoadStartCrossId()!=endCrossDomain.getCrossId()&&obstacle!=0){
						crossMap.get(roadMap.get(roadArray[i]).getRoadStartCrossId()).setObstacle(--obstacle);
						continue;
					}
					if(roadMap.get(roadArray[i]).getRoadStartCrossId()==minTCross.getCrossId()  ){
						
						 adjacentCrossDomain=crossMap.get(roadMap.get(roadArray[i]).getRoadEndCrossId());
						 
					}else if(roadMap.get(roadArray[i]).getRoadFlag()==1){
						 
						adjacentCrossDomain=crossMap.get(roadMap.get(roadArray[i]).getRoadStartCrossId());
					}else{
						continue;
					};
					
					if("P".equals(adjacentCrossDomain.getTP_Flag()))continue;
					
//					暂时的 新的距离出发点的时间
					newTempShortStartToHere=minTCross.getShortStartToHere()+roadMap.get(roadArray[i]).getShortTime();

					//	设置  最短时间值 和前缀   收集非-1的T标记的路口
					if(adjacentCrossDomain.getShortStartToHere()==-1 ||
							adjacentCrossDomain.getShortStartToHere()>newTempShortStartToHere){
						adjacentCrossDomain.setShortStartToHere( newTempShortStartToHere );
						if(minTCross.getCrossId()==01)System.out.println("minTCross:----"+minTCross);
						adjacentCrossDomain.setPrefixCrossId(minTCross.getCrossId());
						
						adjacentCrossDomain.setPrefixRoadId(roadMap.get(roadArray[i]).getRoadId());
//						收集非-1的T标记的路口
						tCrossDomainMap.put(adjacentCrossDomain.getCrossId(), adjacentCrossDomain);
					} 
				}
			}
			 
			return oneCarRoutCacul(roadMap,crossMap,tCrossDomainMap,carDomain);
		}
		
		
	}

	 

	private static CrossDomain getMinTCross(Map<Integer, CrossDomain> tCrossDomainMap) {
		if(tCrossDomainMap.size()==0){
			return null;
		}
		int shortStartToHere=10000;
		CrossDomain minTCross=null;
		
		for (Map.Entry<Integer,CrossDomain> entryCrossDomain :  tCrossDomainMap.entrySet()) {
			minTCross=entryCrossDomain.getValue().getShortStartToHere()<shortStartToHere?entryCrossDomain.getValue():minTCross;
		}
		return minTCross;
	}

	 

}
