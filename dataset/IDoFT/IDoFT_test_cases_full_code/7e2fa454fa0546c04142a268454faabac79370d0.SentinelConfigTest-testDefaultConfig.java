@Test public void testDefaultConfig(){
  assertEquals(SentinelConfig.DEFAULT_CHARSET,SentinelConfig.charset());
  assertEquals(SentinelConfig.DEFAULT_SINGLE_METRIC_FILE_SIZE,SentinelConfig.singleMetricFileSize());
  assertEquals(SentinelConfig.DEFAULT_TOTAL_METRIC_FILE_COUNT,SentinelConfig.totalMetricFileCount());
  assertEquals(SentinelConfig.DEFAULT_COLD_FACTOR,SentinelConfig.coldFactor());
  assertEquals(SentinelConfig.DEFAULT_STATISTIC_MAX_RT,SentinelConfig.statisticMaxRt());
}
