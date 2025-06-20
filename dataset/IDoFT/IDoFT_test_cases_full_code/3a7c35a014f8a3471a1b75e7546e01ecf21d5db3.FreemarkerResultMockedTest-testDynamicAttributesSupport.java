public void testDynamicAttributesSupport() throws Exception {
  File file=new File(FreeMarkerResultTest.class.getResource("dynaAttributes.ftl").toURI());
  EasyMock.expect(servletContext.getRealPath("/tutorial/org/apache/struts2/views/freemarker/dynaAttributes.ftl")).andReturn(file.getAbsolutePath());
  file=new File(ClassLoaderUtil.getResource("template/simple/text.ftl",getClass()).toURI());
  EasyMock.expect(servletContext.getRealPath("/template/simple/text.ftl")).andReturn(file.getAbsolutePath());
  file=new File(ClassLoaderUtil.getResource("template/simple/css.ftl",getClass()).toURI());
  EasyMock.expect(servletContext.getRealPath("/template/simple/css.ftl")).andReturn(file.getAbsolutePath());
  EasyMock.expect(servletContext.getRealPath("/template/~~~simple/css.ftl")).andReturn(file.getAbsolutePath());
  file=new File(ClassLoaderUtil.getResource("template/simple/scripting-events.ftl",getClass()).toURI());
  EasyMock.expect(servletContext.getRealPath("/template/simple/scripting-events.ftl")).andReturn(file.getAbsolutePath());
  EasyMock.expect(servletContext.getRealPath("/template/~~~simple/scripting-events.ftl")).andReturn(file.getAbsolutePath());
  file=new File(ClassLoaderUtil.getResource("template/simple/common-attributes.ftl",getClass()).toURI());
  EasyMock.expect(servletContext.getRealPath("/template/simple/common-attributes.ftl")).andReturn(file.getAbsolutePath());
  EasyMock.expect(servletContext.getRealPath("/template/~~~simple/common-attributes.ftl")).andReturn(file.getAbsolutePath());
  file=new File(ClassLoaderUtil.getResource("template/simple/dynamic-attributes.ftl",getClass()).toURI());
  EasyMock.expect(servletContext.getRealPath("/template/simple/dynamic-attributes.ftl")).andReturn(file.getAbsolutePath());
  EasyMock.expect(servletContext.getRealPath("/template/~~~simple/dynamic-attributes.ftl")).andReturn(file.getAbsolutePath());
  EasyMock.replay(servletContext);
  init();
  request.setRequestURI("/tutorial/test6.action");
  ActionMapping mapping=container.getInstance(ActionMapper.class).getMapping(request,configurationManager);
  dispatcher.serviceAction(request,response,mapping);
  String expectedJDK17="<input type=\"text\" name=\"test\" value=\"\" id=\"test\" placeholder=\"input\" foo=\"bar\"/>" + "<input type=\"text\" name=\"test\" value=\"\" id=\"test\" placeholder=\"input\" foo=\"bar\"/>" + "<input type=\"text\" name=\"test\" value=\"\" id=\"test\" break=\"true\"/>"+ "<input type=\"text\" name=\"required\" value=\"\" id=\"required\" required=\"true\"/>";
  String expectedJDK18="<input type=\"text\" name=\"test\" value=\"\" id=\"test\" foo=\"bar\" placeholder=\"input\"/>" + "<input type=\"text\" name=\"test\" value=\"\" id=\"test\" foo=\"bar\" placeholder=\"input\"/>" + "<input type=\"text\" name=\"test\" value=\"\" id=\"test\" break=\"true\"/>"+ "<input type=\"text\" name=\"required\" value=\"\" id=\"required\" required=\"true\"/>";
  String result=stringWriter.toString();
  if (result.contains("id=\"test\" foo=\"bar\"")) {
    assertEquals(expectedJDK18,result);
  }
 else {
    assertEquals(expectedJDK17,result);
  }
}
