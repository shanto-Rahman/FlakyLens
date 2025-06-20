@Test public void should_get_value_from_field() throws Exception {
bean.setComplicatedAttributeName("test");//IT
assertThat(value).isEqualTo("test");
}