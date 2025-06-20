@Test public void testRemove(){
Assert.assertTrue("get method false!",internalThreadLocal.get() == 1);
Assert.assertTrue("remove failed!",internalThreadLocal.get() == null);
}