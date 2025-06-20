@Test public void restartWithKeepAlive() throws Exception {
assertThat(response1.get(10,TimeUnit.SECONDS).getRawStatusCode(),equalTo(200));
assertThat(response2.get(10,TimeUnit.SECONDS).getRawStatusCode(),equalTo(200));
}