@Test public void testSize() throws InterruptedException {
Assert.assertTrue("size method is wrong!",InternalThreadLocal.size() == 1);
Assert.assertTrue("size method is wrong!",InternalThreadLocal.size() == 2);
}