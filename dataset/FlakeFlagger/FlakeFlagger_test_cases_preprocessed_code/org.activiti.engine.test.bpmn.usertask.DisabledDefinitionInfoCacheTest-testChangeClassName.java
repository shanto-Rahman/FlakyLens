@Deployment public void testChangeClassName(){
assertEquals(1,runtimeService.getVariable(processInstance.getId(),"count"));
assertEquals(0,runtimeService.getVariable(processInstance.getId(),"count2"));
assertEquals(1,runtimeService.getVariable(processInstance.getId(),"count"));
assertEquals(0,runtimeService.getVariable(processInstance.getId(),"count2"));
}