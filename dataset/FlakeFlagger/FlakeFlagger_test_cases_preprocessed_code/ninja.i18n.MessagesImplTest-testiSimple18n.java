@Test public void testiSimple18n(){
assertEquals("english",lang.get("language",Optional.of("en-US")).get());
assertEquals("english",lang.get("language",Optional.of("en-CA")).get());
assertEquals("english",lang.get("language",Optional.of("en-UK")).get());
assertEquals("deutsch",lang.get("language",Optional.of("de")).get());
assertEquals("deutsch",lang.get("language",Optional.of("de-DE")).get());
assertEquals("francaise",lang.get("language",Optional.of("fr-FR")).get());
}