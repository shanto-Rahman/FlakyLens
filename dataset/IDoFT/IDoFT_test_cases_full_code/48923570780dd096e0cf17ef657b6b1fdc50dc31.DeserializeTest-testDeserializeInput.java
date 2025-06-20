@Test public void testDeserializeInput() throws IOException {
  Input input=new Input.InputBuilder("new_input","some_expression",true).withRequired(true).withPrivateInput(true).withFunctionDependencies(Sets.newHashSet(ScriptFunction.GET)).withSystemPropertyDependencies(Sets.newHashSet("a.b.c.prop1","a.b.c.prop2")).build();
  testToAndFromJson(input,Input.class);
}
