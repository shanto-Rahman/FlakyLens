@Test public void yesnoCustom() throws IOException {
assertEquals("yesno",yesno.name());
assertEquals("yea",yesno.apply(true,options));
assertEquals("nop",yesno.apply(false,options));
assertEquals("whatever",yesno.apply(null,options));
}