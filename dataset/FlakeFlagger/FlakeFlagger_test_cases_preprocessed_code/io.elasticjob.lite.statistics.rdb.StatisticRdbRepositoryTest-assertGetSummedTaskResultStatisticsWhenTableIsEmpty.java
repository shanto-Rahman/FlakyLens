@Test public void assertGetSummedTaskResultStatisticsWhenTableIsEmpty(){
assertThat(po.getSuccessCount(),is(0));
assertThat(po.getFailedCount(),is(0));
}