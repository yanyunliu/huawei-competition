package com.huawei;

import java.util.Arrays;

public class CrossDomain {
	private int crossId;
	private int[] roadArray;
	 
	
//	TP标志
	private String TP_Flag;
//	前缀索引
	private int prefixCrossId;
//	前缀 道路索引
	private int prefixRoadId;
		
//	起始点到该路口最短距离
	private int shortStartToHere;
	 
	
	 
	@Override
	public String toString() {
		return "CrossDomain [crossId=" + crossId + ", roadArray=" + Arrays.toString(roadArray) + ", TP_Flag=" + TP_Flag
				+ ", prefixCrossId=" + prefixCrossId + ", prefixRoadId=" + prefixRoadId + ", shortStartToHere="
				+ shortStartToHere + "]";
	}



	public CrossDomain() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	
	 
	public CrossDomain(int crossId, int[] roadArray) {
		super();
		this.crossId = crossId;
		this.roadArray = roadArray;
	}



	public CrossDomain(int crossId, int[] roadArray, String tP_Flag, int prefixCrossId, int shortStartToHere) {
		super();
		this.crossId = crossId;
		this.roadArray = roadArray;
		TP_Flag = tP_Flag;
		this.prefixCrossId = prefixCrossId;
		this.shortStartToHere = shortStartToHere;
	}



	public int getPrefixRoadId() {
		return prefixRoadId;
	}



	public void setPrefixRoadId(int prefixRoadId) {
		this.prefixRoadId = prefixRoadId;
	}



	public int getCrossId() {
		return crossId;
	}
	public void setCrossId(int crossId) {
		this.crossId = crossId;
	}
	 
	public int[] getRoadArray() {
		return roadArray;
	} 
	public void setRoadArray(int[] roadArray) {
		this.roadArray = roadArray;
	}



	public String getTP_Flag() {
		return TP_Flag;
	}
	public void setTP_Flag(String tP_Flag) {
		TP_Flag = tP_Flag;
	}
	public int getPrefixCrossId() {
		return prefixCrossId;
	}
	public void setPrefixCrossId(int prefixCrossId) {
		this.prefixCrossId = prefixCrossId;
	}
	public int getShortStartToHere() {
		return shortStartToHere;
	}
	public void setShortStartToHere(int shortStartToHere) {
		this.shortStartToHere = shortStartToHere;
	}
    
	
}
