@Test public void testContextDump(){
  Bytes<?> from=Bytes.from("# comment\n" + "A: \n" + "  b: 1234\n"+ "  c: hi\n"+ "  d: abc\n"+ "B: \n"+ "  c: lo\n"+ "  d: xyz\n"+ "C: see\n");
  try {
    YamlWire yw=new YamlWire(from);
    assertEquals("[\n" + "  { token: STREAM_START, indent: -1, keys: !!null \"\" }\n" + "]",yw.dumpContext());
    yw.read("C").text();
    assertEquals("[\n" + "  { token: STREAM_START, indent: -1, keys: !!null \"\" },\n" + "  { token: DIRECTIVES_END, indent: -1, keys: !!null \"\" },\n"+ "  { token: MAPPING_START, indent: 0, keys: !net.openhft.chronicle.wire.YamlKeys { count: 2, offsets: [ 10, 41, 0, 0, 0, 0, 0 ]} }\n"+ "]",yw.dumpContext());
    assertEquals("{c=lo, d=xyz}","" + yw.read("B").object());
    assertEquals("{b=1234, c=hi, d=abc}","" + yw.read("A").object());
  }
  finally {
    from.releaseLast();
  }
}
