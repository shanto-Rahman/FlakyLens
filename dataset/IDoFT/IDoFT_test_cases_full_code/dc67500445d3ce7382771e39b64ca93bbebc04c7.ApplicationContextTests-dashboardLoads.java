@Test void dashboardLoads(){
  ResponseEntity<String> entity=new TestRestTemplate().getForEntity("http://localhost:" + this.port + "/context/",String.class);
  assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
  String body=entity.getBody();
  assertThat(body.contains("eureka/js")).isTrue();
  assertThat(body.contains("eureka/css")).isTrue();
  assertThat(body.contains("<a href=\"http://localhost:8761/eureka/\">localhost</a>")).isTrue();
}
