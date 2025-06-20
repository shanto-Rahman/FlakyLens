@Test public void shouldSerializeToTreeJson() throws Exception {
  final TinkerGraph graph=TinkerFactory.createClassic();
  final GraphTraversalSource g=graph.traversal();
  final Tree t=g.V(1).out().properties("name").tree().next();
  final String results=SERIALIZER.serializeResponseAsString(ResponseMessage.build(msg).result(t).create());
  final JsonNode json=mapper.readTree(results);
  assertNotNull(json);
  assertEquals(msg.getRequestId().toString(),json.get(SerTokens.TOKEN_REQUEST).asText());
  final JsonNode converted=json.get(SerTokens.TOKEN_RESULT).get(SerTokens.TOKEN_DATA);
  assertNotNull(converted);
  assertEquals(1,converted.get(GraphSONTokens.VALUEPROP).get(0).get(GraphSONTokens.KEY).get(GraphSONTokens.VALUEPROP).get(GraphSONTokens.ID).get(GraphSONTokens.VALUEPROP).asInt());
  assertEquals("marko",converted.get(GraphSONTokens.VALUEPROP).get(0).get(GraphSONTokens.KEY).get(GraphSONTokens.VALUEPROP).get(GraphSONTokens.PROPERTIES).get("name").get(0).get(GraphSONTokens.VALUEPROP).get(GraphSONTokens.VALUE).asText());
  assertEquals("vadas",converted.get(GraphSONTokens.VALUEPROP).get(0).get(GraphSONTokens.VALUE).get(GraphSONTokens.VALUEPROP).get(0).get(GraphSONTokens.KEY).get(GraphSONTokens.VALUEPROP).get(GraphSONTokens.PROPERTIES).get("name").get(0).get(GraphSONTokens.VALUEPROP).get(GraphSONTokens.VALUE).asText());
  assertEquals("lop",converted.get(GraphSONTokens.VALUEPROP).get(0).get(GraphSONTokens.VALUE).get(GraphSONTokens.VALUEPROP).get(1).get(GraphSONTokens.KEY).get(GraphSONTokens.VALUEPROP).get(GraphSONTokens.PROPERTIES).get("name").get(0).get(GraphSONTokens.VALUEPROP).get(GraphSONTokens.VALUE).asText());
  assertEquals("josh",converted.get(GraphSONTokens.VALUEPROP).get(0).get(GraphSONTokens.VALUE).get(GraphSONTokens.VALUEPROP).get(2).get(GraphSONTokens.KEY).get(GraphSONTokens.VALUEPROP).get(GraphSONTokens.PROPERTIES).get("name").get(0).get(GraphSONTokens.VALUEPROP).get(GraphSONTokens.VALUE).asText());
}
