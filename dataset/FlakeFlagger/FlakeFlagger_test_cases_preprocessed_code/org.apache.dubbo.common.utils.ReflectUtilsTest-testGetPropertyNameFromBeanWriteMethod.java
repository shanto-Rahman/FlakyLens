@Test public void testGetPropertyNameFromBeanWriteMethod() throws Exception {
assertEquals(ReflectUtils.getPropertyNameFromBeanWriteMethod(method),"property");
}