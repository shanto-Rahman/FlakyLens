@Test public void testReadAllUsers() throws JsonProcessingException {
assertTrue(usersResult.isSuccess());
assertAll(() -> assertEquals(200,usersPage.getTotalResults()),() -> assertEquals(1,usersPage.getStartIndex()),() -> assertEquals(200,usersPage.getItemsPerPage()),() -> assertEquals(200,usersPage.getResources().size()));
}