@Test public void shardingForServersLessThanShardingCountAliquantFor8ShardingCountAnd3Servers(){
assertThat(jobShardingStrategy.sharding(Arrays.asList(new JobInstance("host0@-@0"),new JobInstance("host1@-@0"),new JobInstance("host2@-@0")),"test_job",8),is(expected));
}