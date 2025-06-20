@Test public void createWithIndicatorsAndAdd() throws Exception {
assertThat(result.getDetails().size(),equalTo(3));
assertThat(result.getDetails(),hasEntry("one",(Object)new Health.Builder().unknown().withDetail("1","1").build()));
assertThat(result.getDetails(),hasEntry("two",(Object)new Health.Builder().unknown().withDetail("2","2").build()));
assertThat(result.getDetails(),hasEntry("three",(Object)new Health.Builder().unknown().withDetail("3","3").build()));
}