@Test public void writeReadViaImplementation(){
mwbi0.method(new MWBImpl("name",1234567890123456L));//IT
assertEquals("method: {\n" + "  name: name,\n" + "  time: 2009-02-13T23:31:30.123456\n"+ "}\n"+ "...\n",tw.toString());
assertTrue(reader.readOne());
assertEquals("method[!net.openhft.chronicle.wire.method.MethodWriterByInterfaceTest$MWBImpl {\n" + "  name: name,\n" + "  time: 2009-02-13T23:31:30.123456\n"+ "}\n"+ "]\n",sw.toString().replace("\r",""));
}