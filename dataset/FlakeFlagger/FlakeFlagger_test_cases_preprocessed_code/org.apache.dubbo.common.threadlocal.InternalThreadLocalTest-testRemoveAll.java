@Test public void testRemoveAll() throws InterruptedException {
Assert.assertTrue("set failed",internalThreadLocal.get() == 1);
Assert.assertTrue("set failed","value".equals(internalThreadLocalString.get()));
Assert.assertTrue("removeAll failed!",internalThreadLocal.get() == null);
Assert.assertTrue("removeAll failed!",internalThreadLocalString.get() == null);
}