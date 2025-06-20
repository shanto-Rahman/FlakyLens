@Test public void should_bind_for_insert_with_simple_id() throws Exception {
assertThat(asList(actual.getValues())).containsExactly(primaryKey,name,age,0);
}