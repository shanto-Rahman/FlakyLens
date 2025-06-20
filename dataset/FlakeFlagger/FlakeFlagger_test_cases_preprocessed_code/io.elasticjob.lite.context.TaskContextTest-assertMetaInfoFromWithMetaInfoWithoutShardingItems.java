@Test public void assertMetaInfoFromWithMetaInfoWithoutShardingItems(){
assertThat(actual.getJobName(),is("test_job"));
assertTrue(actual.getShardingItems().isEmpty());
}