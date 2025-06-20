@Test public void testJsonContentType(){
  final Response response=target("/").request().accept(MediaType.APPLICATION_JSON_TYPE).get();
  assertThat(response.getStatus()).isEqualTo(200);
  assertThat(response.readEntity(String.class)).isEqualTo("{\"title\":\"Title#TEST\",\"content\":\"Content#TEST\"}");
}
