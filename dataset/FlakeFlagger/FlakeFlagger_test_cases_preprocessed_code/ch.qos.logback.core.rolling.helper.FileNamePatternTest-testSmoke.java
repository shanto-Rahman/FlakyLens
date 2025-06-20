@Test public void testSmoke(){
assertEquals("t",pp.convertInt(3));
assertEquals("foo",pp.convertInt(3));
assertEquals("3 foo",pp.convertInt(3));
assertEquals("foo3.xixo",pp.convertInt(3));
assertEquals("foo3.log",pp.convertInt(3));
assertEquals("foo.3.log",pp.convertInt(3));
}