package com.huawei;

public class CarDomain {
	private int carId;
	private int crossStartId;
	private int crossEndId;
	private int speedTop;
	private int planTime;

	
	
	@Override
	public String toString() {
		return "CarDomain [carId=" + carId + ", crossStartId=" + crossStartId + ", crossEndId=" + crossEndId
				+ ", speedTop=" + speedTop + ", planTime=" + planTime + "]";
	}

	public CarDomain() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarDomain(int carId, int crossStartId, int crossEndId, int speedTop, int planTime) {
		super();
		this.carId = carId;
		this.crossStartId = crossStartId;
		this.crossEndId = crossEndId;
		this.speedTop = speedTop;
		this.planTime = planTime;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public int getCrossStartId() {
		return crossStartId;
	}

	public void setCrossStartId(int crossStartId) {
		this.crossStartId = crossStartId;
	}

	public int getCrossEndId() {
		return crossEndId;
	}

	public void setCrossEndId(int crossEndId) {
		this.crossEndId = crossEndId;
	}

	public int getSpeedTop() {
		return speedTop;
	}

	public void setSpeedTop(int speedTop) {
		this.speedTop = speedTop;
	}

	public int getPlanTime() {
		return planTime;
	}

	public void setPlanTime(int planTime) {
		this.planTime = planTime;
	}

}
