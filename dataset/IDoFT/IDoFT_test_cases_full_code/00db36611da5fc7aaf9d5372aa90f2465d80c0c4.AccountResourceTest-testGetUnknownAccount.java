@Test public void testGetUnknownAccount() throws Exception {
  mock.perform(get("/api/account").accept(MediaType.APPLICATION_JSON)).andExpect(status().isInternalServerError());
}
