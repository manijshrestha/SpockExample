package com.manijshrestha.spockexample

import spock.lang.Specification
import com.manijshrestha.spockexample.InventoryManager

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

}
