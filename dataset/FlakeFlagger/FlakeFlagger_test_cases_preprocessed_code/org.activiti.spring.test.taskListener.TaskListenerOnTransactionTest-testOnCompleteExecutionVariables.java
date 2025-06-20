@Deployment public void testOnCompleteExecutionVariables(){
assertEquals(2,currentTasks.size());
assertEquals("usertask1",currentTasks.get(0).getTaskId());
assertEquals("User Task 1",currentTasks.get(0).getTaskName());
assertEquals(1,currentTasks.get(1).getExecutionVariables().size());
assertEquals("test1",currentTasks.get(0).getExecutionVariables().get("injectedExecutionVariable"));
assertEquals("usertask2",currentTasks.get(1).getTaskId());
assertEquals("User Task 2",currentTasks.get(1).getTaskName());
assertEquals(1,currentTasks.get(1).getExecutionVariables().size());
assertEquals("test2",currentTasks.get(1).getExecutionVariables().get("injectedExecutionVariable"));
}