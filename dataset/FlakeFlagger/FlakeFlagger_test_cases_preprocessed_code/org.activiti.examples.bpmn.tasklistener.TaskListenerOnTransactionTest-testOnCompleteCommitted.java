@Deployment public void testOnCompleteCommitted(){
assertEquals(1,currentTasks.size());
assertEquals("usertask1",currentTasks.get(0).getTaskId());
assertEquals("User Task 1",currentTasks.get(0).getTaskName());
assertEquals(processInstance.getId(),currentTasks.get(0).getProcessInstanceId());
assertNotNull(currentTasks.get(0).getProcessInstanceId());
}