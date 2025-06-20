@SuppressWarnings({"unchecked","rawtypes"}) @Test public void should_get_inherited_field_by_annotation_and_name() throws Exception {
assertThat(address.getName()).isEqualTo("address");
assertThat(address.getType()).isEqualTo((Class)String.class);
}