@Test public void testMultiple(){
Assert.assertEquals("dubbo-demo-application",applicationConfig.getName());
Assert.assertEquals("dubbo-demo-application2",applicationBean2.getName());
Assert.assertEquals("dubbo-demo-application3",applicationBean3.getName());
}