@Test public void testSlowAppend() throws Exception {
  MetricsWALSource source=new MetricsWALSourceImpl();
  MetricsWAL metricsWAL=new MetricsWAL(source);
  metricsWAL.postAppend(1,900,null,null);
  metricsWAL.postAppend(1,1010,null,null);
  metricsWAL.postAppend(1,2000,null,null);
  assertEquals(2,source.getSlowAppendCount());
}
