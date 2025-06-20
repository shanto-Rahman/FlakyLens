@Test public void testBeanWrapperCreatesNewNestedMaps() throws Exception {
assertNotNull(wrapper.getPropertyValue("nested[foo][0]"));
}