@Test public void should_dsl_select_with_token_value() throws Exception {
assertThat(found).isNotNull();
assertThat(found.getList()).containsExactly("1","2");
assertThat(found.getSet()).containsExactly("1","2");
assertThat(found.getMap()).containsEntry(1,"1");
assertThat(found.getMap()).containsEntry(2,"2");
assertThat(found.getUdt().getId()).isEqualTo(1L);
assertThat(found.getUdt().getValue()).isEqualTo("test");
}