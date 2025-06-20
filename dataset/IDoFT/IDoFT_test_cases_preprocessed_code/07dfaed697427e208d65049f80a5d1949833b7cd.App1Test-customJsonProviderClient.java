@Test public void customJsonProviderClient(){
final String response=client.target(url).request().post(Entity.json(Collections.singletonMap("check","mate")),String.class);//RW
assertThat(response).isEqualTo("/** A Dropwizard specialty */\n" + "{\"check\":\"mate\",\"hello\":\"world\"}");
}