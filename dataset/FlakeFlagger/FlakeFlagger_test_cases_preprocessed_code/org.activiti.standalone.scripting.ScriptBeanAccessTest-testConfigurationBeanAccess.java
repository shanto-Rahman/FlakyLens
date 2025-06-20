@Deployment public void testConfigurationBeanAccess(){
assertEquals("myValue",runtimeService.getVariable(pi.getId(),"myVariable"));
}