@Deployment public void testUnexistingClassDelegation(){
fail();
assertTrue(e.getMessage().contains("couldn't instantiate class org.activiti.BogusClass"));
assertNotNull(e.getCause());
assertTrue(e.getCause() instanceof ActivitiClassLoadingException);
}