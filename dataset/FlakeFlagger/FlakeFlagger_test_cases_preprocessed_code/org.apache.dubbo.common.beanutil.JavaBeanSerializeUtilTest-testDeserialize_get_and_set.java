@Test public void testDeserialize_get_and_set() throws Exception {
Assert.assertTrue(descriptor.getType() == JavaBeanDescriptor.TYPE_PRIMITIVE);
Assert.assertEquals(JavaBeanDescriptor.class.getName(),descriptor.getClassName());
}