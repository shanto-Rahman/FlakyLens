@Test public void assertGetShardingInfo(){
assertThat(each.getItem(),is(i - 1));
assertThat(each.getStatus(),is(ShardingInfo.ShardingStatus.RUNNING));
assertThat(each.getServerIp(),is("ip1"));
assertThat(each.getInstanceId(),is("1234"));
assertTrue(each.isFailover());
assertThat(each.getStatus(),is(ShardingInfo.ShardingStatus.SHARDING_FLAG));
assertThat(each.getServerIp(),is("ip2"));
assertThat(each.getInstanceId(),is("2341"));
assertThat(each.getStatus(),Is.is(ShardingInfo.ShardingStatus.DISABLED));
assertThat(each.getServerIp(),is("ip3"));
assertThat(each.getInstanceId(),is("3412"));
assertThat(each.getStatus(),Is.is(ShardingInfo.ShardingStatus.PENDING));
assertThat(each.getServerIp(),is("ip4"));
assertThat(each.getInstanceId(),is("4123"));
}