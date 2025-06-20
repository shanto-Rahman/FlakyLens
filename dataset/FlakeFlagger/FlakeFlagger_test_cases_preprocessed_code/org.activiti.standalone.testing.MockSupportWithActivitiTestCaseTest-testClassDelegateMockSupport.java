@Deployment public void testClassDelegateMockSupport(){
assertEquals(0,ServiceTaskTestMock.CALL_COUNT.get());
assertEquals(1,ServiceTaskTestMock.CALL_COUNT.get());
}