@Deployment public void testParallelUserTasksCompletionCondition(){
assertEquals(5,tasks.size());
assertEquals(5 - i,taskService.createTaskQuery().count());//RW
}