@Test public void testDeserialize_Array(){
  final int len=10;
  JavaBeanDescriptor descriptor=new JavaBeanDescriptor(int.class.getName(),JavaBeanDescriptor.TYPE_ARRAY);
  for (int i=0; i < len; i++) {
    descriptor.setProperty(i,i);
  }
  Object obj=JavaBeanSerializeUtil.deserialize(descriptor);
  Assertions.assertTrue(obj.getClass().isArray());
  Assertions.assertSame(int.class,obj.getClass().getComponentType());
  for (int i=0; i < len; i++) {
    Assertions.assertEquals(i,Array.get(obj,i));
  }
  descriptor=new JavaBeanDescriptor(int[].class.getName(),JavaBeanDescriptor.TYPE_ARRAY);
  for (int i=0; i < len; i++) {
    JavaBeanDescriptor innerItem=new JavaBeanDescriptor(int.class.getName(),JavaBeanDescriptor.TYPE_ARRAY);
    for (int j=0; j < len; j++) {
      innerItem.setProperty(j,j);
    }
    descriptor.setProperty(i,innerItem);
  }
  obj=JavaBeanSerializeUtil.deserialize(descriptor);
  Assertions.assertTrue(obj.getClass().isArray());
  Assertions.assertEquals(int[].class,obj.getClass().getComponentType());
  for (int i=0; i < len; i++) {
    Object innerItem=Array.get(obj,i);
    Assertions.assertTrue(innerItem.getClass().isArray());
    Assertions.assertEquals(int.class,innerItem.getClass().getComponentType());
    for (int j=0; j < len; j++) {
      Assertions.assertEquals(j,Array.get(innerItem,j));
    }
  }
  descriptor=new JavaBeanDescriptor(BigPerson[].class.getName(),JavaBeanDescriptor.TYPE_ARRAY);
  JavaBeanDescriptor innerDescriptor=new JavaBeanDescriptor(BigPerson.class.getName(),JavaBeanDescriptor.TYPE_ARRAY);
  innerDescriptor.setProperty(0,JavaBeanSerializeUtil.serialize(createBigPerson(),JavaBeanAccessor.METHOD));
  descriptor.setProperty(0,innerDescriptor);
  obj=JavaBeanSerializeUtil.deserialize(descriptor);
  Assertions.assertTrue(obj.getClass().isArray());
  Assertions.assertEquals(BigPerson[].class,obj.getClass().getComponentType());
  Assertions.assertEquals(1,Array.getLength(obj));
  obj=Array.get(obj,0);
  Assertions.assertTrue(obj.getClass().isArray());
  Assertions.assertEquals(BigPerson.class,obj.getClass().getComponentType());
  Assertions.assertEquals(1,Array.getLength(obj));
  Assertions.assertEquals(createBigPerson(),Array.get(obj,0));
}
