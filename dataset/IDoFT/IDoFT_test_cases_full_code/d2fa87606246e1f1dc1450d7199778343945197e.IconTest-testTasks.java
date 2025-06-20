@Test public void testTasks() throws Exception {
  HtmlPage p=j.createWebClient().goTo("testTasks");
  DomElement tasksDiv=p.getElementById("tasks");
  List<DomElement> taskDivs=StreamSupport.stream(tasksDiv.getChildElements().spliterator(),false).collect(Collectors.toList());
  assertIconToImageOkay(taskDivs.get(0).getElementsByTagName("img").get(0),"/images/svgs/up.svg","icon-up icon-md");
  assertIconToImageOkay(taskDivs.get(1).getElementsByTagName("img").get(0),"/images/24x24/folder.png","icon-folder icon-md");
  assertIconToImageOkay(taskDivs.get(2).getElementsByTagName("img").get(0),"/images/svgs/package.svg","icon-package icon-xlg");
  assertIconToImageOkay(taskDivs.get(3).getElementsByTagName("img").get(0),"/images/svgs/package.svg","icon-package icon-xlg");
  assertIconToImageOkay(taskDivs.get(4).getElementsByTagName("img").get(0),"/images/svgs/package.svg","icon-package icon-xlg");
  assertIconToImageOkay(taskDivs.get(5).getElementsByTagName("img").get(0),"/plugin/xxx/icon.png");
  assertIconToImageOkay(taskDivs.get(6).getElementsByTagName("img").get(0),"/plugin/xxx/icon.png");
}
