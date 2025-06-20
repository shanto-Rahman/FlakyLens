@Deployment public void testMessageStartEventAndNoneStartEvent(){
assertFalse(processInstance.isEnded());
assertNotNull(task);
assertFalse(processInstance.isEnded());
assertNotNull(task);
}