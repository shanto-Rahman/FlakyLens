@Test public void testSize() throws InterruptedException {
  final InternalThreadLocal<Integer> internalThreadLocal=new InternalThreadLocal<Integer>();
  internalThreadLocal.set(1);
  Assertions.assertEquals(1,InternalThreadLocal.size(),"size method is wrong!");
  final InternalThreadLocal<String> internalThreadLocalString=new InternalThreadLocal<String>();
  internalThreadLocalString.set("value");
  Assertions.assertEquals(2,InternalThreadLocal.size(),"size method is wrong!");
  InternalThreadLocal.removeAll();
}
