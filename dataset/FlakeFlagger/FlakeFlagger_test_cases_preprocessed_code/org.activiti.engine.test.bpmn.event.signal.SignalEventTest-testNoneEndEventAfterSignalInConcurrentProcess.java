@Deployment public void testNoneEndEventAfterSignalInConcurrentProcess(){
assertNotNull(processInstance);
assertEquals("usertask2",task.getTaskDefinitionKey());
}