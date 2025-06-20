@Test public void testAutoGrowListOfMaps() throws Exception {
assertNotNull(wrapper.getPropertyValue("nested"));
assertNotNull(wrapper.getPropertyValue("nested[0]"));
}