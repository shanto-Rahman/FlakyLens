@Test public void testGenericImplementationWithBeanSerialization() throws Exception {
if ("getUsers".equals(method)) {
reference.set(arg);
}
if ("sayName".equals(method)) {
}
Assert.assertEquals(users.size(),result.size());
Assert.assertEquals(user.getName(),result.get(0).getName());
GenericParameter gp=(GenericParameter)reference.get();
Assert.assertEquals("getUsers",gp.method);
Assert.assertEquals(1,gp.parameterTypes.length);
Assert.assertEquals(ReflectUtils.getName(List.class),gp.parameterTypes[0]);
Assert.assertEquals(1,gp.arguments.length);
Assert.assertTrue(gp.arguments[0] instanceof JavaBeanDescriptor);
Assert.assertTrue(descriptor.isCollectionType());
Assert.assertEquals(ArrayList.class.getName(),descriptor.getClassName());
Assert.assertEquals(1,descriptor.propertySize());
Assert.assertTrue(descriptor.isBeanType());
Assert.assertEquals(User.class.getName(),descriptor.getClassName());
Assert.assertEquals(user.getName(),((JavaBeanDescriptor)descriptor.getProperty("name")).getPrimitiveProperty());
Assert.assertNull(demoService.sayName("zhangsan"));
if (ref != null) {
}
}