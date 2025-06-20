@Test void dashboardLoads(){
  ResponseEntity<String> entity=new TestRestTemplate().getForEntity("http://localhost:" + this.port + "/dashboard",String.class);
  assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
  String body=entity.getBody();
  assertThat(body.contains("eureka/js")).isTrue();
  assertThat(body.contains("eureka/css")).isTrue();
  assertThat(body.contains("<h1>Instances currently registered with Eureka</h1>")).isTrue();
  assertThat(body.contains("<a href=\"/dashboard\">Home</a>")).isTrue();
  assertThat(body.contains("<a href=\"/dashboard/lastn\">Last")).isTrue();
}
