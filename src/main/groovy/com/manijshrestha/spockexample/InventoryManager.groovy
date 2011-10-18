package com.manijshrestha.spockexample

import com.manijshrestha.spockexample.exception.OutOfStockException
import com.manijshrestha.spockexample.exception.NotEnoughInventoryException

class InventoryManager{
	
    private def items =[:]
	
	def getCountOfInventory(item){
		items.get(item)
		}
	
	def gotTotalInventoryCount(){
		def sum = 0
		items.each{sum += it.value}
		return sum
	}
	
	def checkout(String item, int qty){
		def availQty = items.get(item)
		if(availQty <= 0)
			throw new OutOfStockException()
		if(qty > availQty)
			throw new NotEnoughInventoryException()
		
			items.put(item, availQty - qty)	
	}
}
