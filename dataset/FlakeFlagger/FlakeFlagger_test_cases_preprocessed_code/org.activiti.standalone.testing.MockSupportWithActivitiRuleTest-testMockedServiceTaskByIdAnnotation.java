@Test @Deployment(resources={"org/activiti/standalone/testing/MockSupportWithActivitiRuleTest.testMockedServiceTaskAnnotation.bpmn20.xml"}) @MockServiceTask(id="serviceTask",mockedClassName="org.activiti.standalone.testing.helpers.ServiceTaskTestMock") public void testMockedServiceTaskByIdAnnotation(){
Assert.assertEquals(0,ServiceTaskTestMock.CALL_COUNT.get());
Assert.assertEquals(1,ServiceTaskTestMock.CALL_COUNT.get());
}