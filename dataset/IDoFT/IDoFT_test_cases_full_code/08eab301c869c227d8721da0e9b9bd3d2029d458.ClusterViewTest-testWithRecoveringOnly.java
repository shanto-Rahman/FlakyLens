@Test public void testWithRecoveringOnly() throws Exception {
  String clusterId=UUID.randomUUID().toString();
  ClusterViewBuilder builder=new ClusterViewBuilder(10,2);
  ClusterView view=builder.active(2,3).recovering(4).inactive(5,6).asView(clusterId);
  JsonObject o=asJsonObject(view);
  Map<String,String> props=o.getProperties();
  assertEquals("10",props.get("seq"));
  assertEquals("true",props.get("final"));
  assertEquals(clusterId,unwrapString(props.get("id")));
  assertEquals("2",props.get("me"));
  assertEquals(asJsonArray(2,3),props.get("active"));
  assertEquals(asJsonArray(4),props.get("deactivating"));
  assertEquals(asJsonArray(5,6),props.get("inactive"));
}
