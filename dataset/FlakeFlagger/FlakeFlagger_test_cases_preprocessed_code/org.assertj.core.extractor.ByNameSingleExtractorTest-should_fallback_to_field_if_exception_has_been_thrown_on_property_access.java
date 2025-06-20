@Test public void should_fallback_to_field_if_exception_has_been_thrown_on_property_access() throws Exception {
assertThat(extractedValue).isEqualTo(new Name("Name"));
}