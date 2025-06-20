@Test public void waitForTimeOutRatio2(){
  setWaitForRatio(2);
  long start=Time.now();
  long waited=waitFor(200,new Predicate(){
    @Override public boolean evaluate() throws Exception {
      return false;
    }
  }
);
  long end=Time.now();
  assertEquals(waited,-1);
  assertEquals(end - start,200 * getWaitForRatio(),50 * getWaitForRatio());
}
