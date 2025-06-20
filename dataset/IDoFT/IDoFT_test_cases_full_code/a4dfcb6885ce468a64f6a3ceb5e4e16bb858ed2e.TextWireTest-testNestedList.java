@Test public void testNestedList(){
  NestedList nl=Marshallable.fromString("!" + NestedList.class.getName() + " {\n"+ "  name: name,\n"+ "  listA: [ { a: 1, b: 1.2 } ],\n"+ "  listB: [ { a: 1, b: 1.2 }, { a: 3, b: 2.3 } ],"+ "  num: 128\n"+ "}\n");
  String expected="!net.openhft.chronicle.wire.TextWireTest$NestedList {\n" + "  name: name,\n" + "  listA: [\n"+ "    { a: 1, b: 1.2 }\n"+ "  ],\n"+ "  listB: [\n"+ "    { a: 1, b: 1.2 },\n"+ "    { a: 3, b: 2.3 }\n"+ "  ],\n"+ "  num: 128\n"+ "}\n";
  assertEquals(expected,nl.toString());
  OUTER:   for (int i=0; i < 64; i++) {
    Set<Integer> set=new HashSet<>();
    String cs="!net.openhft.chronicle.wire.TextWireTest$NestedList {\n";
    int z=i;
    for (int j=0; j < 4; j++) {
      if (!set.add(z & 3))       continue OUTER;
switch (z & 3) {
case 0:        cs+="  name: name,\n";
      break;
case 1:    cs+="  listA: [\n" + "    { a: 1, b: 1.2 }\n" + "  ],\n";
  break;
case 2:cs+="  listB: [\n" + "    { a: 1, b: 1.2 },\n" + "    { a: 3, b: 2.3 }\n"+ "  ],\n";
break;
case 3:cs+="  num: 128,\n";
break;
}
z/=4;
}
cs+="}\n";
NestedList nl2=Marshallable.fromString(cs);
assertEquals(expected,nl2.toString());
}
}
