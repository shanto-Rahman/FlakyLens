@Test public void testAlternatePropertyNames(){
  ModelAPFoo model=createModelAPFoo();
  String jsonString=serialize(model);
  String alternateJson=jsonString.replaceAll("prop1","property1").replaceAll("prop2","property2");
  ModelAPFoo newModel=deserialize(alternateJson,ModelAPFoo.class);
  assertEquals(newModel,model);
  alternateJson=jsonString.replaceAll("prop1","p1").replaceAll("prop2","p2");
  newModel=deserialize(alternateJson,ModelAPFoo.class);
  assertEquals(newModel,model);
}
