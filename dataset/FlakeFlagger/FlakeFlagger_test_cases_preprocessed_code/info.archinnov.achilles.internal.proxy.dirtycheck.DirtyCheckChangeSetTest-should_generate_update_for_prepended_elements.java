@Test public void should_generate_update_for_prepended_elements() throws Exception {
assertThat((List<Object>)vals[0]).containsExactly("a");
assertThat(conditions.getQueryString()).isEqualTo("UPDATE table SET property=?+property;");
}