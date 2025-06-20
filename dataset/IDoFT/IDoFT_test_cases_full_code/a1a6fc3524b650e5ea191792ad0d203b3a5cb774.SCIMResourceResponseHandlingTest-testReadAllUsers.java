@Test public void testReadAllUsers() throws JsonProcessingException {
  List<User> users=generateUsers(200);
  PagedByIndexSearchResult<User> firstPageResponseEntity=new PagedByIndexSearchResult<>(new PagedResult<>(200,users.stream().limit(100).collect(Collectors.toList())),1);
  PagedByIndexSearchResult<User> secondPageResponseEntity=new PagedByIndexSearchResult<>(new PagedResult<>(200,users.stream().skip(100).limit(100).collect(Collectors.toList())),1);
  wireMockServer.stubFor(get(urlEqualTo("/Users?startIndex=1&count=100")).willReturn(configureMockedResponse(OK,APPLICATION_JSON_SCIM,firstPageResponseEntity)));
  wireMockServer.stubFor(get(urlEqualTo("/Users?startIndex=101&count=100")).willReturn(configureMockedResponse(OK,APPLICATION_JSON_SCIM,secondPageResponseEntity)));
  SCIMClientService scimClientService=SCIMClientService.builder(DEFAULT_URL).build();
  final SCIMResponse<PagedByIndexSearchResult<User>> usersResult=scimClientService.buildUserRequest().readAllUsers();
  assertAll(() -> {
    assertTrue(usersResult.isSuccess());
    PagedByIndexSearchResult<User> usersPage=usersResult.get();
    assertAll(() -> assertEquals(200,usersPage.getTotalResults()),() -> assertEquals(1,usersPage.getStartIndex()),() -> assertEquals(200,usersPage.getItemsPerPage()),() -> assertEquals(200,usersPage.getResources().size()));
  }
);
}
