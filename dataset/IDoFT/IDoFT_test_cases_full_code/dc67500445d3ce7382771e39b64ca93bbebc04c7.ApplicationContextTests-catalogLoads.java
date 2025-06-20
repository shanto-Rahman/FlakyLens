@Test void catalogLoads(){
  @SuppressWarnings("rawtypes") ResponseEntity<Map> entity=new TestRestTemplate().getForEntity("http://localhost:" + this.port + "/context/eureka/apps",Map.class);
  assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
}
