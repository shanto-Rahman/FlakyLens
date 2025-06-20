@Test public void should_force_decode_from_json_to_type() throws Exception {
assertThat(pm.forceDecodeFromJSON("test",String.class)).isEqualTo("test");
}