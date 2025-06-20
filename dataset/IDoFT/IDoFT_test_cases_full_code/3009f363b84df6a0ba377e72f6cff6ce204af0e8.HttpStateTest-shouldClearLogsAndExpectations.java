@Test public void shouldClearLogsAndExpectations(){
  Level originalLevel=ConfigurationProperties.logLevel();
  try {
    ConfigurationProperties.logLevel("INFO");
    httpState.add(new Expectation(request("request_one")).withId("one").thenRespond(response("response_one")));
    httpState.log(new LogEntry().setType(TRACE).setHttpRequest(request("request_four")).setExpectation(new Expectation(request("request_four")).thenRespond(response("response_four"))).setMessageFormat("some random{}message").setArguments("argument_one"));
    httpState.clear(request().withQueryStringParameter("type","all"));
    assertThat(httpState.retrieve(request().withQueryStringParameter("type","logs")),is(response().withBody("" + LOG_DATE_FORMAT.format(new Date(TimeService.currentTimeMillis())) + " - cleared logs that match:"+ NEW_LINE+ ""+ NEW_LINE+ "  {}"+ NEW_LINE+ ""+ NEW_LINE+ "------------------------------------"+ NEW_LINE+ LOG_DATE_FORMAT.format(new Date(TimeService.currentTimeMillis()))+ " - removed expectation:"+ NEW_LINE+ NEW_LINE+ "  {"+ NEW_LINE+ "    \"id\" : \"one\","+ NEW_LINE+ "    \"priority\" : 0,"+ NEW_LINE+ "    \"httpRequest\" : {"+ NEW_LINE+ "      \"path\" : \"request_one\""+ NEW_LINE+ "    },"+ NEW_LINE+ "    \"times\" : {"+ NEW_LINE+ "      \"unlimited\" : true"+ NEW_LINE+ "    },"+ NEW_LINE+ "    \"timeToLive\" : {"+ NEW_LINE+ "      \"unlimited\" : true"+ NEW_LINE+ "    },"+ NEW_LINE+ "    \"httpResponse\" : {"+ NEW_LINE+ "      \"statusCode\" : 200,"+ NEW_LINE+ "      \"reasonPhrase\" : \"OK\","+ NEW_LINE+ "      \"body\" : \"response_one\""+ NEW_LINE+ "    }"+ NEW_LINE+ "  }"+ NEW_LINE+ NEW_LINE+ " with id:"+ NEW_LINE+ NEW_LINE+ "  one"+ NEW_LINE+ NEW_LINE,MediaType.PLAIN_TEXT_UTF_8).withStatusCode(200)));
    assertThat(httpState.retrieve(request().withQueryStringParameter("type","active_expectations")),is(response().withBody("[]",MediaType.JSON_UTF_8).withStatusCode(200)));
    assertThat(httpState.firstMatchingExpectation(request("request_one")),nullValue());
  }
  finally {
    ConfigurationProperties.logLevel(originalLevel.name());
  }
}
