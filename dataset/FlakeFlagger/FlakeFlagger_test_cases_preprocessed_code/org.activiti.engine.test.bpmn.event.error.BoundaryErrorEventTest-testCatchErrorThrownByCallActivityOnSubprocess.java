@Deployment(resources={"org/activiti/engine/test/bpmn/event/error/BoundaryErrorEventTest.testCatchErrorThrownByCallActivityOnSubprocess.bpmn20.xml","org/activiti/engine/test/bpmn/event/error/BoundaryErrorEventTest.subprocess.bpmn20.xml"}) public void testCatchErrorThrownByCallActivityOnSubprocess(){
assertEquals("Task in subprocess",task.getName());
assertEquals("Escalated Task",task.getName());
}