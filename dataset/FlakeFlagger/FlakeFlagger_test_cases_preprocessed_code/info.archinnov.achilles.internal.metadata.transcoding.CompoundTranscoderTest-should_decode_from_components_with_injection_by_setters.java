@Test public void should_decode_from_components_with_injection_by_setters() throws Exception {
assertThat(actual).isInstanceOf(EmbeddedKey.class);
assertThat(compound.getUserId()).isEqualTo(userId);
assertThat(compound.getName()).isEqualTo(name);
}