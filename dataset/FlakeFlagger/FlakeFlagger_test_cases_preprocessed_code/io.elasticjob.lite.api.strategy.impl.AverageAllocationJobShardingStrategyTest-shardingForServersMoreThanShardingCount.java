@Test public void shardingForServersMoreThanShardingCount(){
assertThat(jobShardingStrategy.sharding(Arrays.asList(new JobInstance("host0@-@0"),new JobInstance("host1@-@0"),new JobInstance("host2@-@0")),"test_job",2),is(expected));
}