@Test public void isSensitiveOverride() throws Exception {
assertThat(getEndpointBean().isSensitive(),equalTo(!this.sensitive));
}