@Test public void testBeanWrapperLists() throws Exception {
assertTrue(descriptor.isMap());
assertNotNull(wrapper.getPropertyValue("nested"));
assertNotNull(wrapper.getPropertyValue("nested[foo]"));
}