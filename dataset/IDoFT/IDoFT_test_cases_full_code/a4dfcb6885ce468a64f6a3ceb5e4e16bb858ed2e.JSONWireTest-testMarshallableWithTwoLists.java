@Test public void testMarshallableWithTwoLists(){
  @NotNull Wire wire=getWire();
  @NotNull TwoLists lists1=new TwoLists(null,5,5);
  wire.writeEventName("two_lists").marshallable(lists1);
  @NotNull TwoLists lists2=new TwoLists();
  @NotNull final StringBuilder sb=new StringBuilder();
  @NotNull ValueIn valueIn=wire.readEventName(sb);
  valueIn.marshallable(lists2);
  try {
    assertEquals("!net.openhft.chronicle.wire.JSONWireTest$TwoLists {\n" + "  name: !!null \"\",\n" + "  list1: [\n"+ "    { name: !!null \"\", number1: 0, number2: 0.0 },\n"+ "    { name: !!null \"\", number1: 1, number2: 10.0 },\n"+ "    { name: !!null \"\", number1: 2, number2: 20.0 },\n"+ "    { name: !!null \"\", number1: 3, number2: 30.0 },\n"+ "    { name: !!null \"\", number1: 4, number2: 40.0 }\n"+ "  ],\n"+ "  list2: [\n"+ "    { name: !!null \"\", number1: 0, number2: 0.0 },\n"+ "    { name: !!null \"\", number1: 1, number2: 10.0 },\n"+ "    { name: !!null \"\", number1: 2, number2: 20.0 },\n"+ "    { name: !!null \"\", number1: 3, number2: 30.0 },\n"+ "    { name: !!null \"\", number1: 4, number2: 40.0 }\n"+ "  ]\n"+ "}\n",lists1.toString());
  }
  finally {
    wire.bytes().releaseLast();
  }
}
