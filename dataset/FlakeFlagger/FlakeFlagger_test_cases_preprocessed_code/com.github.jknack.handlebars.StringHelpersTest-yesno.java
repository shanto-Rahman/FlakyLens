@Test public void yesno() throws IOException {
assertEquals("yesno",yesno.name());
assertEquals("yes",yesno.apply(true,options));
assertEquals("no",yesno.apply(false,options));
assertEquals("maybe",yesno.apply(null,options));
}