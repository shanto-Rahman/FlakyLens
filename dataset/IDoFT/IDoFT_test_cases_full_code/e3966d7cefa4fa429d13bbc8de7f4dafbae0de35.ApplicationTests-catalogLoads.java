@Test public void catalogLoads(){
  @SuppressWarnings("rawtypes") ResponseEntity<Map> entity=testRestTemplate.withBasicAuth(username,password).getForEntity("/eureka/apps",Map.class);
  assertEquals(HttpStatus.OK,entity.getStatusCode());
}
