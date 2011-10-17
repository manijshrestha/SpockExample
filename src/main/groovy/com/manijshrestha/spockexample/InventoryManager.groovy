package com.manijshrestha.spockexample

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
}
