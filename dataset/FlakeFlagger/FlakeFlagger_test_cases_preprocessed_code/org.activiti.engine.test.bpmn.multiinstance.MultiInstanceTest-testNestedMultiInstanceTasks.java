@Deployment(resources={"org/activiti/engine/test/bpmn/multiinstance/MultiInstanceTest.testNestedMultiInstanceTasks.bpmn20.xml"}) public void testNestedMultiInstanceTasks(){
assertEquals(processes.size() * assignees.size(),tasks.size());
assertEquals(0,processInstances.size());
}