package com.huawei;

public class RoadDomain implements Cloneable {
	// 道路id，道路长度，最高限速，车道数目，起始点id，终点id，是否双向
	// 道路id、
	private int roadId;
	// 道路长度
	private int roadLength;
	// 最高限速，
	private int roadSpeedTop;
	// 车道数目
	private int roadCount;
	// 起始点id、
	private int roadStartCrossId;
	// 终点id
	private int roadEndCrossId;
	// 是否双向 1：双向； 0：单向
	private int roadFlag;
//  一辆车在该路段的最短行驶时间
	private int shortTime;

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return "RoadDomain [roadId=" + roadId + ", roadLength=" + roadLength + ", roadSpeedTop=" + roadSpeedTop
				+ ", roadCount=" + roadCount + ", roadStartCrossId=" + roadStartCrossId + ", roadEndCrossId="
				+ roadEndCrossId + ", roadFlag=" + roadFlag + "]";
	}

	public RoadDomain() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RoadDomain(int roadId, int roadLength, int roadSpeedTop, int roadCount, int roadStartCrossId,
			int roadEndCrossId, int roadFlag) {
		super();
		this.roadId = roadId;
		this.roadLength = roadLength;
		this.roadSpeedTop = roadSpeedTop;
		this.roadCount = roadCount;
		this.roadStartCrossId = roadStartCrossId;
		this.roadEndCrossId = roadEndCrossId;
		this.roadFlag = roadFlag;
	}
	

	public int getShortTime() {
		return shortTime;
	}

	public void setShortTime(int shortTime) {
		this.shortTime = shortTime;
	}

	public int getRoadId() {
		return roadId;
	}

	public void setRoadId(int roadId) {
		this.roadId = roadId;
	}

	public int getRoadLength() {
		return roadLength;
	}

	public void setRoadLength(int roadLength) {
		this.roadLength = roadLength;
	}

	public int getRoadSpeedTop() {
		return roadSpeedTop;
	}

	public void setRoadSpeedTop(int roadSpeedTop) {
		this.roadSpeedTop = roadSpeedTop;
	}

	public int getRoadCount() {
		return roadCount;
	}

	public void setRoadCount(int roadCount) {
		this.roadCount = roadCount;
	}

	public int getRoadStartCrossId() {
		return roadStartCrossId;
	}

	public void setRoadStartCrossId(int roadStartCrossId) {
		this.roadStartCrossId = roadStartCrossId;
	}

	public int getRoadEndCrossId() {
		return roadEndCrossId;
	}

	public void setRoadEndCrossId(int roadEndCrossId) {
		this.roadEndCrossId = roadEndCrossId;
	}

	public int getRoadFlag() {
		return roadFlag;
	}

	public void setRoadFlag(int roadFlag) {
		this.roadFlag = roadFlag;
	}

}
