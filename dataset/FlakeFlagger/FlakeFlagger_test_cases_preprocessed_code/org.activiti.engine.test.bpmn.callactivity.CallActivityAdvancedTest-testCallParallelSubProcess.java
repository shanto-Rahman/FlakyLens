@Deployment(resources={"org/activiti/engine/test/bpmn/callactivity/CallActivity.testCallParallelSubProcess.bpmn20.xml","org/activiti/engine/test/bpmn/callactivity/simpleParallelSubProcess.bpmn20.xml"}) public void testCallParallelSubProcess(){
assertEquals(2,tasks.size());
assertEquals("Task A",taskA.getName());
assertEquals("Task B",taskB.getName());
assertEquals(1,taskQuery.list().size());
assertEquals(0,runtimeService.createExecutionQuery().count());
}