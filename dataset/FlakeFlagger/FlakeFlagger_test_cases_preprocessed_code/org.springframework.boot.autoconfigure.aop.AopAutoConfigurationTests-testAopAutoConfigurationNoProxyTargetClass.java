@Test public void testAopAutoConfigurationNoProxyTargetClass(){
assertFalse(aspect.isCalled());//IT
bean.foo();//IT
assertTrue(aspect.isCalled());//IT
}