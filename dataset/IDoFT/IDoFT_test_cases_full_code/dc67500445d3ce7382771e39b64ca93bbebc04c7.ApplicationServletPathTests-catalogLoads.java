@Test void catalogLoads(){
  @SuppressWarnings("rawtypes") ResponseEntity<Map> entity=new TestRestTemplate().getForEntity("http://localhost:" + this.port + "/servlet/eureka/apps",Map.class);
  assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
}
