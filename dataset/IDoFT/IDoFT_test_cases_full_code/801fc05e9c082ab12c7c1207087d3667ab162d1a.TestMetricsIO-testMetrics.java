@Test public void testMetrics(){
  MetricsIO metrics=new MetricsIO(new MetricsIOWrapper(){
    @Override public long getChecksumFailures(){
      return 40;
    }
  }
);
  metrics.updateFsReadTime(100);
  metrics.updateFsReadTime(200);
  metrics.updateFsPreadTime(300);
  metrics.updateFsWriteTime(400);
  metrics.updateFsWriteTime(500);
  metrics.updateFsWriteTime(600);
  HELPER.assertCounter("fsChecksumFailureCount",40,metrics.getMetricsSource());
  HELPER.assertCounter("fsReadTime_numOps",2,metrics.getMetricsSource());
  HELPER.assertCounter("fsPReadTime_numOps",1,metrics.getMetricsSource());
  HELPER.assertCounter("fsWriteTime_numOps",3,metrics.getMetricsSource());
}
