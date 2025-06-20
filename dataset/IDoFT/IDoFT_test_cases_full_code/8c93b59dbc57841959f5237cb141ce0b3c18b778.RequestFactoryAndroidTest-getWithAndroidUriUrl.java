@Test public void getWithAndroidUriUrl(){
class Example {
    @GET Call<ResponseBody> method(    @Url Uri url){
      return null;
    }
  }
  Request request=buildRequest(Example.class,Uri.parse("foo/bar/"));
  assertThat(request.method()).isEqualTo("GET");
  assertThat(request.headers().size()).isZero();
  assertThat(request.url().toString()).isEqualTo("http://example.com/foo/bar/");
  assertThat(request.body()).isNull();
}
