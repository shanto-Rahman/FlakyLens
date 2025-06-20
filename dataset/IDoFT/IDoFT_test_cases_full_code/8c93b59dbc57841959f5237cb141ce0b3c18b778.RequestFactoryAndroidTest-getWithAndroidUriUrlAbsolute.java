@Test public void getWithAndroidUriUrlAbsolute(){
class Example {
    @GET Call<ResponseBody> method(    @Url Uri url){
      return null;
    }
  }
  Request request=buildRequest(Example.class,Uri.parse("https://example2.com/foo/bar/"));
  assertThat(request.method()).isEqualTo("GET");
  assertThat(request.headers().size()).isZero();
  assertThat(request.url().toString()).isEqualTo("https://example2.com/foo/bar/");
  assertThat(request.body()).isNull();
}
