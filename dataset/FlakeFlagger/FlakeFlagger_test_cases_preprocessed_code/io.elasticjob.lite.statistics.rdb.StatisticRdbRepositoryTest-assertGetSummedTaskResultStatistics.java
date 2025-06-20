@Test public void assertGetSummedTaskResultStatistics(){
assertThat(po.getSuccessCount(),is(300));
assertThat(po.getFailedCount(),is(7));
}