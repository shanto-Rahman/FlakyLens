@Test public void testReset(){
  MyTypes mt=new MyTypes().flag(true).b((byte)1).s((short)2).ch('3').i(4).f(5).d(6).l(7).text("text");
  assertEquals("!net.openhft.chronicle.wire.MyTypes {\n" + "  text: text,\n" + "  flag: true,\n"+ "  b: 1,\n"+ "  s: 2,\n"+ "  ch: \"3\",\n"+ "  i: 4,\n"+ "  f: 5.0,\n"+ "  d: 6.0,\n"+ "  l: 7\n"+ "}\n",mt.toString());
  mt.reset();
  assertEquals("!net.openhft.chronicle.wire.MyTypes {\n" + "  text: \"\",\n" + "  flag: false,\n"+ "  b: 0,\n"+ "  s: 0,\n"+ "  ch: \"\\0\",\n"+ "  i: 0,\n"+ "  f: 0.0,\n"+ "  d: 0.0,\n"+ "  l: 0\n"+ "}\n",mt.toString());
}
