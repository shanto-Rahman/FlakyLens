@Test public void asyncRequestThatThrowsUncheckedException() throws Exception {
assertThat(this.registry.get("my.long.request.exception").longTaskTimer().activeTasks()).isEqualTo(1);
assertThat(this.registry.get("http.server.requests").tags("uri","/api/c1/completableFutureException").timer().count()).isEqualTo(1);
assertThat(this.registry.get("my.long.request.exception").longTaskTimer().activeTasks()).isEqualTo(0);
}