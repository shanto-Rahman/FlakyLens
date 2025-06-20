@Test public void testGenericInvokeWithBeanSerialization() throws Exception {
Assert.assertTrue(result instanceof JavaBeanDescriptor);
Assert.assertTrue(descriptor.isCollectionType());
Assert.assertEquals(1,descriptor.propertySize());
Assert.assertTrue(descriptor.isBeanType());
Assert.assertEquals(user.getName(),((JavaBeanDescriptor)descriptor.getProperty("name")).getPrimitiveProperty());
if (reference != null) {
}
}