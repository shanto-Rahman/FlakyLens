@Deployment public void testHistoricActivityInstanceUnfinished(){
assertNotNull(processInstance);
assertEquals("The Start event is completed",1,finishedActivityInstanceCount);
assertEquals("One active (unfinished) User Task",1,unfinishedActivityInstanceCount);
}