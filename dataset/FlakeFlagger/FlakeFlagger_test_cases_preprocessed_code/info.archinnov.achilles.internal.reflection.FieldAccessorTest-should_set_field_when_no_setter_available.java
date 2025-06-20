@Test public void should_set_field_when_no_setter_available() throws Exception {
assertThat(instance.getName()).isEqualTo("new_name");//IT
}