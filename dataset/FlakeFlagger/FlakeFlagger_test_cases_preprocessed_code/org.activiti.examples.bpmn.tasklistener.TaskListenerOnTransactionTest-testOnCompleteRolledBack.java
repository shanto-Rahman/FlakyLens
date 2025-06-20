@Deployment public void testOnCompleteRolledBack(){
assertEquals(2,currentTasks.size());
assertEquals("usertask1",currentTasks.get(0).getTaskId());
assertEquals("User Task 1",currentTasks.get(0).getTaskName());
assertEquals(processInstance.getId(),currentTasks.get(0).getProcessInstanceId());
assertNotNull(currentTasks.get(0).getProcessInstanceId());
assertEquals("usertask3",currentTasks.get(1).getTaskId());
assertEquals("User Task 3",currentTasks.get(1).getTaskName());
assertEquals(processInstance.getId(),currentTasks.get(1).getProcessInstanceId());
assertNotNull(currentTasks.get(1).getProcessInstanceId());
}