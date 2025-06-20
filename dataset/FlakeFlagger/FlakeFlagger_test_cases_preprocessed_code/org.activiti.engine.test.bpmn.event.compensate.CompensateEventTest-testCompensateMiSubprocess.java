@Deployment public void testCompensateMiSubprocess(){
assertEquals(5,runtimeService.getVariable(processInstance.getId(),"undoBookHotel"));
}