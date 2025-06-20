@Test public void testRegisterBeanDefinitionsForMultiple(){
Assert.assertEquals("dubbo-demo-application",applicationConfig.getName());
Assert.assertEquals("dubbo-demo-application2",applicationConfig.getName());
Assert.assertEquals("dubbo-demo-application3",applicationConfig.getName());
}