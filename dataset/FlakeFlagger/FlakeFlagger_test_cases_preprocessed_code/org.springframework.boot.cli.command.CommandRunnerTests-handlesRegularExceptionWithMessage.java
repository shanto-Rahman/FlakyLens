@Test public void handlesRegularExceptionWithMessage() throws Exception {
assertThat(status,equalTo(1));
assertThat(this.calls,equalTo((Set<Call>)EnumSet.of(Call.ERROR_MESSAGE)));//RW
}