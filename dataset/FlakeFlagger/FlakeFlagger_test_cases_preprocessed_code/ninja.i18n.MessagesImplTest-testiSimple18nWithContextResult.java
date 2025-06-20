@Test public void testiSimple18nWithContextResult(){
assertEquals("english",messages.get("language",context,Optional.of(result)).get());
assertEquals("english",messages.get("language",context,Optional.of(result)).get());
assertEquals("english",messages.get("language",context,Optional.of(result)).get());
assertEquals("deutsch",messages.get("language",context,Optional.of(result)).get());
assertEquals("deutsch",messages.get("language",context,Optional.of(result)).get());
assertEquals("francaise",messages.get("language",context,Optional.of(result)).get());
assertEquals("deutsch",messages.get("language",context,Optional.of(result)).get());
}