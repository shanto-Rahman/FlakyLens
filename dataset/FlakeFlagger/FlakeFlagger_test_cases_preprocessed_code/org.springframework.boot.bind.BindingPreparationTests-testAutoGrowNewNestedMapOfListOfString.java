@Test public void testAutoGrowNewNestedMapOfListOfString() throws Exception {
assertNotNull(wrapper.getPropertyValue("nested"));
assertNotNull(wrapper.getPropertyValue("nested[foo]"));
}