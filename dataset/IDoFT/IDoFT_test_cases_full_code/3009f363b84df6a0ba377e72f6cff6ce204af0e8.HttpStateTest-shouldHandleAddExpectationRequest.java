@Test public void shouldHandleAddExpectationRequest(){
  Expectation expectationOne=new Expectation(request("request_one")).thenRespond(response("response_one"));
  HttpRequest request=request("/mockserver/expectation").withMethod("PUT").withBody(expectationSerializer.serialize(expectationOne));
  FakeResponseWriter responseWriter=new FakeResponseWriter();
  boolean handle=httpState.handle(request,responseWriter,false);
  assertThat(handle,is(true));
  assertThat(responseWriter.response.getStatusCode(),is(201));
  assertThat(responseWriter.response.getBodyAsString(),CoreMatchers.containsString("[ {" + NEW_LINE + "  \"id\" : \""));
  assertThat(responseWriter.response.getBodyAsString(),CoreMatchers.containsString("\"," + NEW_LINE + "  \"priority\" : 0,"+ NEW_LINE+ "  \"httpRequest\" : {"+ NEW_LINE+ "    \"path\" : \"request_one\""+ NEW_LINE+ "  },"+ NEW_LINE+ "  \"httpResponse\" : {"+ NEW_LINE+ "    \"statusCode\" : 200,"+ NEW_LINE+ "    \"reasonPhrase\" : \"OK\","+ NEW_LINE+ "    \"body\" : \"response_one\""+ NEW_LINE+ "  },"+ NEW_LINE+ "  \"times\" : {"+ NEW_LINE+ "    \"unlimited\" : true"+ NEW_LINE+ "  },"+ NEW_LINE+ "  \"timeToLive\" : {"+ NEW_LINE+ "    \"unlimited\" : true"+ NEW_LINE+ "  }"+ NEW_LINE+ "} ]"));
  assertThat(httpState.firstMatchingExpectation(request("request_one")),is(expectationOne));
}
