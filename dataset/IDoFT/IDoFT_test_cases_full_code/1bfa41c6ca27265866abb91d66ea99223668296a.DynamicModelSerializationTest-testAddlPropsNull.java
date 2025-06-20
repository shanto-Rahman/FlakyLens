@Test public void testAddlPropsNull(){
  ModelAPString model=createModelAPString();
  model.put("basketball",null);
  String json=serialize(model);
  display("Serialized: " + json);
  assertTrue(json.contains("\"basketball\": null"));
  ModelAPString newModel=deserialize(json,ModelAPString.class);
  assertEquals(newModel,model);
}
