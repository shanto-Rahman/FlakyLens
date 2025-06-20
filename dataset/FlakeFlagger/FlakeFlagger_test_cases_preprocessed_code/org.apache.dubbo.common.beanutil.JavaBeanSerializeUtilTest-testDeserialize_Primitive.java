@Test public void testDeserialize_Primitive() throws Exception {
Assert.assertEquals(Long.MAX_VALUE,JavaBeanSerializeUtil.deserialize(descriptor));
Assert.assertEquals(Long.MAX_VALUE,descriptor.setPrimitiveProperty(decimal));
Assert.assertEquals(decimal,JavaBeanSerializeUtil.deserialize(descriptor));
Assert.assertEquals(decimal,descriptor.setPrimitiveProperty(string));
Assert.assertEquals(string,JavaBeanSerializeUtil.deserialize(descriptor));
}