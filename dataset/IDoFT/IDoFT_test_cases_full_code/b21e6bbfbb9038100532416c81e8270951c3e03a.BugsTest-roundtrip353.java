@Test public void roundtrip353() throws Exception {
  ObjectMapper mapper=new ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
  String json=mapper.writeValueAsString(ImmutableNamingStrategy.builder().abraCadabra(1).focusPocus(true).build());
  NamingStrategy info=mapper.readValue(json,NamingStrategy.class);
  check(info.abraCadabra()).is(1);
  check(info.focusPocus());
  check(json).is("{'abra_cadabra':1,'focus_pocus':true}".replace('\'','"'));
}
