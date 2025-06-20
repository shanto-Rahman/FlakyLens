@Test public void loadYamlFile() throws Exception {
assertThat(property,equalTo("fromyamlfile"));
assertThat(this.environment.getProperty("my.array[0]"),equalTo("1"));
assertThat(this.environment.getProperty("my.array"),nullValue(String.class));
}