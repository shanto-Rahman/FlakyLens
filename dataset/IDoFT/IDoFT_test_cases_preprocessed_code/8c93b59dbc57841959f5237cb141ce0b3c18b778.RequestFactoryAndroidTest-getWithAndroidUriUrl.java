@Test public void getWithAndroidUriUrl(){
assertThat(request.method()).isEqualTo("GET");
assertThat(request.headers().size()).isZero();
assertThat(request.url().toString()).isEqualTo("http://example.com/foo/bar/");
assertThat(request.body()).isNull();
}