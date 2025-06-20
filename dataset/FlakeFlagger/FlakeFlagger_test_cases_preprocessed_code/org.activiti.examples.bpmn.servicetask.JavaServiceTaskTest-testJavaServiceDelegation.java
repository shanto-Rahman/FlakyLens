@Deployment public void testJavaServiceDelegation(){
assertEquals("ACTIVITI BPM ENGINE",runtimeService.getVariable(execution.getId(),"input"));
}