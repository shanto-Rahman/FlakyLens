@Deployment public void testBasicActivitiSpringIntegration(){
assertEquals("Hello from Printer!",runtimeService.getVariable(processInstance.getId(),"myVar"));
}