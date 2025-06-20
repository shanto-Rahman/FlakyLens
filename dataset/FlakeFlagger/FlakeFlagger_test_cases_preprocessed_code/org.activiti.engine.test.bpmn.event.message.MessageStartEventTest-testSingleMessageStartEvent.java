@Deployment public void testSingleMessageStartEvent(){
assertFalse(processInstance.isEnded());
assertNotNull(task);
assertFalse(processInstance.isEnded());
assertNotNull(task);
}