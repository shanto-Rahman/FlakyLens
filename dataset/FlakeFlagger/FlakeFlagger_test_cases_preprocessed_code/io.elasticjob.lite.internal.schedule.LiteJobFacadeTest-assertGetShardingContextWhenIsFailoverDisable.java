@Test public void assertGetShardingContextWhenIsFailoverDisable(){
assertThat(liteJobFacade.getShardingContexts(),is(shardingContexts));
}