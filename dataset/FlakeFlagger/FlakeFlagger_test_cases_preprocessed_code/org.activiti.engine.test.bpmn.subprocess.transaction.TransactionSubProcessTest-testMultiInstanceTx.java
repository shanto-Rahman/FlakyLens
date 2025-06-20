@Deployment public void testMultiInstanceTx(){
assertEquals(10,eventSubscriptionEntities.size());
assertEquals(0,createEventSubscriptionQuery().count());
assertEquals(5,runtimeService.getVariable(processInstance.getId(),"undoBookHotel"));
assertEquals(5,runtimeService.getVariable(processInstance.getId(),"undoBookFlight"));
}