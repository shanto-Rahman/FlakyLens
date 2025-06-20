@Test public void handlesRegularExceptionWithoutMessage() throws Exception {
assertThat(status,equalTo(1));
assertThat(this.calls,equalTo((Set<Call>)EnumSet.of(Call.ERROR_MESSAGE,Call.PRINT_STACK_TRACE)));//RW
}