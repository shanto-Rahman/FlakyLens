@Test public void should_return_object_when_get_real_object_called_on_non_proxified_entity() throws Exception {
assertThat(actual).isSameAs(realObject);
}