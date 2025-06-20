@Test @Deployment(resources={"org/activiti/engine/test/bpmn/async/AsyncTaskTest.testAsyncTask.bpmn20.xml"}) public void testWaitForJobs(){
assertEquals(1,managementService.createJobQuery().count());
assertEquals(0,managementService.createJobQuery().count());
}