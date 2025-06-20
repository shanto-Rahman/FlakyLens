@Test public void testAppendAttributes1() throws Exception {
TestCase.assertEquals('l',parameters.get("prefix.let"));
TestCase.assertEquals(true,parameters.get("prefix.activate"));
TestCase.assertFalse(parameters.containsKey("prefix.flag"));
}