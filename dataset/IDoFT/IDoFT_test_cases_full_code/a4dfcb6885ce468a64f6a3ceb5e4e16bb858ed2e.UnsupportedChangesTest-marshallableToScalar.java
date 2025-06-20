@Test public void marshallableToScalar(){
  assumeFalse(Jvm.isArm());
  Map<ExceptionKey,Integer> exceptions=Jvm.recordExceptions(true);
  Wrapper wrapper=Marshallable.fromString(Wrapper.class,"{\n" + "pnl: { a: 128, b: 1.0 },\n" + "second: 123.4,"+ "}\n");
  assertEquals("!net.openhft.chronicle.wire.UnsupportedChangesTest$Wrapper {\n" + "  pnl: 0.0,\n" + "  second: 123.4\n"+ "}\n",wrapper.toString());
  assertEquals("{ExceptionKey{level=WARN, clazz=class net.openhft.chronicle.wire.TextWire$TextValueIn, message='Unable to read {a=128, b=1.0} as a double.', throwable=}=1}",exceptions.toString());
}
