@Test(expected=WroRuntimeException.class) public void shouldNotInjectUnsupportedAndInitializedTypes(){
assertEquals(initialValue,unsupportedInitializedType);
}