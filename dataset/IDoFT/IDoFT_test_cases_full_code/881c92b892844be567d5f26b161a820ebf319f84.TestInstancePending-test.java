@Test public void test() throws Exception {
  final InstancePending<String> pending=new InstancePending<>();
  final AtomicReference<String> getResultRef=new AtomicReference<>();
  new Thread(){
    @Override public void run(){
      getResultRef.set(pending.get());
    }
  }
.start();
  Thread.sleep(100);
  Assert.assertNull(getResultRef.get());
  pending.prepare("abc");
  Thread.sleep(100);
  Assert.assertEquals("abc",getResultRef.get());
}
