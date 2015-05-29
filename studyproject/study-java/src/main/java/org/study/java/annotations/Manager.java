package org.study.java.annotations;

import org.study.java.annotations.Review.ReviewStatus;

@Review(status=ReviewStatus.FAILED,comments="failed")
public class Manager extends Employee {
	@Override
	public void setSalary(double salary){
		System.out.println("Manager.setSalary(): "+ salary);
	}
}
