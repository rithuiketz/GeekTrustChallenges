package com.example.geektrust;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.example.geektrust.ExpenseManagement.dao.House;
import com.example.geektrust.ExpenseManagement.dao.Person;
import com.example.geektrust.ExpenseManagement.dao.PersonImpl;
import com.example.geektrust.ExpenseManagement.dao.Property;
import com.example.geektrust.ExpenseManagement.utils.StatusEnum;

@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
class HouseTest 
{
	Property house;
	
	@BeforeAll
	public void setProps()
	{
		house = new House("test_house");
	}
	
	//no empty user should be added
	
	@Order(1)
	@Test
	public void addEmptyUser()
	{
		System.out.println("######## TEST 1 #############");
		Person person =  null;
		StatusEnum status  = house.addMemeber(person);
		assertEquals(StatusEnum.INVALID_MEMBER, status);
	}
	
	@Order(2)
	@Test
	public void addDuplicateUser()
	{
		System.out.println("######## TEST 2 #############");
		Person p1 = new PersonImpl("Rithuik");
		StatusEnum se = house.addMemeber(p1);
		assertEquals(StatusEnum.MEMBER_ADDED, se);
		Person p2 = new PersonImpl("Rithuik");
		se = house.addMemeber(p2);
		assertEquals(StatusEnum.DUPLICATE_MEMBER, se);
		
	}
	
	@Order(3)
	@Test
	public void checkHouseful()
	{
		System.out.println("######## TEST 3 #############");
		Person p1 = new PersonImpl("Rithuik2");
		StatusEnum se = house.addMemeber(p1);
		assertEquals(StatusEnum.MEMBER_ADDED, se);
		
		Person p2 = new PersonImpl("Rithuik3");
		se = house.addMemeber(p2);
		assertEquals(StatusEnum.MEMBER_ADDED, se);
		
		Person p3 = new PersonImpl("Rithuik4");
		se = house.addMemeber(p3);
		assertEquals(StatusEnum.HOUSEFUL, se);
		
		Person p4 = new PersonImpl("Rithuik4");
		se = house.addMemeber(p4);
		assertEquals(StatusEnum.HOUSEFUL, se);
		
	}

}
