@Test public void should_bind_for_insert_with_null_fields() throws Exception {
assertThat(asList(actual.getValues())).containsExactly(primaryKey,name,null,0);
}