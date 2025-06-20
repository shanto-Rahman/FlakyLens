@Test public void testGetPropertyNameFromBeanReadMethod() throws Exception {
assertEquals(ReflectUtils.getPropertyNameFromBeanReadMethod(method),"property");
assertEquals(ReflectUtils.getPropertyNameFromBeanReadMethod(method),"set");
}