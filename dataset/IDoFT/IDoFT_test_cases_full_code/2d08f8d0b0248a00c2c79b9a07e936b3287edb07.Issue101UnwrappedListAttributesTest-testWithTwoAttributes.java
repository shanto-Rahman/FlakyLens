public void testWithTwoAttributes() throws Exception {
  final String EXP="<root>" + "<unwrapped id=\"1\" type=\"string\"/>" + "<unwrapped id=\"2\" type=\"string\"/>"+ "<name>test</name>"+ "</root>";
  Root rootOb=new Root();
  rootOb.unwrapped=Arrays.asList(new UnwrappedElement("1","string"),new UnwrappedElement("2","string"));
  rootOb.name="test";
  String xml=MAPPER.writeValueAsString(rootOb);
  assertEquals(EXP,xml);
  Root result=MAPPER.readValue(xml,Root.class);
  assertNotNull(result);
  assertEquals(rootOb.name,result.name);
}
