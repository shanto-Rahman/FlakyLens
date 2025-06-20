@Deployment(resources="org/activiti/engine/test/bpmn/event/timer/BoundaryTimerNonInterruptingEventTest.testTimerOnConcurrentSubprocess.bpmn20.xml") public void testTimerOnConcurrentSubprocess2(){
assertEquals(4,taskService.createTaskQuery().count());
assertEquals(5,taskService.createTaskQuery().count());
assertEquals(0,taskService.createTaskQuery().count());
}