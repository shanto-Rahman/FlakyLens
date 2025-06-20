@Test public void testSize() throws InterruptedException {
Assertions.assertEquals(1,InternalThreadLocal.size(),"size method is wrong!");
Assertions.assertEquals(2,InternalThreadLocal.size(),"size method is wrong!");
}