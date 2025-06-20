@Test public void testMapExceptionWithInvalidHasChildren() throws Exception {
fail("No exception is thrown for mapExecution with invalid boolean for hasChildren");
assertTrue(x.getMessage().indexOf("is not valid boolean") != -1);
fail("wrong exception thrown. XmlException expected, " + e.getClass() + " thrown");
}