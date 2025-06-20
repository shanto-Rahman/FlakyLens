@Deployment public void testDelegateExpressionWithPrototypeBean(){
assertEquals(202,resultServiceTask1.intValue());
assertEquals(579,resultServiceTask2.intValue());
assertEquals(2,PrototypeDelegateExpressionBean.INSTANCE_COUNT.get());
}