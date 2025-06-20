@Test public void getWithAndroidUriUrlAbsolute(){
assertThat(request.method()).isEqualTo("GET");
assertThat(request.headers().size()).isZero();
assertThat(request.url().toString()).isEqualTo("https://example2.com/foo/bar/");
assertThat(request.body()).isNull();
}