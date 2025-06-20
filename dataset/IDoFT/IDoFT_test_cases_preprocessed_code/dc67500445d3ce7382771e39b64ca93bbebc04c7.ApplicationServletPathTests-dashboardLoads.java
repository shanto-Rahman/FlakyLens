@Test void dashboardLoads(){
assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
assertThat(body.contains("eureka/js")).isTrue();
assertThat(body.contains("eureka/css")).isTrue();
assertThat(body.contains("<h1>Instances currently registered with Eureka</h1>")).isTrue();
}