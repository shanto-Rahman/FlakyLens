public void testPersonAsXml() throws Exception {
  MyPerson person=new MyPerson();
  person.id=Long.valueOf(1L);
  person.firstName="Jay";
  person.lastName="Unit";
  String json=_jaxbMapper.writeValueAsString(person);
  String expected="<Individual identifier=\"1\"><givenName>Jay</givenName>" + "<surName>Unit</surName></Individual>";
  assertEquals(expected,json);
}
