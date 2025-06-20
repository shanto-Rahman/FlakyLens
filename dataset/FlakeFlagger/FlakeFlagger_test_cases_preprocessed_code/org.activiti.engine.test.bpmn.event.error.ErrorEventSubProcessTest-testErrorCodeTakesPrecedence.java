@Deployment public void testErrorCodeTakesPrecedence(){
assertEquals("No tasks found in task list.",1,taskService.createTaskQuery().taskDefinitionKey("taskAfterErrorCatch2").count());
assertEquals("Escalated Task",task.getName());
}