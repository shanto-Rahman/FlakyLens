@Test public void testAutoGrowNewNestedMapOfBeansWithPeriod() throws Exception {
assertNotNull(wrapper.getPropertyValue("nested"));
assertEquals("nested[foo].foo",result);
}