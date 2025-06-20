@Test public void testCopy(){
  DTO2 dto2=new DTO2();
  dto2.one=RetentionPolicy.CLASS;
  dto2.two=Arrays.asList(1L,22L);
  dto2.three="2018-11-02";
  String s=WireType.TEXT.asString(dto2);
  System.out.println(s);
  DTO1 dto1=WireType.TEXT.fromString(DTO1.class,s);
  assertEquals("!net.openhft.chronicle.wire.MarshallableTest$DTO1 {\n" + "  one: CLASS,\n" + "  two: [\n"+ "    1,\n"+ "    22\n"+ "  ],\n"+ "  three: 2018-11-02\n"+ "}\n",WireType.TEXT.asString(dto1));
}
