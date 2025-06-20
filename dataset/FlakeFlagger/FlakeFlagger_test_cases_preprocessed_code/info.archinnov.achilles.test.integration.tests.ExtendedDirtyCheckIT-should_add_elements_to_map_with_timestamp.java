@Test public void should_add_elements_to_map_with_timestamp() throws Exception {
assertThat(bean.getPreferences()).hasSize(3).contains(entry(1,"FR"),entry(2,"Paris"),entry(3,"75014"));
}