@Test public void createWithoutAndAdd() throws Exception {
assertThat(result.getDetails().size(),equalTo(2));
assertThat(result.getDetails(),hasEntry("one",(Object)new Health.Builder().unknown().withDetail("1","1").build()));
assertThat(result.getDetails(),hasEntry("two",(Object)new Health.Builder().unknown().withDetail("2","2").build()));
}