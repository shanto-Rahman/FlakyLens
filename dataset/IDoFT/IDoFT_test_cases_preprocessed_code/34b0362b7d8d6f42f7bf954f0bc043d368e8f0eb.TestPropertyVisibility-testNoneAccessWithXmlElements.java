public void testNoneAccessWithXmlElements() throws Exception {
assertEquals(aposToQuotes("{'object':{'foo':{'foo':'bar'}},'other':null}"),MAPPER.writeValueAsString(input));
}