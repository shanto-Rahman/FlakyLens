@Test public void verifyShouldUseProxyTarget() throws Exception {
  Long d1=this.dateService.getDate(false);
  Thread.sleep(200);
  Long d2=this.dateService.getDate(false);
  assertThat(d1).isEqualTo(d2);
  verify(this.dateService,times(1)).getDate(false);
  verify(this.dateService,times(1)).getDate(matchesFalse());
  verify(this.dateService,times(1)).getDate(matchesAnyBoolean());
}
