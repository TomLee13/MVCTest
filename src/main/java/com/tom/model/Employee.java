/**
 * A util model c
 */
package com.tom.model;

public class Employee {
	private int empId;
	private String empName;
	private int empSal;
	
	public Employee(int empId, String empName, int empSal) {
		//super();
		this.empId = empId;
		this.empName = empName;
		this.empSal = empSal;
	}

	public int getEmpId() {
		return empId;
	}

	public String getEmpName() {
		return empName;
	}

	public int getEmpSal() {
		return empSal;
	}
	
}
