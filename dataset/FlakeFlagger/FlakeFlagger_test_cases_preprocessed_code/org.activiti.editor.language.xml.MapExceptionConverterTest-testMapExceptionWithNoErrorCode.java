@Test public void testMapExceptionWithNoErrorCode() throws Exception {
fail("No exception is thrown for mapExecution with no Error Code");
assertTrue(x.getMessage().indexOf("No errorCode defined") != -1);
fail("wrong exception thrown. XmlException expected, " + e.getClass() + " thrown");
}