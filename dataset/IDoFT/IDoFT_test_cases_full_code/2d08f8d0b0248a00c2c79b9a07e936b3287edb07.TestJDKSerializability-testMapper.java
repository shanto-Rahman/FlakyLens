public void testMapper() throws IOException {
  XmlMapper mapper=xmlMapper(true);
  final String EXP="<MyPojo><x>2</x><y>3</y></MyPojo>";
  final MyPojo p=new MyPojo(2,3);
  assertEquals(EXP,mapper.writeValueAsString(p));
  byte[] bytes=jdkSerialize(mapper);
  XmlMapper mapper2=jdkDeserialize(bytes);
  assertEquals(EXP,mapper2.writeValueAsString(p));
  MyPojo p2=mapper2.readValue(EXP,MyPojo.class);
  assertEquals(p.x,p2.x);
  assertEquals(p.y,p2.y);
}
