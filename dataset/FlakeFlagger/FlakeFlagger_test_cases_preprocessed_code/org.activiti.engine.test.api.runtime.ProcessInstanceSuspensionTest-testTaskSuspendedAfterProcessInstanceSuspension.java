@Deployment(resources={"org/activiti/engine/test/api/runtime/oneTaskProcess.bpmn20.xml"}) public void testTaskSuspendedAfterProcessInstanceSuspension(){
assertTrue(task.isSuspended());
assertFalse(task.isSuspended());
}