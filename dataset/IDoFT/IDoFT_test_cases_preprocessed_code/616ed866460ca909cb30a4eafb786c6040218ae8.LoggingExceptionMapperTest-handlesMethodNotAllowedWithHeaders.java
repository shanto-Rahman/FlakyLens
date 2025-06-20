@Test public void handlesMethodNotAllowedWithHeaders(){
assertThat(thrown).isInstanceOf(WebApplicationException.class);
assertThat(resp.getStatus()).isEqualTo(405);
assertThat(resp.getHeaders()).contains(entry("Allow",Collections.singletonList("GET,OPTIONS")));
assertThat(resp.readEntity(String.class)).isEqualTo("{\"code\":405,\"message\":\"HTTP 405 Method Not Allowed\"}");
}