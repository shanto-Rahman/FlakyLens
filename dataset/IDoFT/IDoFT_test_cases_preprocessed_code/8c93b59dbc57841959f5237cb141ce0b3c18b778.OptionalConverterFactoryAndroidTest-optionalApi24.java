@Config(sdk=24) @Test public void optionalApi24() throws IOException {
assertThat(optional).isNotNull();
assertThat(optional.get()).isSameAs(ObjectInstanceConverterFactory.VALUE);
}