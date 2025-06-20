@Deployment public void testGetBusinessKeyFromDelegateExecution(){
assertEquals(1,runtimeService.createProcessInstanceQuery().processDefinitionKey("businessKeyProcess").count());
assertNotNull(key);
assertEquals("1234567890",key);
}