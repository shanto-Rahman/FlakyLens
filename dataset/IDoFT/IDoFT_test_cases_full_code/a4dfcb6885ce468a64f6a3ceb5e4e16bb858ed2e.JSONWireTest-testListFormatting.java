@Test public void testListFormatting(){
  @NotNull Wire wire=getWire();
  @NotNull List<Item> items=new ArrayList<>();
  items.add(new Item("item1",1235666L,1.1231231));
  items.add(new Item("item2",2235666L,1.0987987));
  items.add(new Item("item3",3235666L,1.12312));
  items.add(new Item("item4",4235666L,1.51231));
  @NotNull WireOut out=wire.writeEventName(() -> "myEvent").list(items,Item.class);
  assertEquals("\"myEvent\":[{\"name\":\"item1\",\"number1\":1235666,\"number2\":1.1231231},\n" + "{\"name\":\"item2\",\"number1\":2235666,\"number2\":1.0987987},\n" + "{\"name\":\"item3\",\"number1\":3235666,\"number2\":1.12312},\n"+ "{\"name\":\"item4\",\"number1\":4235666,\"number2\":1.51231}]",out.toString());
  wire.bytes().releaseLast();
}
