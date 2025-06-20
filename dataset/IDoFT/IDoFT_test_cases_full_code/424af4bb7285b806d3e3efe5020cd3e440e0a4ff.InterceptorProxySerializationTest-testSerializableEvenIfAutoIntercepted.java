@Test public void testSerializableEvenIfAutoIntercepted() throws Exception {
  addInterceptor(IBInterceptor.class);
  startContainer(Arrays.<Class<?>>asList(Intercepted.class,AutoIntercepted.class,InjectMeInInterceptor.class),null,true);
  try {
    AutoIntercepted.called=false;
    auto.touch();
    assertTrue(AutoIntercepted.called);
    final AutoIntercepted deserializeInit=AutoIntercepted.class.cast(deserialize(serialize(auto)));
    AutoIntercepted.called=false;
    deserializeInit.touch();
    assertTrue(AutoIntercepted.called);
    final AutoIntercepted deserializeState=AutoIntercepted.class.cast(deserialize(serialize(deserializeInit)));
    AutoIntercepted.called=false;
    deserializeState.touch();
    assertTrue(AutoIntercepted.called);
  }
  finally {
    shutDownContainer();
  }
}
