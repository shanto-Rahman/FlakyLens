@Test public void test_breadcrumbDispatcher_under_load() throws Exception {
  final BreadcrumbDispatcher<SampleDomainClass> aggregatingDispatcher=new AggregatingBreadcrumbDispatcher<>(bucketDuration,DatumUtils.getDatumTimestampExtractor(SampleDomainClass.class),new StartTimeWithDurationBreadcrumbBaker("","","","","",""),hitCountUpdater,Duration.standardDays(1));
  doBenchmark(new PeriodicBreadcrumbDispatcher<>(aggregatingDispatcher,scheduledExecutorService,durationBetweenFlushes));
}
