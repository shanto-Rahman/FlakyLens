@Test public void testManagedBean() throws Exception {
Assert.assertNotNull(bean.getSimple());
Assert.assertNotNull(bean.getSimple2());
Assert.assertEquals("#InterceptorFromParent##InterceptorBean##OtherInterceptorBean##CDIInterceptor##BeanParent##BeanWithSimpleInjected#Hello#CDIBean#CDIBean",s);
Assert.assertEquals(100,bean.getNumber());
Assert.assertEquals("value",bean.getValue());
Assert.assertEquals("value",bean.getValue2());
}