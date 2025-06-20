@Test public void assertGetShardingContextWhenHasDisabledItems(){
assertThat(liteJobFacade.getShardingContexts(),is(shardingContexts));
}