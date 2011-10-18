package com.manijshrestha.spockexample

import spock.lang.Specification
import com.manijshrestha.spockexample.InventoryManager
import com.manijshrestha.spockexample.exception.OutOfStockException
import com.manijshrestha.spockexample.exception.NotEnoughInventoryException

/**
 * Created by IntelliJ IDEA.
 * User: manijshrestha
 * Date: 10/12/11
 * Time: 11:10 PM
 * To change this template use File | Settings | File Templates.
 */
class InventoryManagerTest extends Specification{
	
	def inventoryManager = new InventoryManager()
	
	def "count of items in inventory"(){
		when:
			inventoryManager.items = ["cd": 3]
		then:
		    inventoryManager.getCountOfInventory("cd") == 3
	}
	
	def "total count of all inventories"(){
		when:
			inventoryManager.items = ["laptop": 10, "cellphone": 5, "tablet":5]
		
		then:
			inventoryManager.gotTotalInventoryCount() == 20
	}
	
	def "throw exception when trying to checkout item out of stock"(){
		when:
			inventoryManager.items = ["droidx": 0]
			inventoryManager.checkout("droidx", 1) // trying to buy droidx
		then:
			thrown(OutOfStockException)
	}
	
	def "throw exception when trying to checkout more qty than avail"(){
		when:
			inventoryManager.items = ["led tv": 2]
			inventoryManager.checkout("led tv", 3)
		then:
			thrown(NotEnoughInventoryException)
	}
	
	def "reduces correct number of items"(){
		when:
			inventoryManager.items=["dvd" : 10]
			inventoryManager.checkout("dvd", 7)
		then:
			inventoryManager.items.dvd == 3
	}

}
