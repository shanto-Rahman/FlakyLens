@Test public void should_generate_update_for_added_elements() throws Exception {
assertThat((Set<Object>)vals[0]).containsExactly("a");
assertThat(conditions.getQueryString()).isEqualTo("UPDATE table SET property=property+?;");
}