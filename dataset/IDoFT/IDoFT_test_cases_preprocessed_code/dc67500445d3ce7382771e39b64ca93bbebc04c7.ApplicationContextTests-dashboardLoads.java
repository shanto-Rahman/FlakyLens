@Test void dashboardLoads(){
assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
assertThat(body.contains("eureka/js")).isTrue();
assertThat(body.contains("eureka/css")).isTrue();
assertThat(body.contains("<a href=\"http://localhost:8761/eureka/\">localhost</a>")).isTrue();
}