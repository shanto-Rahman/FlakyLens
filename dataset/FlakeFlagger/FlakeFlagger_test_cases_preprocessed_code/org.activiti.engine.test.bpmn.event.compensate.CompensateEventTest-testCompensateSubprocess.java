@Deployment public void testCompensateSubprocess(){
assertEquals(5,runtimeService.getVariable(processInstance.getId(),"undoBookHotel"));
}