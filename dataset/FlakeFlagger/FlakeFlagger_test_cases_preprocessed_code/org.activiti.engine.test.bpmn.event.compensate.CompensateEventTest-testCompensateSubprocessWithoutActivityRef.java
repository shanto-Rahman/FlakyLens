@Deployment public void testCompensateSubprocessWithoutActivityRef(){
assertEquals(5,runtimeService.getVariable(processInstance.getId(),"undoBookHotel"));
}