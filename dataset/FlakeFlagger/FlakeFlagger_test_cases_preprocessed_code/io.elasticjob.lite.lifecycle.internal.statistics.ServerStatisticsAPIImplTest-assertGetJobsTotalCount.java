@Test public void assertGetJobsTotalCount(){
assertThat(serverStatisticsAPI.getServersTotalCount(),is(3));
}