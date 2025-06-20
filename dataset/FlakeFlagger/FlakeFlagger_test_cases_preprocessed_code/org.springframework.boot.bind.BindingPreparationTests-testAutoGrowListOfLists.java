@Test public void testAutoGrowListOfLists() throws Exception {
assertNotNull(wrapper.getPropertyValue("nested"));
assertNotNull(wrapper.getPropertyValue("nested[0][1]"));
}