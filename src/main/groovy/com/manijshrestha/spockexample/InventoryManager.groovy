package com.manijshrestha.spockexample

class InventoryManager{
	
    private def items =[:]
	
	def getCountOfInventory(item){
		items.get(item)
		}
	
}
