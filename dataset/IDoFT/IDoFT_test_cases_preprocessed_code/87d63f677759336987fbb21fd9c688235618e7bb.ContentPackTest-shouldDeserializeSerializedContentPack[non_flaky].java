@Test public void shouldDeserializeSerializedContentPack() throws Exception {
assertThat(readContentPack.id()).isEqualTo(contentPack.id());
assertThat(readContentPack.version()).isEqualTo(contentPack.version());
assertThat(readContentPack.revision()).isEqualTo(contentPack.revision());
}