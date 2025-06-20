@Test public void assertGetCause(){
assertThat(new HostException(cause).getCause(),Is.<Throwable>is(cause));
}