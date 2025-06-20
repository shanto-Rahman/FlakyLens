@Test public void testAppendAttributes2() throws Exception {
TestCase.assertEquals('l',parameters.get("let"));
TestCase.assertEquals(true,parameters.get("activate"));
TestCase.assertFalse(parameters.containsKey("flag"));
}