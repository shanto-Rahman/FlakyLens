@Test public void testSubclasses(){
writer.event("top",new VanillaMethodReaderTest.MRT1("one"));//IT
writer.event("top",new VanillaMethodReaderTest.MRT2("one","two"));//IT
writer.event("mid",new VanillaMethodReaderTest.MRT1("1"));//IT
writer.event("mid",new VanillaMethodReaderTest.MRT2("1","2"));//IT
assertTrue(reader.readOne());
assertFalse(reader.readOne());
assertEquals(expected,actual);
}