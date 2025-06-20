@Test public void testContextDump2(){
assertEquals("[\n" + "  { token: STREAM_START, indent: -1, keys: !!null \"\" },\n" + "  { token: DIRECTIVES_END, indent: -1, keys: !!null \"\" },\n"+ "  { token: MAPPING_START, indent: 0, keys: !net.openhft.chronicle.wire.YamlKeys { count: 4, offsets: [ 2, 8, 14, 32, 0, 0, 0 ]} }\n"+ "]",yw.dumpContext());
assertEquals("AA","" + yw.read("b").object());
assertEquals("{}","" + yw.read("c").object());
assertEquals("{A=1, B=2}","" + yw.read("d").object());
assertEquals("end","" + yw.read("e").object());
}