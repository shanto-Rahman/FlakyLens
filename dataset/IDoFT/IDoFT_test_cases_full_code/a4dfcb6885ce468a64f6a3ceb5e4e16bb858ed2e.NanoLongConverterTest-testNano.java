@Test public void testNano(){
  String in="!net.openhft.chronicle.wire.NanoLongConverterTest$Data {\n" + "  time: 2019-01-20T23:45:11.123456789,\n" + "  ttl: PT1H15M\n"+ "}\n";
  Data data=Marshallable.fromString(in);
  assertEquals(in,data.toString());
}
