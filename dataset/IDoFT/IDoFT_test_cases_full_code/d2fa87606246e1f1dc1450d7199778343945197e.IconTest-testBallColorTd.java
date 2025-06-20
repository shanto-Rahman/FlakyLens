@Test public void testBallColorTd() throws Exception {
  HtmlPage p=j.createWebClient().goTo("testBallColorTd");
  DomElement ballColorAborted=p.getElementById("ballColorAborted");
  List<DomElement> ballIcons=StreamSupport.stream(ballColorAborted.getChildElements().spliterator(),false).collect(Collectors.toList());
  assertIconToSvgOkay(ballIcons.get(0).getFirstElementChild(),"icon-aborted icon-lg");
  DomElement statusIcons=p.getElementById("statusIcons");
  List<DomElement> statusIconsList=StreamSupport.stream(statusIcons.getChildElements().spliterator(),false).collect(Collectors.toList());
  assertIconToImageOkay(statusIconsList.get(0).getFirstElementChild(),"/images/svgs/user.svg","icon-user icon-xlg");
  assertIconToImageOkay(statusIconsList.get(1).getFirstElementChild(),"/plugin/12345/icons/s2.png");
}
