@Test public void test() throws Exception {
assertThat(status.getLevel(),anyOf(is(OK),is(WARN)));
}