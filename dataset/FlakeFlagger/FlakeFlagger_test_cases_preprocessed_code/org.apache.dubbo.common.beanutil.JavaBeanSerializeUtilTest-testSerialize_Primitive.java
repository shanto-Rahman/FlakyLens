@Test public void testSerialize_Primitive() throws Exception {
Assert.assertTrue(descriptor.isPrimitiveType());
Assert.assertEquals(Integer.MAX_VALUE,descriptor.getPrimitiveProperty());
Assert.assertTrue(descriptor.isPrimitiveType());
Assert.assertEquals(now,descriptor.getPrimitiveProperty());
}