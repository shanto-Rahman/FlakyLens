@Test public void handlesMethodNotAllowedWithHeaders(){
  final Throwable thrown=catchThrowable(() -> target("/exception/json-mapping-exception").request(MediaType.APPLICATION_JSON).post(Entity.json("A"),String.class));
  assertThat(thrown).isInstanceOf(WebApplicationException.class);
  final Response resp=((WebApplicationException)thrown).getResponse();
  assertThat(resp.getStatus()).isEqualTo(405);
  assertThat(resp.getHeaders()).contains(entry("Allow",Collections.singletonList("GET,OPTIONS")));
  assertThat(resp.readEntity(String.class)).isEqualTo("{\"code\":405,\"message\":\"HTTP 405 Method Not Allowed\"}");
}
