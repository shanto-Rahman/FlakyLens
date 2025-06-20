@Test public void doubleModuleRegistration() throws Exception {
assertEquals("{\"foo\":\"bar\"}",mapper.writeValueAsString(new Foo()));
}