@Test @Deployment @MockServiceTask(originalClassName="com.yourcompany.delegate",mockedClassName="org.activiti.standalone.testing.helpers.ServiceTaskTestMock") public void testMockedServiceTaskAnnotation(){
Assert.assertEquals(0,ServiceTaskTestMock.CALL_COUNT.get());
Assert.assertEquals(1,ServiceTaskTestMock.CALL_COUNT.get());
}