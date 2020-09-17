package com.hellobird.blog.pojo;

import lombok.Data;

@Data
public class Article {

  private String title;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp modifyTime;
  private long id;
  private String istop;
  private String browseVolume;
  private String synopsis;
  private String preface;
  private String imgLazy;

}
