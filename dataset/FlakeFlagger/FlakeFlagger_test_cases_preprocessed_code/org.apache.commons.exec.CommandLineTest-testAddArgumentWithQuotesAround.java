public void testAddArgumentWithQuotesAround(){
assertEquals("test foo bar \"fe z\"",cmdl.toString());
assertEquals(new String[]{"test","foo","bar","\"fe z\""},cmdl.toStrings());
}