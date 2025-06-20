@Test public void testToken() throws Exception {
assertThat(serviceConfig.getToken(),equalTo("token"));
assertThat(serviceConfig.getToken(),nullValue());
assertThat(serviceConfig.getToken(),is("true"));
}