@Test public void basicMessagingWithJsonResponse() throws Throwable {
  Object result=performStompSubscription("/app/json");
  assertThat(new String((byte[])result)).isEqualTo(String.format("{%n  \"foo\" : 5,%n  \"bar\" : \"baz\"%n}"));
}
