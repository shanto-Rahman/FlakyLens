@Test public void asRegexByDate(){
assertEquals("foo-2003.05.20-(\\d{1,3}).txt",regex);
assertEquals("/toto/foo-2003/05/20-(\\d{1,3}).txt",regex);
}