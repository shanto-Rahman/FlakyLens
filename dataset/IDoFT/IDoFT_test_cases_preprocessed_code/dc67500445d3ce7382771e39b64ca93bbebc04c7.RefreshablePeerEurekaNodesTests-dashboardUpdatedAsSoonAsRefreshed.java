@Test void dashboardUpdatedAsSoonAsRefreshed(){
assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
assertThat(body).isNotNull();
assertThat(body.contains("https://defaul-host5:8678/eureka/")).as("DS Replicas not updated in the Eureka Server dashboard").isTrue();
}