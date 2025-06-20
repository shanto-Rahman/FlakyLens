public void testAnnotationSharing() throws Exception {
  Wrapper input=new Wrapper();
  input.points.add(new Point(1,2));
  String xml=MAPPER.writeValueAsString(input);
  assertEquals("<Wrapper><Points><Point><x>1</x><y>2</y></Point></Points></Wrapper>",xml);
  Wrapper result=MAPPER.readValue(xml,Wrapper.class);
  assertEquals(1,result.points.size());
}
