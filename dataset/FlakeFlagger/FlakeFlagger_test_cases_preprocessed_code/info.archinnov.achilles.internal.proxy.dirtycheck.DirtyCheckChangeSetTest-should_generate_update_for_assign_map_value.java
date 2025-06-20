@Test public void should_generate_update_for_assign_map_value() throws Exception {
assertThat((Map<Object,Object>)vals[0]).contains(entry(1,"a"));
assertThat(conditions.getQueryString()).isEqualTo("UPDATE table SET property=?;");
}