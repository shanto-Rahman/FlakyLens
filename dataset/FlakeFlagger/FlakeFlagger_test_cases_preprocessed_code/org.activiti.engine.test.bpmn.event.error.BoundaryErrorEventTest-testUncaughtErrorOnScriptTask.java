@Deployment(resources={"org/activiti/engine/test/bpmn/event/error/BoundaryErrorEventTest.testUncaughtErrorOnScriptTask.bpmn20.xml"}) public void testUncaughtErrorOnScriptTask(){
fail("The script throws error event with errorCode 'errorUncaught', but no catching boundary event was defined. An exception is expected which did not occur");
}