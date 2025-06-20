@DisplayName("anchor: escape text, emphasize, and allow free width") @Test public void anchor2(){
  final Tag anchor=anchor().withEscapedText("display & text").withAlignment(Alignment.right).withEmphasis().withHyperlink("http://www.schemacrawler.com").make();
  anchor.addAttribute("sometag","custom&value");
  assertThat(anchor.render(TagOutputFormat.html),is("<a sometag='custom&value' href='http://www.schemacrawler.com' align='right'><b><i>display &amp; text</i></b></a>"));
  assertThat(anchor.render(TagOutputFormat.text),is("display & text"));
  assertThat(anchor.render(TagOutputFormat.tsv),is("display & text"));
}
