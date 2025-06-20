@Test public void testAutoGrowNewNestedMapOfMaps() throws Exception {
assertNotNull(wrapper.getPropertyValue("nested"));
assertEquals("nested[foo][bar]",result);
assertNotNull(wrapper.getPropertyValue("nested[foo][bar]"));
}