package org.study.java.annotations;

public @interface Review {
	ReviewStatus status() default ReviewStatus.PENDING;
	String comments() default "";
	public enum ReviewStatus{PENDING,FAILED,PASSED,PASSEDWITHCHANGES}
}
