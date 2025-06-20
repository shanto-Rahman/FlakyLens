@Test public void test() throws Exception {
new Thread(){
  @Override public void run(){
    getResultRef.set(pending.get());
  }
}
.start();
getResultRef.set(pending.get());
Thread.sleep(100);
Assert.assertNull(getResultRef.get());
Thread.sleep(100);
Assert.assertEquals("abc",getResultRef.get());
}