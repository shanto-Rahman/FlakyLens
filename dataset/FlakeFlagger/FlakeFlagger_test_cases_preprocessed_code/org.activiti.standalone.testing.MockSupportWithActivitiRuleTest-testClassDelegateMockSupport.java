@Test @Deployment public void testClassDelegateMockSupport(){
Assert.assertEquals(0,ServiceTaskTestMock.CALL_COUNT.get());
Assert.assertEquals(1,ServiceTaskTestMock.CALL_COUNT.get());
}