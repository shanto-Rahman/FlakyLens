@Test public void shouldMapHttpServletRequestToHttpRequest(){
assertEquals(string("/requestURI"),httpRequest.getPath());
assertEquals(new ParameterBody(new Parameter("bodyParameterNameOne","bodyParameterValueOne_One"),new Parameter("bodyParameterNameOne","bodyParameterValueOne_Two"),new Parameter("bodyParameterNameTwo","bodyParameterValueTwo_One")).toString(),httpRequest.getBody().toString());
assertEquals(Arrays.asList(new Parameter("queryStringParameterNameOne","queryStringParameterValueOne_One","queryStringParameterValueOne_Two"),new Parameter("queryStringParameterNameTwo","queryStringParameterValueTwo_One")),httpRequest.getQueryStringParameterList());
assertEquals(Lists.newArrayList(new Header("headerName1","headerValue1_1","headerValue1_2"),new Header("headerName2","headerValue2"),new Header("Content-Type","multipart/form-data"),new Header("Cookie","cookieName1=cookieValue1; cookieName2=cookieValue2")),httpRequest.getHeaderList());
assertEquals(Lists.newArrayList(new Cookie("cookieName1","cookieValue1"),new Cookie("cookieName2","cookieValue2")),httpRequest.getCookieList());
}