@Deployment public void testMultipleValidConditions(){
assertEquals("Task 2",taskService.createTaskQuery().singleResult().getName());
}