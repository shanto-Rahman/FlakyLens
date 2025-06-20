@Test void noDoubleSlashes(){
  String basePath="http://localhost:" + this.port + "/";
  ResponseEntity<String> entity=new TestRestTemplate().getForEntity(basePath,String.class);
  assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
  String body=entity.getBody();
  assertThat(body).isNotNull();
  assertThat(body.contains(basePath + "/")).as("basePath contains double slashes").isFalse();
}
