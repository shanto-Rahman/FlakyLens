@Test public void testExportFastCompass(){
  AlibabaMetricsExports exports=new AlibabaMetricsExports(clock);
  FastCompass fc=new FastCompassImpl(1,5,clock,5);
  MetricManager.getIMetricManager().register("test",MetricName.build("prom.test.fastcompass").level(MetricLevel.CRITICAL),fc);
  int successSum=0;
  int failureSum=0;
  for (int i=0; i < 10; i++) {
    int value=(int)(1000 * Math.random());
    if (i % 2 == 0) {
      fc.record(value,"success");
      successSum+=value;
    }
 else {
      fc.record(value,"failure");
      failureSum+=value;
    }
  }
  clock.addSeconds(1);
  List<Collector.MetricFamilySamples> samples=exports.collect();
  Assert.assertEquals(1,samples.size());
  Assert.assertEquals("prom_test_fastcompass_bucket_count",samples.get(0).name);
  Assert.assertEquals("should contain success/failure count and sum",4,samples.get(0).samples.size());
  Assert.assertEquals("prom_test_fastcompass_bucket_count",samples.get(0).samples.get(0).name);
  Assert.assertEquals("success count",5,samples.get(0).samples.get(0).value,0.0001d);
  Assert.assertEquals("failure count",5,samples.get(0).samples.get(1).value,0.0001d);
  Assert.assertTrue("success sum",successSum == (int)samples.get(0).samples.get(2).value || successSum == (int)samples.get(0).samples.get(3).value);
  Assert.assertTrue("failure sum",failureSum == (int)samples.get(0).samples.get(2).value || failureSum == (int)samples.get(0).samples.get(3).value);
}
