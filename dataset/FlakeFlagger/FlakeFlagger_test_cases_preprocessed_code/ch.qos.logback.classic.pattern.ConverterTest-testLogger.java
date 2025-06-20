@Test public void testLogger(){
assertEquals(this.getClass().getName(),buf.toString());
assertEquals("c.q.l.c.p.ConverterTest",buf.toString());
assertEquals("ConverterTest",buf.toString());
}