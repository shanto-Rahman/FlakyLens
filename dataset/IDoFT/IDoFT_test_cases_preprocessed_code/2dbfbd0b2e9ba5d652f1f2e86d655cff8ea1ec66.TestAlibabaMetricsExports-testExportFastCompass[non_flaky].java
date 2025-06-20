@Test public void testExportFastCompass(){
if (i % 2 == 0) {
}
Assert.assertEquals(1,samples.size());
Assert.assertEquals("prom_test_fastcompass_bucket_count",samples.get(0).name);
Assert.assertEquals("should contain success/failure count and sum",4,samples.get(0).samples.size());
Assert.assertEquals("prom_test_fastcompass_bucket_count",samples.get(0).samples.get(0).name);
Assert.assertEquals("success count",5,samples.get(0).samples.get(0).value,0.0001d);
Assert.assertEquals("failure count",5,samples.get(0).samples.get(1).value,0.0001d);
Assert.assertTrue("success sum",successSum == (int)samples.get(0).samples.get(2).value || successSum == (int)samples.get(0).samples.get(3).value);
Assert.assertTrue("failure sum",failureSum == (int)samples.get(0).samples.get(2).value || failureSum == (int)samples.get(0).samples.get(3).value);
}