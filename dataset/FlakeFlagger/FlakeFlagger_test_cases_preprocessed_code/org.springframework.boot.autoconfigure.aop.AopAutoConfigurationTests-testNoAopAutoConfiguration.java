@Test public void testNoAopAutoConfiguration(){
assertFalse(aspect.isCalled());//IT
bean.foo();//IT
assertFalse(aspect.isCalled());//IT
}