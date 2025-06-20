@Test void extensionSerialize() throws IOException {
assertThat(actual).isEqualTo(MappingUtils.read(new ClassPathResource("extension.json",getClass())));
}