@Test public void waitFor(){
  long start=Time.now();
  long waited=waitFor(1000,new Predicate(){
    @Override public boolean evaluate() throws Exception {
      return true;
    }
  }
);
  long end=Time.now();
  assertEquals(waited,0,50);
  assertEquals(end - start - waited,0,50);
}
