# API（精确查询）
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

# API（模糊查询）
## paper
### 基本说明
| 接口地址 | http://localhost:8080/api/paper              |
| -------- | -------------------------------------------- |
| 返回格式 | JSON                                         |
| 请求方式 | POST                                         |
| 请求示例 | http://localhost:8080/api/paper?title=Emotion&limitStart=0&limitEnd=20 |

### 请求参数说明
> limitStart 与 limitEnd 的意义是将结果分页，例如 0,20 
> 就是将结果的第 1 个到第 20 个取出来
> limitEnd 可以超过结果数


| 名称 | 类型 | 必填 | 说明      |
| ---- | ---- | ---- | ----------- |
| title   | String  | 是  | 模糊标题 |
| limitStart   | int  | 是  | 分页起始行 |
| limitEnd   | int  | 是  | 分页结束行 |

### 返回参数说明
| 名称  | 类型 | 说明   |
| ------- | ------ | -------- |
| code    | int    | 状态码 |
| message | String | 状态信息 |
| id   | double | paper 的 id |
| title  | Object | 完整标题   |
| abstract_content | String | 摘要   |
| pdf_url | String | PDF链接 |
| date | String | 日期 |

### JSON返回示例
```json
{
  "code": 211,
  "paper": [
    {
      "id": 1203.2293,
      "title": "Categories of Emotion names in Web retrieved texts",
      "abstract_content": "The categorization of emotion names, i.e., the grouping of emotion words that have similar emotional connotations together, is a key tool of Social Psychology used to explore people's knowledge about emotions. Without exception, the studies following that research line were based on the gauging of the perceived similarity between emotion names by the participants of the experiments. Here we propose and examine a new approach to study the categories of emotion names - the similarities between target emotion names are obtained by comparing the contexts in which they appear in texts retrieved from the World Wide Web. This comparison does not account for any explicit semantic information; it simply counts the number of common words or lexical items used in the contexts. This procedure allows us to write the entries of the similarity matrix as dot products in a linear vector space of contexts. The properties of this matrix were then explored using Multidimensional Scaling Analysis and Hierarchical Clustering. Our main findings, namely, the underlying dimension of the emotion space and the categories of emotion names, were consistent with those based on people's judgments of emotion names similarities.",
      "pdf_url": "http://arxiv.org/pdf/1203.2293v1.pdf",
      "date": "2012-03-11 00:00:00"
    },
    {
      "id": 1303.1761,
      "title": "Improving Automatic Emotion Recognition from speech using Rhythm and\n  Temporal feature",
      "abstract_content": "This paper is devoted to improve automatic emotion recognition from speech by incorporating rhythm and temporal features. Research on automatic emotion recognition so far has mostly been based on applying features like MFCCs, pitch and energy or intensity. The idea focuses on borrowing rhythm features from linguistic and phonetic analysis and applying them to the speech signal on the basis of acoustic knowledge only. In addition to this we exploit a set of temporal and loudness features. A segmentation unit is employed in starting to separate the voiced/unvoiced and silence parts and features are explored on different segments. Thereafter different classifiers are used for classification. After selecting the top features using an IGR filter we are able to achieve a recognition rate of 80.60 % on the Berlin Emotion Database for the speaker dependent framework.",
      "pdf_url": "http://arxiv.org/pdf/1303.1761v1.pdf",
      "date": "2013-03-07 00:00:00"
    },
    {
      "id": 1309.2853,
      "title": "General Purpose Textual Sentiment Analysis and Emotion Detection Tools",
      "abstract_content": "Textual sentiment analysis and emotion detection consists in retrieving the sentiment or emotion carried by a text or document. This task can be useful in many domains: opinion mining, prediction, feedbacks, etc. However, building a general purpose tool for doing sentiment analysis and emotion detection raises a number of issues, theoretical issues like the dependence to the domain or to the language but also pratical issues like the emotion representation for interoperability. In this paper we present our sentiment/emotion analysis tools, the way we propose to circumvent the di culties and the applications they are used for.",
      "pdf_url": "http://arxiv.org/pdf/1309.2853v1.pdf",
      "date": "2013-09-11 00:00:00"
    }
  ],
  "message": "数据获取成功"
}
```