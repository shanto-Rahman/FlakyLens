@Deployment(resources={"org/activiti/engine/test/bpmn/event/error/BoundaryErrorEventTest.testCatchErrorThrownByCallActivityOnCallActivity.bpmn20.xml","org/activiti/engine/test/bpmn/event/error/BoundaryErrorEventTest.subprocess2ndLevel.bpmn20.xml","org/activiti/engine/test/bpmn/event/error/BoundaryErrorEventTest.subprocess.bpmn20.xml"}) public void testCatchErrorThrownByCallActivityOnCallActivity() throws InterruptedException {
assertEquals("Task in subprocess",task.getName());
assertEquals("Escalated Task",task.getName());
}