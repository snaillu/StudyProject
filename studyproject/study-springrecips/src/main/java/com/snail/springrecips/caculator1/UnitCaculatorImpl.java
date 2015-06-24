package com.snail.springrecips.caculator1;

public class UnitCaculatorImpl implements UnitCalculator {

	public double kilogramToPound(double kilogram) {
		double pound = kilogram * 2.2;
		System.out.println(kilogram +" kilogram = "+ pound+" pound");
		return pound;
	}

	public double kilometerMile(double kilometer) {
		double mile = kilometer * 0.62;
		System.out.println(kilometer +" kilometer = "+ mile+" mile");
		return mile;
	}

}
