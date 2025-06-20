@Test public void testAutoGrowWithFuzzyNameUnderscores() throws Exception {
assertNotNull(wrapper.getPropertyValue("nested"));
assertEquals("nested[foo][bar]",result);
assertNotNull(wrapper.getPropertyValue("nested[foo][bar]"));
}