@Test @Deployment(resources={"org/activiti/engine/test/api/mgmt/ManagementServiceTest.testGetJobExceptionStacktrace.bpmn20.xml"}) public void testQueryByExceptionWithRealJobExecutor(){
Assert.assertEquals(0,query.count());
Assert.assertEquals(1,query.count());
}