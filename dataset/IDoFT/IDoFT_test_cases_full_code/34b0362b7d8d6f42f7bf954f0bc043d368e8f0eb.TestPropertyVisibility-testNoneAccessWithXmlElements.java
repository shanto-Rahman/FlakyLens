public void testNoneAccessWithXmlElements() throws Exception {
  NoneAccessBean input=new NoneAccessBean(new Foo44());
  assertEquals(aposToQuotes("{'object':{'foo':{'foo':'bar'}},'other':null}"),MAPPER.writeValueAsString(input));
}
