public void testNoElementWrapper() throws Exception {
  XmlMapper jaxbMapper=mapperBuilder().annotationIntrospector(jakartaXMLBindAnnotationIntrospector()).build();
  MyPerson2 person=new MyPerson2();
  person.name="Jay";
  MyPerson2 child=new MyPerson2();
  child.name="Junior";
  person.child.add(child);
  String xml=jaxbMapper.writeValueAsString(person);
  boolean expected1=xml.equals("<p><name>Jay</name><child><name>Junior</name></child></p>");
  boolean expected2=xml.equals("<p><child><name>Junior</name></child><name>Jay</name></p>");
  assertTrue(expected1 || expected2);
}
