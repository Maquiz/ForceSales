package SaleTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Sale.Item;

class ItemTest {

	Item ik = new Item("A's Hat",29.99f,3);
	
	
	@Test
	void testItemToString() {
		assertTrue(ik.toString().equals("A's Hat 29.99 3 89.97"), "These strings should match" );
	}
	
	@Test 
	void testItemTotalCost() {
		assertTrue(ik.itemTotalCost() == 89.97f, "Cost Should be equal");
	}
	
	@Test
	void testItemChangeQuantity() {
		ik.changeQuantity(-1);
		assertTrue(ik.itemTotalCost() == 59.98f, "Removed one item from A's Hat");
	}

}
