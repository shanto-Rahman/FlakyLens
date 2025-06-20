@Test public void nestedWithEnumSet(){
  Wire wire=createWire();
  NestedWithEnumSet n=new NestedWithEnumSet();
  n.list.add(new WithEnumSet("none"));
  n.list.add(new WithEnumSet("one",EnumSet.of(TimeUnit.DAYS)));
  n.list.add(new WithEnumSet("two",EnumSet.of(TimeUnit.DAYS,TimeUnit.HOURS)));
  wire.write("hello").object(NestedWithEnumSet.class,n);
  assertEquals("hello: {\n" + "  list: [\n" + "    { name: none },\n"+ "    { name: one, timeUnits: [ DAYS ] },\n"+ "    { name: two, timeUnits: [ HOURS, DAYS ] }\n"+ "  ]\n"+ "}\n",wire.toString());
  NestedWithEnumSet a=wire.read("hello").object(NestedWithEnumSet.class);
  assertEquals(n.toString(),a.toString());
  assertEquals(n,a);
}
