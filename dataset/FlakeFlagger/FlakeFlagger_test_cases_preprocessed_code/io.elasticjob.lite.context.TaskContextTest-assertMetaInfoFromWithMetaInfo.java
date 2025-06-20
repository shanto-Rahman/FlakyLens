@Test public void assertMetaInfoFromWithMetaInfo(){
assertThat(actual.getJobName(),is("test_job"));
assertThat(actual.getShardingItems().get(0),is(1));
}