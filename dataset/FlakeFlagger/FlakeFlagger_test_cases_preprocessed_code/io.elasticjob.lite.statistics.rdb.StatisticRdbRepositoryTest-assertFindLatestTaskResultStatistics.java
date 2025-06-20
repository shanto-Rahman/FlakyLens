@Test public void assertFindLatestTaskResultStatistics(){
assertThat(po.get().getSuccessCount(),is(200));
assertThat(po.get().getFailedCount(),is(5));
}