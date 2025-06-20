@Test public void waitForTimeOutRatio1(){
  setWaitForRatio(1);
  long start=Time.now();
  long waited=waitFor(200,new Predicate(){
    @Override public boolean evaluate() throws Exception {
      return false;
    }
  }
);
  long end=Time.now();
  assertEquals(waited,-1);
  assertEquals(end - start,200,50);
}
