@Test public void shouldPersistExpectationsToJsonOnUpdate() throws Exception {
  String persistedExpectationsPath=ConfigurationProperties.persistedExpectationsPath();
  ConfigurationProperties.persistExpectations(true);
  ExpectationFileSystemPersistence expectationFileSystemPersistence=null;
  try {
    File persistedExpectations=File.createTempFile("persistedExpectations",".json");
    ConfigurationProperties.persistedExpectationsPath(persistedExpectations.getAbsolutePath());
    expectationFileSystemPersistence=new ExpectationFileSystemPersistence(mockServerLogger,requestMatchers);
    requestMatchers.add(new Expectation(request().withPath("/simpleFirst")).withId("one").thenRespond(response().withBody("some first response")),API);
    requestMatchers.add(new Expectation(request().withPath("/simpleSecond")).withId("two").thenRespond(response().withBody("some second response")),API);
    requestMatchers.add(new Expectation(request().withPath("/simpleThird")).withId("three").thenRespond(response().withBody("some third response")),API);
    requestMatchers.add(new Expectation(request().withPath("/simpleSecondUpdated")).withId("two").thenRespond(response().withBody("some second updated response")),API);
    MILLISECONDS.sleep(1500);
    String expectedFileContents="[ {" + NEW_LINE + "  \"id\" : \"one\","+ NEW_LINE+ "  \"priority\" : 0,"+ NEW_LINE+ "  \"httpRequest\" : {"+ NEW_LINE+ "    \"path\" : \"/simpleFirst\""+ NEW_LINE+ "  },"+ NEW_LINE+ "  \"times\" : {"+ NEW_LINE+ "    \"unlimited\" : true"+ NEW_LINE+ "  },"+ NEW_LINE+ "  \"timeToLive\" : {"+ NEW_LINE+ "    \"unlimited\" : true"+ NEW_LINE+ "  },"+ NEW_LINE+ "  \"httpResponse\" : {"+ NEW_LINE+ "    \"body\" : \"some first response\""+ NEW_LINE+ "  }"+ NEW_LINE+ "}, {"+ NEW_LINE+ "  \"id\" : \"two\","+ NEW_LINE+ "  \"priority\" : 0,"+ NEW_LINE+ "  \"httpRequest\" : {"+ NEW_LINE+ "    \"path\" : \"/simpleSecondUpdated\""+ NEW_LINE+ "  },"+ NEW_LINE+ "  \"times\" : {"+ NEW_LINE+ "    \"unlimited\" : true"+ NEW_LINE+ "  },"+ NEW_LINE+ "  \"timeToLive\" : {"+ NEW_LINE+ "    \"unlimited\" : true"+ NEW_LINE+ "  },"+ NEW_LINE+ "  \"httpResponse\" : {"+ NEW_LINE+ "    \"body\" : \"some second updated response\""+ NEW_LINE+ "  }"+ NEW_LINE+ "}, {"+ NEW_LINE+ "  \"id\" : \"three\","+ NEW_LINE+ "  \"priority\" : 0,"+ NEW_LINE+ "  \"httpRequest\" : {"+ NEW_LINE+ "    \"path\" : \"/simpleThird\""+ NEW_LINE+ "  },"+ NEW_LINE+ "  \"times\" : {"+ NEW_LINE+ "    \"unlimited\" : true"+ NEW_LINE+ "  },"+ NEW_LINE+ "  \"timeToLive\" : {"+ NEW_LINE+ "    \"unlimited\" : true"+ NEW_LINE+ "  },"+ NEW_LINE+ "  \"httpResponse\" : {"+ NEW_LINE+ "    \"body\" : \"some third response\""+ NEW_LINE+ "  }"+ NEW_LINE+ "} ]";
    assertThat(persistedExpectations.getAbsolutePath() + " does not match expected content",new String(Files.readAllBytes(persistedExpectations.toPath()),StandardCharsets.UTF_8),is(expectedFileContents));
  }
  finally {
    ConfigurationProperties.persistedExpectationsPath(persistedExpectationsPath);
    ConfigurationProperties.persistExpectations(false);
    if (expectationFileSystemPersistence != null) {
      expectationFileSystemPersistence.stop();
    }
  }
}
