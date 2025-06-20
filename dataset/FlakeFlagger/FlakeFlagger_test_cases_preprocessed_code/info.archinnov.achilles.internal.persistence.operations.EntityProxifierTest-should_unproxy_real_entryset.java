@Test public void should_unproxy_real_entryset() throws Exception {
assertThat(actual).isSameAs(entry);
assertThat(actual.getValue()).isSameAs(completeBean);
}