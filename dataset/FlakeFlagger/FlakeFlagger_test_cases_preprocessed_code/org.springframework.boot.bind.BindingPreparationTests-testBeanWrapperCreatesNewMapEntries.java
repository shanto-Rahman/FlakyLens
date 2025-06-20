@Test public void testBeanWrapperCreatesNewMapEntries() throws Exception {
assertNotNull(wrapper.getPropertyValue("nested"));
assertNotNull(wrapper.getPropertyValue("nested[foo]"));
}