# 获取全部索引
    GET /_cat/indices?v
# DSL的格式：
  其中index_name指的是Elasticsearch中的索引名，我们歌曲对应的索引名通过@Document注解指定为了songs
  GET /index_name/_search {json请求体数据}

# 无条件查询，默认返回10条数据
    GET /songs/_search
    {
      "query": {
        "match_all": {}
      }
    }
   返回的数据格式：为了避免太占位置，只查询了5条记录。
   hits里是查询结果信息，hits.total.value表示符合查询条件的总记录数，hits.hits表示的是返回的数据，_source里是具体的数据。

# 指定返回的数据条数
  通过size指定需要返回的结果数，以下查询语句将会返回20条数据，而非默认的10条
  GET /songs/_search
  {
    "query": {
      "match_all": {}
    },
    "size": 20
  }

# 指定查询字段
  _source是一个数组，指定需要返回哪些字段，设置为false则不会返回数据。
  GET /songs/_search
  {
    "query": {
      "match_all": {}
    },
    "size": 5,
    "_source": ["name", "singer", "note"]
  }

# 分页查询
  通过from+size实现分页查询，下面查询了第6-10条记录，相当于mysql中的limit 5, 5（和mysql类似，from默认为0）
  GET /songs/_search
  {
    "query": {
      "match_all": {}
    },
    "from": 5,
    "size": 5
  }

# 查询指定ID的数据
    GET /songs/_doc/20210522155349

# 删除索引
    DELETE /songs

# 条件查询
    以下是查询歌曲名中包含“爱”字的歌曲，不指定返回的结果数则默认返回前10条。
    GET /songs/_search
    {
      "query": {
        "match": {
          "name": "爱"
        }
      }
    }