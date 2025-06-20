@Test public void testTypeWithoutSpace(){
  @NotNull Wire wire=createWire();
  wire.bytes().append("A: !").append(MyTypes.class.getName()).append("{}");
  @NotNull MyTypes mt=(MyTypes)wire.read(() -> "A").object();
  assertEquals("!net.openhft.chronicle.wire.MyTypes {\n" + "  text: \"\",\n" + "  flag: false,\n"+ "  b: 0,\n"+ "  s: 0,\n"+ "  ch: \"\\0\",\n"+ "  i: 0,\n"+ "  f: 0.0,\n"+ "  d: 0.0,\n"+ "  l: 0\n"+ "}\n",mt.toString());
}
