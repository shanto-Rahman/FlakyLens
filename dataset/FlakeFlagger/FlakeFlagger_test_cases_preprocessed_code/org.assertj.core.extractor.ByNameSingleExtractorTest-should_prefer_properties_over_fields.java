@Test public void should_prefer_properties_over_fields() throws Exception {
assertThat(extractedValue).isEqualTo(new Name("Overridden Name"));
}