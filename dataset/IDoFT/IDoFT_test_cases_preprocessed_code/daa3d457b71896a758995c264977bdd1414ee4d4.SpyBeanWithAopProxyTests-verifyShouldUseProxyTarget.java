@Test public void verifyShouldUseProxyTarget() throws Exception {
Long d1=this.dateService.getDate(false);//IT
Thread.sleep(200);
Long d2=this.dateService.getDate(false);//IT
assertThat(d1).isEqualTo(d2);
}