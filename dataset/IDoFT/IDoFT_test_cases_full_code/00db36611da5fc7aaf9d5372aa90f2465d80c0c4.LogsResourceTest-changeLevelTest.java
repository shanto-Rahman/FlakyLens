@Test public void changeLevelTest() throws Exception {
  LoggerVM logger=new LoggerVM();
  logger.setLevel("ERROR");
  logger.setName("ROOT");
  mock.perform(put("/management/logs").contentType(MediaType.APPLICATION_JSON_UTF8).content(new ObjectMapper().writeValueAsString(logger))).andExpect(status().isNoContent());
  MvcResult res=mock.perform(get("/management/logs").accept(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andReturn();
  assertTrue(res.getResponse().getContentAsString().contains("\"name\":\"" + logger.getName() + "\",\"level\":\""+ logger.getLevel()+ "\""));
}
