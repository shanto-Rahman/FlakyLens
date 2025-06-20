@Test public void testBeanWrapperCreatesNewObjects() throws Exception {
assertNotNull(wrapper.getPropertyValue("nested"));
}