@Test public void testReadMultipleUsersIndexFilter() throws JsonProcessingException {
assertTrue(usersResult.isSuccess());
assertAll(() -> assertEquals(totalUsersCount,usersPage.getTotalResults()),() -> assertEquals(startIndex,usersPage.getStartIndex()),() -> assertEquals(returnedUsersCount,usersPage.getItemsPerPage()),() -> assertEquals(returnedUsersCount,usersPage.getResources().size()));
}