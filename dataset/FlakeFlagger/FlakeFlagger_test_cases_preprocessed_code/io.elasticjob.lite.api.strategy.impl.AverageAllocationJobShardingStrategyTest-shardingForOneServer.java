@Test public void shardingForOneServer(){
assertThat(jobShardingStrategy.sharding(Collections.singletonList(new JobInstance("host0@-@0")),"test_job",3),is(expected));
}