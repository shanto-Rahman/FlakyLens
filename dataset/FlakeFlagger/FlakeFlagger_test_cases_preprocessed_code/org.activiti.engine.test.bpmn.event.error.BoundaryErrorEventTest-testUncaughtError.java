@Deployment(resources={"org/activiti/engine/test/bpmn/event/error/BoundaryErrorEventTest.subprocess.bpmn20.xml"}) public void testUncaughtError(){
assertEquals("Task in subprocess",task.getName());
fail("No catching boundary event found for error with errorCode 'myError', neither in same process nor in parent process but no Exception is thrown");
}