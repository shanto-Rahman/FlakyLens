@Test public void basicMessagingWithJsonResponse() throws Throwable {
assertThat(new String((byte[])result)).isEqualTo(String.format("{%n  \"foo\" : 5,%n  \"bar\" : \"baz\"%n}"));
}