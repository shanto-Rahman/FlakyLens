@Test public void assertShardingByDesc(){
assertThat(odevitySortByNameJobShardingStrategy.sharding(Arrays.asList(new JobInstance("host0@-@0"),new JobInstance("host1@-@0"),new JobInstance("host2@-@0")),"0",2),is(expected));
}