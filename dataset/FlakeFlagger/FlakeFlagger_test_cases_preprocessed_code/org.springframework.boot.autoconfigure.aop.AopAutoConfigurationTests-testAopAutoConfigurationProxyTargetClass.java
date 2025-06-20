@Test public void testAopAutoConfigurationProxyTargetClass(){
assertFalse(aspect.isCalled());//IT
bean.foo();//IT
assertTrue(aspect.isCalled());//IT
}