@Test public void should_get_inherited_fields() throws Exception {
assertThat(fields).hasSize(4);
assertThat(fields.get(0).getName()).isEqualTo("nickname");
assertThat(fields.get(1).getName()).isEqualTo("name");
assertThat(fields.get(2).getName()).isEqualTo("address");
assertThat(fields.get(3).getName()).isEqualTo("id");
}