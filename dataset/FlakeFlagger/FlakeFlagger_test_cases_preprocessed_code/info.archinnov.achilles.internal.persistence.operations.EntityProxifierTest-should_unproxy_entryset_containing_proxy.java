@Test public void should_unproxy_entryset_containing_proxy() throws Exception {
assertThat(actual).isSameAs(entry);
assertThat(actual.getValue()).isSameAs(realProxy);
}