@Test public void resetTest(){
assertEquals("valA",context.getProperty("keyA"));
assertEquals("valA",context.getObject("keyA"));
assertSame(component,lifeCycleManager.getLastComponent());
assertNull(context.getProperty("keyA"));
assertNull(context.getObject("keyA"));
assertTrue(lifeCycleManager.isReset());//IT
}