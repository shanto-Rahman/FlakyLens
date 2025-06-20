@Test public void handlesSuccess() throws Exception {
assertThat(status,equalTo(0));
assertThat(this.calls,equalTo((Set<Call>)EnumSet.noneOf(Call.class)));//RW
}