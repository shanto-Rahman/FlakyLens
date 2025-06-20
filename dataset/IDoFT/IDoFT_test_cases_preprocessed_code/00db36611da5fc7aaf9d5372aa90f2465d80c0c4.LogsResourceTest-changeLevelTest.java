@Test public void changeLevelTest() throws Exception {
assertTrue(res.getResponse().getContentAsString().contains("\"name\":\"" + logger.getName() + "\",\"level\":\""+ logger.getLevel()+ "\""));
}