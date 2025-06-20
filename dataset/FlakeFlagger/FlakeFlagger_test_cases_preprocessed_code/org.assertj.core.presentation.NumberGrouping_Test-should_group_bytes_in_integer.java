@Test public void should_group_bytes_in_integer() throws Exception {
assertThat(literals).isEqualTo("00000000_00000000_00000000_00000011");
}