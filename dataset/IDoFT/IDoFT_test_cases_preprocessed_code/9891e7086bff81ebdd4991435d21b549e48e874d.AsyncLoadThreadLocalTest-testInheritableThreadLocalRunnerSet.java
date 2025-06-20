@Test public void testInheritableThreadLocalRunnerSet(){
inheritableThreadLocal.set(name);
Assert.assertEquals(inheritableThreadLocal.get(),name);
}