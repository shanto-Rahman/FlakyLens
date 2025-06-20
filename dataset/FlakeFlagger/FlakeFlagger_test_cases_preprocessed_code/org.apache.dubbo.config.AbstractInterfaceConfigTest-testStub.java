@Test public void testStub() throws Exception {
TestCase.assertNull(interfaceConfig.getStub());
TestCase.assertEquals("true",interfaceConfig.getStub());
TestCase.assertEquals("GreetingMock",interfaceConfig.getStub());
}