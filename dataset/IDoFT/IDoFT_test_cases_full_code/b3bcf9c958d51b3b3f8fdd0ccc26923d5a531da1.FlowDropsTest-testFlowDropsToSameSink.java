@Test public void testFlowDropsToSameSink(){
  saveOneLikeToCounterWork();
  saveOneLikeToCounterWork();
  new AppengineDriver().pipes().flowDrops();
  awaitAsync(10,TimeUnit.SECONDS);
  Counter counter=id(Counter.class,1l).fetch();
  assertEquals(2,counter.getCount());
  assertEquals(0,yawp(Work.class).ids().size());
}
