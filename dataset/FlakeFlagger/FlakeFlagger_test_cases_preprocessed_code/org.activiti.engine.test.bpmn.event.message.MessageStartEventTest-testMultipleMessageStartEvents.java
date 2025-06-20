@Deployment public void testMultipleMessageStartEvents(){
assertFalse(processInstance.isEnded());
assertNotNull(task);
assertFalse(processInstance.isEnded());
assertNotNull(task);
assertFalse(processInstance.isEnded());
assertNotNull(task);
}