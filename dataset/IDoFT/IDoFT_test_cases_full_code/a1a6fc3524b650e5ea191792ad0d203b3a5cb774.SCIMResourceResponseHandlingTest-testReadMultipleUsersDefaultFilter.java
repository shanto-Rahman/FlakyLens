@Test public void testReadMultipleUsersDefaultFilter() throws JsonProcessingException {
  int totalUsersCount=150;
  int returnedUsersCount=100;
  wireMockServer.stubFor(get(urlEqualTo("/Users?startIndex=1&count=100")).willReturn(configureMockedResponse(OK,APPLICATION_JSON_SCIM,new PagedByIndexSearchResult<>(new PagedResult<>(totalUsersCount,generateUsers(returnedUsersCount)),1))));
  final SCIMResponse<PagedByIndexSearchResult<User>> usersResult=SCIMClientService.builder(DEFAULT_URL).build().buildUserRequest().readMultipleUsers();
  assertAll(() -> {
    assertTrue(usersResult.isSuccess());
    PagedByIndexSearchResult<User> usersPage=usersResult.get();
    assertAll(() -> assertEquals(totalUsersCount,usersPage.getTotalResults()),() -> assertEquals(1,usersPage.getStartIndex()),() -> assertEquals(returnedUsersCount,usersPage.getItemsPerPage()),() -> assertEquals(returnedUsersCount,usersPage.getResources().size()));
  }
);
}
