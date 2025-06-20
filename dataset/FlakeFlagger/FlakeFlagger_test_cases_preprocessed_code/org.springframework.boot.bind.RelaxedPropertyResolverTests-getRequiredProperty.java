@Test public void getRequiredProperty() throws Exception {
assertThat(this.resolver.getRequiredProperty("my-string"),equalTo("value"));
}