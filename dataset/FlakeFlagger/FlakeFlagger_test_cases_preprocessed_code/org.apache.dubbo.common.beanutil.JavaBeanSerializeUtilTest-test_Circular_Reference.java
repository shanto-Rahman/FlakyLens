@Test public void test_Circular_Reference() throws Exception {
Assert.assertTrue(descriptor.isBeanType());
Assert.assertTrue(descriptor == childDescriptor.getProperty("parent"));
}