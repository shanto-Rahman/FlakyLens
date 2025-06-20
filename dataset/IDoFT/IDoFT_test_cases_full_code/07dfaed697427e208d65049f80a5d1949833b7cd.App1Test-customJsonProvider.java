@Test public void customJsonProvider(){
  final String url=String.format("http://localhost:%d/mapper",RULE.getLocalPort());
  final String response=client.target(url).request().post(Entity.json("/** A Dropwizard specialty */\n{\"check\": \"mate\"}"),String.class);
  assertThat(response).isEqualTo("/** A Dropwizard specialty */\n" + "{\"check\":\"mate\",\"hello\":\"world\"}");
}
