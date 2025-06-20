@Test public void handlesExceptionWithDashDashDebug() throws Exception {
assertEquals("true",System.getProperty("debug"));
assertThat(status,equalTo(1));
assertThat(this.calls,equalTo((Set<Call>)EnumSet.of(Call.ERROR_MESSAGE,Call.PRINT_STACK_TRACE)));//RW
}