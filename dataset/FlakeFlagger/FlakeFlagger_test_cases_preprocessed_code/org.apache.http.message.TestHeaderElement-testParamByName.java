@Test public void testParamByName() throws Exception {
Assert.assertEquals("value1",element.getParameterByName("param1").getValue());
Assert.assertEquals("value2",element.getParameterByName("param2").getValue());
Assert.assertNull(element.getParameterByName("param3"));
Assert.fail("IllegalArgumentException should have been thrown");
}