@Test public void nestedWithEnumSet(){
  Wire wire=createWire();
  YNestedWithEnumSet n=new YNestedWithEnumSet();
  n.list.add(new WithEnumSet("none"));
  n.list.add(new WithEnumSet("one",EnumSet.of(TimeUnit.DAYS)));
  n.list.add(new WithEnumSet("two",EnumSet.of(TimeUnit.DAYS,TimeUnit.HOURS)));
  wire.write("hello").object(YNestedWithEnumSet.class,n);
  assertEquals("hello: {\n" + "  list: [\n" + "    { name: none },\n"+ "    { name: one, timeUnits: [ DAYS ]},\n"+ "    { name: two, timeUnits: [ HOURS, DAYS ]}\n"+ "  ]\n"+ "}\n",wire.toString());
  YNestedWithEnumSet a=wire.read("hello").object(YNestedWithEnumSet.class);
  assertEquals(n.toString(),a.toString());
  assertEquals(n,a);
}
