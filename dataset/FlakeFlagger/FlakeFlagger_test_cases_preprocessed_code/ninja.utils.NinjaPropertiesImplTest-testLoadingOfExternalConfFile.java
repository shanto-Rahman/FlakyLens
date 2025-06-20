@Test public void testLoadingOfExternalConfFile(){
assertEquals("secretForHeroku",ninjaProperties.get(NinjaConstant.applicationSecret));
assertEquals("some special parameter",ninjaProperties.get("heroku.special.property"));
assertEquals("http://myapp.herokuapp.com:80",ninjaProperties.get("fullServerName"));
}