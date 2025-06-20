@Test public void customJsonProvider(){
final String response=client.target(url).request().post(Entity.json("/** A Dropwizard specialty */\n//RW
assertThat(response).isEqualTo("/** A Dropwizard specialty */\n" + "{\"check\":\"mate\",\"hello\":\"world\"}");
}