@Deployment(resources={"org/activiti/engine/test/bpmn/async/AsyncTaskTest.testBasicAsyncCallActivity.bpmn20.xml","org/activiti/engine/test/bpmn/StartToEndTest.testStartToEnd.bpmn20.xml"}) public void testBasicAsyncCallActivity(){
Assert.assertEquals("There should be one job available.",1,managementService.createJobQuery().count());
assertEquals(0,managementService.createJobQuery().count());
}