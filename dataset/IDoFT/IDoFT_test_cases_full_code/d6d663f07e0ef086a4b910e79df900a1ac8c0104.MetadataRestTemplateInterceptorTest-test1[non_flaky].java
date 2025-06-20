@Test public void test1() throws JsonProcessingException {
  HttpHeaders httpHeaders=new HttpHeaders();
  httpHeaders.set(MetadataConstant.HeaderName.CUSTOM_METADATA,"{\"a\":\"11\",\"b\":\"22\",\"c\":\"33\"}");
  HttpEntity<String> httpEntity=new HttpEntity<>(httpHeaders);
  String metadata=restTemplate.exchange("http://localhost:" + localServerPort + "/test",HttpMethod.GET,httpEntity,String.class).getBody();
  ObjectMapper mapper=new ObjectMapper();
  Assertions.assertThat(mapper.readTree(metadata)).isEqualTo(mapper.readTree("{\"a\":\"11\",\"b\":\"22\",\"c\":\"33\"}{\"LOCAL_SERVICE\":\"test" + "\",\"LOCAL_PATH\":\"/test\",\"LOCAL_NAMESPACE\":\"default\"}"));
  Assertions.assertThat(metadataLocalProperties.getContent().get("a")).isEqualTo("1");
  Assertions.assertThat(metadataLocalProperties.getContent().get("b")).isEqualTo("2");
  Assertions.assertThat(MetadataContextHolder.get().getTransitiveCustomMetadata("a")).isEqualTo("11");
  Assertions.assertThat(MetadataContextHolder.get().getTransitiveCustomMetadata("b")).isEqualTo("22");
  Assertions.assertThat(MetadataContextHolder.get().getTransitiveCustomMetadata("c")).isEqualTo("33");
}
