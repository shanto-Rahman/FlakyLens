@Test void catalogLoads(){
assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
}