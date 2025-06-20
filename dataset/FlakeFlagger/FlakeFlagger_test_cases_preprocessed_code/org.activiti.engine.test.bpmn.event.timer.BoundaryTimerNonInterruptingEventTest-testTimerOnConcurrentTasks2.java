@Deployment(resources={"org/activiti/engine/test/bpmn/event/timer/BoundaryTimerNonInterruptingEventTest.testTimerOnConcurrentTasks.bpmn20.xml"}) public void testTimerOnConcurrentTasks2(){
assertEquals(2,taskService.createTaskQuery().count());
assertEquals(3,taskService.createTaskQuery().count());
assertEquals(1,taskService.createTaskQuery().count());
}