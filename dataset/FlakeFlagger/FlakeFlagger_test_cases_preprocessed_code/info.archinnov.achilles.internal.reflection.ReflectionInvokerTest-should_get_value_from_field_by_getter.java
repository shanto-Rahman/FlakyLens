@Test public void should_get_value_from_field_by_getter() throws Exception {
bean.setComplicatedAttributeName("test");//IT
assertThat(value).isEqualTo("test");
}