@Test @SuppressWarnings("unchecked") public void testSerializeJavaBeanDescriptor() throws Exception {
Assert.assertTrue(descriptor == result);
Assert.assertTrue(result.isMapType());
Assert.assertEquals(HashMap.class.getName(),result.getClassName());
Assert.assertEquals(map.size(),result.propertySize());
Assert.assertTrue(object instanceof JavaBeanDescriptor);
Assert.assertEquals(map.get("first"),actual);
}