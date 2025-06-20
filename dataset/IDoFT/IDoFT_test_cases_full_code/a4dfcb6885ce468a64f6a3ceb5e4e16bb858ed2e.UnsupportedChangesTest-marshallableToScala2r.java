@Test public void marshallableToScala2r(){
  Map<ExceptionKey,Integer> exceptions=Jvm.recordExceptions(true);
  IntWrapper wrapper=Marshallable.fromString(IntWrapper.class,"{\n" + "pnl: { a: 128, b: 1.0 },\n" + "second: 1234,"+ "}\n");
  assertEquals("!net.openhft.chronicle.wire.UnsupportedChangesTest$IntWrapper {\n" + "  pnl: 0,\n" + "  second: 1234\n"+ "}\n",wrapper.toString());
  assertEquals("{ExceptionKey{level=WARN, clazz=class net.openhft.chronicle.wire.TextWire$TextValueIn, message='Unable to read {a=128, b=1.0} as a long.', throwable=}=1}",exceptions.toString());
}
