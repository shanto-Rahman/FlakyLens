@Test public void test(){
Assert.assertEquals(2,helloServicesMap.size());
Assert.assertEquals(3,serviceBeansMap.size());
Assert.assertEquals(4,beanPostProcessorsMap.size());
Assert.assertTrue(beanPostProcessorsMap.containsKey("doubleServiceAnnotationBeanPostProcessor"));
Assert.assertTrue(beanPostProcessorsMap.containsKey("emptyServiceAnnotationBeanPostProcessor"));
Assert.assertTrue(beanPostProcessorsMap.containsKey("serviceAnnotationBeanPostProcessor"));
Assert.assertTrue(beanPostProcessorsMap.containsKey("serviceAnnotationBeanPostProcessor2"));
}