@Test public void testOnRemove(){
Assert.assertTrue("get method false!",internalThreadLocal.get() == 1);
Assert.assertTrue("onRemove method failed!",valueToRemove[0] == 2);
}