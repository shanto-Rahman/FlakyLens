@Test public void customJsonProviderClient(){
  final String url=String.format("http://localhost:%d/mapper",RULE.getLocalPort());
  final String response=client.target(url).request().post(Entity.json(Collections.singletonMap("check","mate")),String.class);
  assertThat(response).isEqualTo("/** A Dropwizard specialty */\n" + "{\"check\":\"mate\",\"hello\":\"world\"}");
}
