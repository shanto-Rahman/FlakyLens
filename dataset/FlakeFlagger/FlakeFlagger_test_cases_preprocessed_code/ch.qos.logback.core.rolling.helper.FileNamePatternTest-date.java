@Test public void date(){
assertEquals("foo2003.05.20",pp.convert(cal.getTime()));
assertEquals("foo2003.05.20 17:55",pp.convert(cal.getTime()));
assertEquals("2003.05.20 17:55 foo",pp.convert(cal.getTime()));
}