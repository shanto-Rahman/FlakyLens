@Test public void validConfig_init_handlersCreated(){
Assert.assertEquals(1,handlers.get("third").size());
Assert.assertEquals(2,handlers.get("secondBeforeFirst").size());
}