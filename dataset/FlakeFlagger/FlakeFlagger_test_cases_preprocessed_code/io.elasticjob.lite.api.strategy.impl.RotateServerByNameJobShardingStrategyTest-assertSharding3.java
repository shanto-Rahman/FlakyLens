@Test public void assertSharding3(){
assertThat(rotateServerByNameJobShardingStrategy.sharding(Arrays.asList(new JobInstance("host0@-@0"),new JobInstance("host1@-@0"),new JobInstance("host2@-@0")),"3",2),is(expected));
}