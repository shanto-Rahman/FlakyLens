@Test void dashboardUpdatedAsSoonAsRefreshed(){
  changeProperty("eureka.client.service-url.defaultZone=https://defaul-host5:8678/eureka/");
  forceUpdate();
  final ResponseEntity<String> entity=new TestRestTemplate().getForEntity("http://localhost:" + this.port + "/",String.class);
  assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
  final String body=entity.getBody();
  assertThat(body).isNotNull();
  assertThat(body.contains("https://defaul-host5:8678/eureka/")).as("DS Replicas not updated in the Eureka Server dashboard").isTrue();
}
