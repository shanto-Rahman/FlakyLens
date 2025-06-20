@Deployment(resources={"org/activiti/engine/test/bpmn/event/error/BoundaryErrorEventTest.testCatchErrorOnCallActivity-parent.bpmn20.xml","org/activiti/engine/test/bpmn/event/error/BoundaryErrorEventTest.subprocess.bpmn20.xml"}) public void testCatchErrorOnCallActivity(){
assertEquals("Task in subprocess",task.getName());
assertEquals("Escalated Task",task.getName());
}