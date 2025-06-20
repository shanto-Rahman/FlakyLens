@Test public void shouldHandleRetrieveLogMessagesRequest(){
  Level originalLevel=ConfigurationProperties.logLevel();
  try {
    ConfigurationProperties.logLevel("INFO");
    httpState.add(new Expectation(request("request_one")).withId("key_one").thenRespond(response("response_one")));
    FakeResponseWriter responseWriter=new FakeResponseWriter();
    HttpRequest retrieveLogRequest=request("/mockserver/retrieve").withMethod("PUT").withQueryStringParameter("type",RetrieveType.LOGS.name()).withBody(httpRequestSerializer.serialize(request("request_one")));
    boolean handle=httpState.handle(retrieveLogRequest,responseWriter,false);
    assertThat(handle,is(true));
    assertThat(responseWriter.response.getStatusCode(),is(200));
    assertThat(responseWriter.response.getBodyAsString(),is(endsWith(LOG_DATE_FORMAT.format(new Date(TimeService.currentTimeMillis())) + " - creating expectation:" + NEW_LINE+ NEW_LINE+ "  {"+ NEW_LINE+ "    \"id\" : \"key_one\","+ NEW_LINE+ "    \"priority\" : 0,"+ NEW_LINE+ "    \"httpRequest\" : {"+ NEW_LINE+ "      \"path\" : \"request_one\""+ NEW_LINE+ "    },"+ NEW_LINE+ "    \"times\" : {"+ NEW_LINE+ "      \"unlimited\" : true"+ NEW_LINE+ "    },"+ NEW_LINE+ "    \"timeToLive\" : {"+ NEW_LINE+ "      \"unlimited\" : true"+ NEW_LINE+ "    },"+ NEW_LINE+ "    \"httpResponse\" : {"+ NEW_LINE+ "      \"statusCode\" : 200,"+ NEW_LINE+ "      \"reasonPhrase\" : \"OK\","+ NEW_LINE+ "      \"body\" : \"response_one\""+ NEW_LINE+ "    }"+ NEW_LINE+ "  }"+ NEW_LINE+ NEW_LINE+ " with id:"+ NEW_LINE+ NEW_LINE+ "  key_one"+ NEW_LINE+ NEW_LINE)));
  }
  finally {
    ConfigurationProperties.logLevel(originalLevel.name());
  }
}
