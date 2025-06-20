@Test public void testGenericInvokeWithBean(){
Assert.assertFalse(server.isCalled());
Assert.assertTrue(server.isCalled());
Assert.assertEquals("Hello, haha",JavaBeanSerializeUtil.deserialize((JavaBeanDescriptor)result));
}