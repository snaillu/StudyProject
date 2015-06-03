package org.study.java.lambda;

import java.util.List;
import java.util.function.Supplier;

public class FunctionUtilTest {
	public static void main(String[] args) {
		List<Person> list = Person.getPersons();
		
		System.out.println("Origianl list of persons:");
		FunctionUtil.forEach(list, p->System.out.println(p));
		
		List<Person> maleList = FunctionUtil.filter(list, p->p.getGender()==Gender.MALE);
		System.out.println("\nMales only:");
		FunctionUtil.forEach(maleList, p->System.out.println(p));
		
		List<Integer> dobYearList = FunctionUtil.map(list, p->p.getDob().getYear());
		
		System.out.println("\nPersons mapped to year of their birth:");
		FunctionUtil.forEach(dobYearList, year->System.out.println(year));
		
		FunctionUtil.forEach(maleList, p->p.setDob(p.getDob().plusYears(1)));
		
		System.out.println("\nMales only after adding one year to DOB:");
		FunctionUtil.forEach(maleList, p->System.out.println(p));
		
		System.out.println("\nPerson get by method reference:");
		Supplier<List<Person>> supplier = Person::getPersons;
		List<Person> personList = supplier.get();
		FunctionUtil.forEach(personList, p->System.out.println(p));
	}
}
