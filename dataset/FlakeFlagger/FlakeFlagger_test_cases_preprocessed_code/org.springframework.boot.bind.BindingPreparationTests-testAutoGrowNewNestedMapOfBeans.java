@Test public void testAutoGrowNewNestedMapOfBeans() throws Exception {
assertNotNull(wrapper.getPropertyValue("nested"));
assertEquals("nested[foo].foo",result);
assertNotNull(wrapper.getPropertyValue("nested[foo]"));
}