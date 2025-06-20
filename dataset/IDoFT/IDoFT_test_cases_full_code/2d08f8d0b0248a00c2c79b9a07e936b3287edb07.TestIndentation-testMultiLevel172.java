public void testMultiLevel172() throws Exception {
  Company root=new Company();
  root.employee.add(new Employee("abc"));
  String xml=_xmlMapper.writer().with(ToXmlGenerator.Feature.WRITE_XML_DECLARATION).writeValueAsString(root);
  xml=a2q(xml);
  assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + "<Company>\n" + "  <e>\n"+ "    <employee>\n"+ "      <id>abc</id>\n"+ "      <type>FULL_TIME</type>\n"+ "    </employee>\n"+ "  </e>\n"+ "</Company>\n",xml);
}
