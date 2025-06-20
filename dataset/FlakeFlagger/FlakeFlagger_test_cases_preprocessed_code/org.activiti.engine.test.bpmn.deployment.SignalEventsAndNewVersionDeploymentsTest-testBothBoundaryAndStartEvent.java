public void testBothBoundaryAndStartEvent(){
assertEquals(0,runtimeService.createExecutionQuery().count());
assertEquals(2,runtimeService.createProcessInstanceQuery().count());
assertEquals(3,getAllEventSubscriptions().size());
assertEquals(2,runtimeService.createProcessInstanceQuery().count());
assertEquals(3,runtimeService.createProcessInstanceQuery().count());
assertEquals(2,runtimeService.createProcessInstanceQuery().count());
assertEquals(2,taskService.createTaskQuery().taskName("Task after boundary signal").list().size());
assertEquals(3,runtimeService.createProcessInstanceQuery().count());
}