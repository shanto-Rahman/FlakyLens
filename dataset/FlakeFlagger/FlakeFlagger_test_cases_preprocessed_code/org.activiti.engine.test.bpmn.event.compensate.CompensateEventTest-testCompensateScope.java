@Deployment public void testCompensateScope(){
assertEquals(5,runtimeService.getVariable(processInstance.getId(),"undoBookHotel"));
assertEquals(5,runtimeService.getVariable(processInstance.getId(),"undoBookFlight"));
}