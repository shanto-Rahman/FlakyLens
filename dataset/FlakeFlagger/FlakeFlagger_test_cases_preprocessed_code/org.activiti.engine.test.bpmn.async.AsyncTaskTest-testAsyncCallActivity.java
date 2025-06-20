@Deployment(resources={"org/activiti/engine/test/bpmn/async/AsyncTaskTest.testAsyncCallActivity.bpmn20.xml","org/activiti/engine/test/bpmn/async/AsyncTaskTest.testAsyncServiceNoListeners.bpmn20.xml"}) public void testAsyncCallActivity() throws Exception {
assertEquals(1,managementService.createJobQuery().count());
assertEquals(0,managementService.createJobQuery().count());
assertEquals(0,runtimeService.createProcessInstanceQuery().count());
}