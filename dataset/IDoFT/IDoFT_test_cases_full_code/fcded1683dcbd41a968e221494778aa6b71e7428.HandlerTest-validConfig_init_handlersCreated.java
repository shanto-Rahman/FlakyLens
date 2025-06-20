@Test public void validConfig_init_handlersCreated(){
  Handler.init();
  Map<String,List<HttpHandler>> handlers=Handler.handlerListById;
  Assert.assertEquals(1,handlers.get("third").size());
  Assert.assertEquals(2,handlers.get("secondBeforeFirst").size());
}
