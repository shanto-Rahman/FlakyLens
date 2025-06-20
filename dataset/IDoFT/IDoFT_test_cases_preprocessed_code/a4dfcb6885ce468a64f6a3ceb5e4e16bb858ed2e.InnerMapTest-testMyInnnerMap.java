@Test public void testMyInnnerMap(){
@NotNull MyMarshable myMarshable=new MyMarshable().name("rob");//IT
myMarshable.commission().put("hello",123.4);//IT
Assert.assertEquals("!net.openhft.chronicle.wire.InnerMapTest$MyMarshable {\n" + "  name: rob,\n" + "  commission: {\n"+ "    hello: 123.4\n"+ "  },\n"+ "  nested: !net.openhft.chronicle.wire.InnerMapTest$MyNested {\n"+ "    value: text\n"+ "  }\n"+ "}\n",asString);
Assert.assertEquals(asString,tm.toString());
}