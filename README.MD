# API
## paper
### 基本说明

| 接口地址 | http://localhost:8080/api/paper              |
| -------- | -------------------------------------------- |
| 返回格式 | JSON                                         |
| 请求方式 | POST                                         |
| 请求示例 | http://localhost:8080/api/paper?id=1203.2293 |

### 请求参数说明
| 名称 | 类型 | 必填 | 说明      |
| ---- | ---- | ---- | ----------- |
| id   | double  | 是  | paper 的 id |

### 返回参数说明
| 名称  | 类型 | 说明   |
| ------- | ------ | -------- |
| code    | int    | 状态码 |
| paper   | Object | paper    |
| author  | Object | 作者   |
| tag     | Object | 标签   |
| message | String | 状态信息 |

### JSON返回示例
```json
{
  "code": 211,
  "paper": {
    "id": 1203,
    "title": "Categories of Emotion names in Web retrieved texts",
    "abstract_content": "The categorization of emotion names, i.e., the grouping of emotion words that have similar emotional connotations together, is a key tool of Social Psychology used to explore people's knowledge about emotions. Without exception, the studies following that research line were based on the gauging of the perceived similarity between emotion names by the participants of the experiments. Here we propose and examine a new approach to study the categories of emotion names - the similarities between target emotion names are obtained by comparing the contexts in which they appear in texts retrieved from the World Wide Web. This comparison does not account for any explicit semantic information; it simply counts the number of common words or lexical items used in the contexts. This procedure allows us to write the entries of the similarity matrix as dot products in a linear vector space of contexts. The properties of this matrix were then explored using Multidimensional Scaling Analysis and Hierarchical Clustering. Our main findings, namely, the underlying dimension of the emotion space and the categories of emotion names, were consistent with those based on people's judgments of emotion names similarities.",
    "pdf_url": "http://arxiv.org/pdf/1203.2293v1.pdf",
    "date": "2012-03-11 00:00:00"
  },
  "author": [
    {
      "name": "Sergey Petrov"
    },
    {
      "name": "Jose F. Fontanari"
    },
    {
      "name": "Leonid I. Perlovsky"
    }
  ],
  "tag": [
    {
      "name": "cs.CL"
    },
    {
      "name": "cs.IR"
    }
  ],
  "message": "数据获取成功"
}
```

## author
### 基本说明
| 接口地址 | http://localhost:8080/api/author              |
| -------- | -------------------------------------------- |
| 返回格式 | JSON                                         |
| 请求方式 | POST                                         |
| 请求示例 | http://localhost:8080/api/author?id=1203.2293 |

### 请求参数说明
| 名称 | 类型 | 必填 | 说明      |
| ---- | ---- | ---- | ----------- |
| id   | double  | 是  | paper 的 id |

### 返回参数说明
| 名称  | 类型 | 说明   |
| ------- | ------ | -------- |
| code    | int    | 状态码 |
| author  | Object | 作者   |
| message | String | 状态信息 |

### JSON返回示例
```json
{
  "code": 211,
  "author": [
    {
      "name": "Sergey Petrov"
    },
    {
      "name": "Jose F. Fontanari"
    },
    {
      "name": "Leonid I. Perlovsky"
    }
  ],
  "message": "数据获取成功"
}
```

## tag
### 基本说明
| 接口地址 | http://localhost:8080/api/tag              |
| -------- | -------------------------------------------- |
| 返回格式 | JSON                                         |
| 请求方式 | POST                                         |
| 请求示例 | http://localhost:8080/api/tag?id=1203.2293 |

### 请求参数说明
| 名称 | 类型 | 必填 | 说明      |
| ---- | ---- | ---- | ----------- |
| id   | double  | 是  | paper 的 id |

### 返回参数说明
| 名称  | 类型 | 说明   |
| ------- | ------ | -------- |
| code    | int    | 状态码 |
| tag  | Object | 作者   |
| message | String | 状态信息 |

### JSON返回示例
```json
{
    "code": 211,
    "tag": [
        {
            "name": "cs.CL"
        },
        {
            "name": "cs.IR"
        }
    ],
    "message": "数据获取成功"
}
```