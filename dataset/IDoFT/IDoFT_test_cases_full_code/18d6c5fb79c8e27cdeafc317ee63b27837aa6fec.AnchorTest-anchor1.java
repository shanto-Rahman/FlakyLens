@DisplayName("anchor: basic output") @Test public void anchor1(){
  final Tag anchor=anchor().withText("display text").withWidth(2).withAlignment(Alignment.right).withStyleClass("class").withStyle("somestyle").withBackground(Color.fromRGB(255,0,100)).withHyperlink("http://www.schemacrawler.com").make();
  anchor.addAttribute("sometag","customvalue");
  assertThat(anchor.getTagName(),is("a"));
  assertThat(anchor.toString(),is("a"));
  assertThat(anchor.render(TagOutputFormat.html),is("<a sometag='customvalue' style='somestyle' href='http://www.schemacrawler.com' bgcolor='#FF0064' class='class'>display text</a>"));
  assertThat(anchor.render(TagOutputFormat.text),is("display text"));
  assertThat(anchor.render(TagOutputFormat.tsv),is("display text"));
}
