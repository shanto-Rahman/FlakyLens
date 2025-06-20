@Deployment public void testConfigurationBeanAccess(){
assertEquals("I'm exposed",runtimeService.getVariable(pi.getId(),"exposedBeanResult"));
fail("Exception expected");
assertNotNull(ae.getCause());
assertTrue(ae.getCause() instanceof RuntimeException);
assertTrue(runtimeException.getCause() instanceof PropertyNotFoundException);
}