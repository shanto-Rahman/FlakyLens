@Test public void useInterceptor() throws Exception {
  StringWriter sw=new StringWriter();
  UpdateInterceptor ui=(methodName,t) -> {
    sw.append(methodName).append(": ").append(String.valueOf(t));
    boolean block=!((MyTypes)t).text().toString().equals("block");
    sw.append("return: ").append(String.valueOf(block)).append("\n\n");
    return block;
  }
;
  doTest(ui,"Hello World");
  doTest(ui,"block");
  String theTimeIs="The time is " + LocalDateTime.now();
  doTest(ui,theTimeIs);
  assertEquals("accept: !net.openhft.chronicle.wire.MyTypes {\n" + "  text: Hello World,\n" + "  flag: false,\n"+ "  b: 0,\n"+ "  s: 0,\n"+ "  ch: \"\\0\",\n"+ "  i: 0,\n"+ "  f: 0.0,\n"+ "  d: 0.0,\n"+ "  l: 0\n"+ "}\n"+ "return: true\n"+ "\n"+ "accept: !net.openhft.chronicle.wire.MyTypes {\n"+ "  text: block,\n"+ "  flag: false,\n"+ "  b: 0,\n"+ "  s: 0,\n"+ "  ch: \"\\0\",\n"+ "  i: 0,\n"+ "  f: 0.0,\n"+ "  d: 0.0,\n"+ "  l: 0\n"+ "}\n"+ "return: false\n"+ "\n"+ "accept: !net.openhft.chronicle.wire.MyTypes {\n"+ "  text: \"" + theTimeIs + "\",\n"+ "  flag: false,\n"+ "  b: 0,\n"+ "  s: 0,\n"+ "  ch: \"\\0\",\n"+ "  i: 0,\n"+ "  f: 0.0,\n"+ "  d: 0.0,\n"+ "  l: 0\n"+ "}\n"+ "return: true\n"+ "\n",sw.toString());
}
