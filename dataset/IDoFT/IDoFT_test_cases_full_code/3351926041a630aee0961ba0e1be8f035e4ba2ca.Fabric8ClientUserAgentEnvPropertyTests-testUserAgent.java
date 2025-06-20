@Test void testUserAgent(){
  String userAgent=client.getConfiguration().getUserAgent();
  assertThat(userAgent).isEqualTo("spring-k8s");
}
