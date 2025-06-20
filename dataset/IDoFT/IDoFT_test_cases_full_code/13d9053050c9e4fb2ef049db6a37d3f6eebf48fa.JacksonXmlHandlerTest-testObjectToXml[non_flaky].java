public void testObjectToXml() throws Exception {
  SimpleBean obj=new SimpleBean();
  obj.setName("Jan");
  obj.setAge(12L);
  obj.setParents(Arrays.asList("Adam","Ewa"));
  Writer stream=new StringWriter();
  handler.fromObject(ai,obj,null,stream);
  stream.flush();
  String actual=stream.toString();
  assertTrue(actual.length() == xml.length() && actual.startsWith(prefix) && actual.contains(name) && actual.contains(age) && actual.contains(parents) && actual.endsWith(suffix));
}
