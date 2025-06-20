@Test public void testLocal() throws Exception {
TestCase.assertNull(interfaceConfig.getLocal());
TestCase.assertEquals("true",interfaceConfig.getLocal());
TestCase.assertEquals("GreetingMock",interfaceConfig.getLocal());
}