@Test public void invoke() throws Exception {
assertThat(trace.getInfo().get("a"),equalTo((Object)"b"));
}