@Test public void test(){
Assert.assertEquals("Hello,Mercy",value);
Assert.assertEquals(DemoServiceImpl.class,beanClass);
Assert.assertNotNull(findAnnotation(beanClass,Transactional.class));
Assert.assertEquals("Hello,Mercy",value);
Assert.assertNotNull(demoService);
Assert.assertEquals("Hello,Mercy",value);
Assert.assertNotNull(demoService);
Assert.assertEquals("Hello,Mercy",value);
Assert.assertNotNull(demoService);
Assert.assertEquals("Hello,Mercy",value);
}