@Deployment(resources={"org/activiti/engine/test/api/runtime/RuntimeServiceTest.catchAlertSignal.bpmn20.xml"}) public void testExecutionWaitingForDifferentSignal(){
fail("exception expected");
}