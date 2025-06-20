@Test public void should_get_real_object_from_proxy() throws Exception {
assertThat(actual).isSameAs(realObject);
}