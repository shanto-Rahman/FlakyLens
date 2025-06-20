@Deployment public void testDelegateExpressionWithSingletonBean(){
assertEquals(202,resultServiceTask1.intValue());
assertEquals(579,resultServiceTask2.intValue());
assertEquals(1,SingletonDelegateExpressionBean.INSTANCE_COUNT.get());
}