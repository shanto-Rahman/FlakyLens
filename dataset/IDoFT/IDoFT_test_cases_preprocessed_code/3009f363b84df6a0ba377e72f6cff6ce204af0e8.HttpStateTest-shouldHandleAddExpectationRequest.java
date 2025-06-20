@Test public void shouldHandleAddExpectationRequest(){
assertThat(handle,is(true));
assertThat(responseWriter.response.getStatusCode(),is(201));
assertThat(responseWriter.response.getBodyAsString(),CoreMatchers.containsString("[ {" + NEW_LINE + "  \"id\" : \""));
assertThat(responseWriter.response.getBodyAsString(),CoreMatchers.containsString("\"," + NEW_LINE + "  \"priority\" : 0,"+ NEW_LINE+ "  \"httpRequest\" : {"+ NEW_LINE+ "    \"path\" : \"request_one\""+ NEW_LINE+ "  },"+ NEW_LINE+ "  \"httpResponse\" : {"+ NEW_LINE+ "    \"statusCode\" : 200,"+ NEW_LINE+ "    \"reasonPhrase\" : \"OK\","+ NEW_LINE+ "    \"body\" : \"response_one\""+ NEW_LINE+ "  },"+ NEW_LINE+ "  \"times\" : {"+ NEW_LINE+ "    \"unlimited\" : true"+ NEW_LINE+ "  },"+ NEW_LINE+ "  \"timeToLive\" : {"+ NEW_LINE+ "    \"unlimited\" : true"+ NEW_LINE+ "  }"+ NEW_LINE+ "} ]"));
assertThat(httpState.firstMatchingExpectation(request("request_one")),is(expectationOne));
}