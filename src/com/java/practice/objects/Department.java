package com.java.practice.objects;

public class Department implements Cloneable{
	private String deptName;
	private Integer depptId;
	
	public Department(String deptName, Integer depptId) {
		super();
		this.deptName = deptName;
		this.depptId = depptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Integer getDepptId() {
		return depptId;
	}
	public void setDepptId(Integer depptId) {
		this.depptId = depptId;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
	    return super.clone();
	}
	
	@Override
	public String toString() {
		return "Department [deptName=" + deptName + ", depptId=" + depptId + "]";
	}
}
