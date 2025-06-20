@Deployment public void testChangeCategoryInDelegateTask(){
assertEquals("approval",task.getCategory());
assertEquals(0,taskService.createTaskQuery().processInstanceId(processInstance.getId()).count());
assertEquals("approved",historicTaskInstance.getCategory());
}