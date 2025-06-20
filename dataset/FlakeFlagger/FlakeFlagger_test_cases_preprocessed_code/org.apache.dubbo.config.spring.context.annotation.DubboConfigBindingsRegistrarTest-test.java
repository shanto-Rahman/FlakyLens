@Test public void test(){
Assert.assertEquals("dubbo-demo-application",applicationConfig.getName());
Assert.assertEquals(2,context.getBeansOfType(ApplicationConfig.class).size());
}