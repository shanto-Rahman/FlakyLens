@Test public void testSerialize_Array() throws Exception {
Assert.assertTrue(descriptor.isArrayType());
Assert.assertEquals(int.class.getName(),descriptor.getClassName());
Assert.assertEquals(array[i],((JavaBeanDescriptor)descriptor.getProperty(i)).getPrimitiveProperty());
Assert.assertTrue(descriptor.isArrayType());
Assert.assertEquals(Integer.class.getName(),descriptor.getClassName());
Assert.assertEquals(integers.length,descriptor.propertySize());
if (integers[i] == null) {
Assert.assertTrue(integers[i] == descriptor.getProperty(i));
Assert.assertEquals(integers[i],((JavaBeanDescriptor)descriptor.getProperty(i)).getPrimitiveProperty());
}
Assert.assertTrue(descriptor.isArrayType());
Assert.assertEquals(int[].class.getName(),descriptor.getClassName());
Assert.assertTrue(item.isArrayType());
Assert.assertEquals(int.class.getName(),item.getClassName());
Assert.assertEquals(second[i][j],((JavaBeanDescriptor)item.getProperty(j)).getPrimitiveProperty());
Assert.assertTrue(descriptor.isArrayType());
Assert.assertEquals(BigPerson.class.getName(),descriptor.getClassName());
}