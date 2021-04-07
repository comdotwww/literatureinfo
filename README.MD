# 介绍
从文献网站 http://www.arxiv-sanity.com/ 爬取文献信息保存到数据库，
用户可以在网页上浏览最新的文献，
另外用户还可以根据论文的题目，作者，标签等查询论文。

![source](source.png)

> 我主要负责后端接口（ API ）的实现

# 数据库设计
## paper表
| 字段 | 类型 | 描述 |
| --- | --- | --- |
| paper_id（主键） | varchar | 论文的id |
| title | varchar | 论文标题 |
| abstract_content | TEXT | 论文摘要内容 |
| pdf_url | varchar | PDF地址 |
| date | Date | 论文日期 |

## paper-author表

| 字段 | 类型 | 描述 |
| --- | --- | --- |
| paper_id | varchar | 论文id |
| author_name | varchar | 作者id |
| record_id | bigint | 主键 |

## paper-tag表
| 字段 | 类型 | 描述 |
| --- | --- | --- |
| paper_id | varchar | 论文id |
| tag_name | varchar | tag name |
| record_id | bigint | 主键 |

## user表

| 字段 | 类型 | 描述 |
| --- | --- | --- |
| user_id | int | 用户id(主键) |
| role_id | int | 角色id |
| user_name | varchar | 用户名称 |
| password | varchar | 用户密码 |

# API（精确查询）
> 状态码

| code | message                 |
| ---- | ----------------------- |
| 211  | 数据获取成功      |
| 212  | 数据获取失败      |
| 213  | 数据修改成功      |
| 214  | 数据修改失败      |
| 215  | 数据添加成功      |
| 216  | 数据添加失败      |
| 217  | 数据删除成功      |
| 218  | 数据删除失败      |


## paper----id
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

## author----id
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

## tag----id
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

## paper----tag
### 基本说明
| 接口地址 | http://localhost:8080/api/paper              |
| -------- | -------------------------------------------- |
| 返回格式 | JSON                                         |
| 请求方式 | POST                                         |
| 请求示例 | http://localhost:8080/api/paper?tag=stat.ME&limitStart=0&limitEnd=4 |

### 请求参数说明
> limitStart 与 limitEnd 的意义是将结果分页，例如 0,20
> 就是将结果的第 1 个到第 20 个取出来
> limitEnd 可以超过结果数

| 名称 | 类型 | 必填 | 说明      |
| ---- | ---- | ---- | ----------- |
| tag   | String  | 是  | 标签 |
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
| date | String | 日期,paper按日期由新到旧 |
| author | String | 作者 |
| tag | String | 标签 |

### JSON返回示例
```json
{
  "code": 211,
  "paper": [
    {
      "paper": {
        "id": 2104.00683,
        "title": "SimPoE: Simulated Character Control for 3D Human Pose Estimation",
        "abstract_content": "Accurate estimation of 3D human motion from monocular video requires modeling both kinematics (body motion without physical forces) and dynamics (motion with physical forces). To demonstrate this, we present SimPoE, a Simulation-based approach for 3D human Pose Estimation, which integrates image-based kinematic inference and physics-based dynamics modeling. SimPoE learns a policy that takes as input the current-frame pose estimate and the next image frame to control a physically-simulated character to output the next-frame pose estimate. The policy contains a learnable kinematic pose refinement unit that uses 2D keypoints to iteratively refine its kinematic pose estimate of the next frame. Based on this refined kinematic pose, the policy learns to compute dynamics-based control (e.g., joint torques) of the character to advance the current-frame pose estimate to the pose estimate of the next frame. This design couples the kinematic pose refinement unit with the dynamics-based control generation unit, which are learned jointly with reinforcement learning to achieve accurate and physically-plausible pose estimation. Furthermore, we propose a meta-control mechanism that dynamically adjusts the character's dynamics parameters based on the character state to attain more accurate pose estimates. Experiments on large-scale motion datasets demonstrate that our approach establishes the new state of the art in pose accuracy while ensuring physical plausibility.",
        "pdf_url": "http://arxiv.org/pdf/2104.00683v1.pdf",
        "date": "2021-04-01 00:00:00"
      },
      "author": [
        {
          "name": "Ye Yuan"
        },
        {
          "name": "Shih-En Wei"
        },
        {
          "name": "Tomas Simon"
        },
        {
          "name": "Kris Kitani"
        },
        {
          "name": "Jason Saragih"
        }
      ],
      "tag": [
        {
          "name": "cs.LG"
        },
        {
          "name": "cs.CV"
        }
      ]
    },
    {
      "paper": {
        "id": 2104.00682,
        "title": "Multiview Pseudo-Labeling for Semi-supervised Learning from Video",
        "abstract_content": "We present a multiview pseudo-labeling approach to video learning, a novel framework that uses complementary views in the form of appearance and motion information for semi-supervised learning in video. The complementary views help obtain more reliable pseudo-labels on unlabeled video, to learn stronger video representations than from purely supervised data. Though our method capitalizes on multiple views, it nonetheless trains a model that is shared across appearance and motion input and thus, by design, incurs no additional computation overhead at inference time. On multiple video recognition datasets, our method substantially outperforms its supervised counterpart, and compares favorably to previous work on standard benchmarks in self-supervised video representation learning.",
        "pdf_url": "http://arxiv.org/pdf/2104.00682v1.pdf",
        "date": "2021-04-01 00:00:00"
      },
      "author": [
        {
          "name": "Bo Xiong"
        },
        {
          "name": "Haoqi Fan"
        },
        {
          "name": "Kristen Grauman"
        },
        {
          "name": "Christoph Feichtenhofer"
        }
      ],
      "tag": [
        {
          "name": "cs.CV"
        },
        {
          "name": "cs.AI"
        },
        {
          "name": "cs.LG"
        }
      ]
    },
    {
      "paper": {
        "id": 2104.00681,
        "title": "NeuralRecon: Real-Time Coherent 3D Reconstruction from Monocular Video",
        "abstract_content": "We present a novel framework named NeuralRecon for real-time 3D scene reconstruction from a monocular video. Unlike previous methods that estimate single-view depth maps separately on each key-frame and fuse them later, we propose to directly reconstruct local surfaces represented as sparse TSDF volumes for each video fragment sequentially by a neural network. A learning-based TSDF fusion module based on gated recurrent units is used to guide the network to fuse features from previous fragments. This design allows the network to capture local smoothness prior and global shape prior of 3D surfaces when sequentially reconstructing the surfaces, resulting in accurate, coherent, and real-time surface reconstruction. The experiments on ScanNet and 7-Scenes datasets show that our system outperforms state-of-the-art methods in terms of both accuracy and speed. To the best of our knowledge, this is the first learning-based system that is able to reconstruct dense coherent 3D geometry in real-time.",
        "pdf_url": "http://arxiv.org/pdf/2104.00681v1.pdf",
        "date": "2021-04-01 00:00:00"
      },
      "author": [
        {
          "name": "Jiaming Sun"
        },
        {
          "name": "Yiming Xie"
        },
        {
          "name": "Linghao Chen"
        },
        {
          "name": "Xiaowei Zhou"
        },
        {
          "name": "Hujun Bao"
        }
      ],
      "tag": [
        {
          "name": "cs.CV"
        },
        {
          "name": "cs.RO"
        }
      ]
    },
    {
      "paper": {
        "id": 2104.0068,
        "title": "LoFTR: Detector-Free Local Feature Matching with Transformers",
        "abstract_content": "We present a novel method for local image feature matching. Instead of performing image feature detection, description, and matching sequentially, we propose to first establish pixel-wise dense matches at a coarse level and later refine the good matches at a fine level. In contrast to dense methods that use a cost volume to search correspondences, we use self and cross attention layers in Transformer to obtain feature descriptors that are conditioned on both images. The global receptive field provided by Transformer enables our method to produce dense matches in low-texture areas, where feature detectors usually struggle to produce repeatable interest points. The experiments on indoor and outdoor datasets show that LoFTR outperforms state-of-the-art methods by a large margin. LoFTR also ranks first on two public benchmarks of visual localization among the published methods.",
        "pdf_url": "http://arxiv.org/pdf/2104.00680v1.pdf",
        "date": "2021-04-01 00:00:00"
      },
      "author": [
        {
          "name": "Jiaming Sun"
        },
        {
          "name": "Zehong Shen"
        },
        {
          "name": "Yuang Wang"
        },
        {
          "name": "Hujun Bao"
        },
        {
          "name": "Xiaowei Zhou"
        }
      ],
      "tag": [
        {
          "name": "cs.CV"
        },
        {
          "name": "cs.RO"
        }
      ]
    }
  ],
  "message": "数据获取成功"
}
```

## paper----tag&date
### 基本说明
| 接口地址 | http://localhost:8080/api/paper              |
| -------- | -------------------------------------------- |
| 返回格式 | JSON                                         |
| 请求方式 | POST                                         |
| 请求示例 | http://localhost:8080/api/paper?tag=cs.LG&date=2021-04-01&limitStart=0&limitEnd=4 |

### 请求参数说明
> limitStart 与 limitEnd 的意义是将结果分页，例如 0,20
> 就是将结果的第 1 个到第 20 个取出来
> limitEnd 可以超过结果数

| 名称 | 类型 | 必填 | 说明      |
| ---- | ---- | ---- | ----------- |
| tag   | String  | 是  | 标签 |
| date   | String  | 是  | 日期，格式为YYYY-MM-DD,例2021-04-01 |
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
| date | String | 日期,paper按日期由新到旧 |
| author | String | 作者 |
| tag | String | 标签 |

### JSON返回示例
```json
{
  "code": 211,
  "paper": [
    {
      "paper": {
        "id": 2005.13298,
        "title": "Iteratively Optimized Patch Label Inference Network for Automatic\n  Pavement Disease Detection",
        "abstract_content": "We present a novel deep learning framework named the Iteratively Optimized Patch Label Inference Network (IOPLIN) for automatically detecting various pavement diseases that are not solely limited to specific ones, such as cracks and potholes. IOPLIN can be iteratively trained with only the image label via the Expectation-Maximization Inspired Patch Label Distillation (EMIPLD) strategy, and accomplish this task well by inferring the labels of patches from the pavement images. IOPLIN enjoys many desirable properties over the state-of-the-art single branch CNN models such as GoogLeNet and EfficientNet. It is able to handle images in different resolutions, and sufficiently utilize image information particularly for the high-resolution ones, since IOPLIN extracts the visual features from unrevised image patches instead of the resized entire image. Moreover, it can roughly localize the pavement distress without using any prior localization information in the training phase. In order to better evaluate the effectiveness of our method in practice, we construct a large-scale Bituminous Pavement Disease Detection dataset named CQU-BPDD consisting of 60,059 high-resolution pavement images, which are acquired from different areas at different times. Extensive results on this dataset demonstrate the superiority of IOPLIN over the state-of-the-art image classification approaches in automatic pavement disease detection. The source codes of IOPLIN are released on \\url{https://github.com/DearCaat/ioplin}.",
        "pdf_url": "http://arxiv.org/pdf/2005.13298v2.pdf",
        "date": "2021-04-01 00:00:00"
      },
      "author": [
        {
          "name": "Wenhao Tang"
        },
        {
          "name": "Sheng Huang"
        },
        {
          "name": "Qiming Zhao"
        },
        {
          "name": "Ren Li"
        },
        {
          "name": "Luwen Huangfu"
        }
      ],
      "tag": [
        {
          "name": "cs.CV"
        }
      ]
    },
    {
      "paper": {
        "id": 1910.12468,
        "title": "Image-Based Place Recognition on Bucolic Environment Across Seasons From\n  Semantic Edge Description",
        "abstract_content": "Most of the research effort on image-based place recognition is designed for urban environments. In bucolic environments such as natural scenes with low texture and little semantic content, the main challenge is to handle the variations in visual appearance across time such as illumination, weather, vegetation state or viewpoints. The nature of the variations is different and this leads to a different approach to describing a bucolic scene. We introduce a global image descriptor computed from its semantic and topological information. It is built from the wavelet transforms of the image semantic edges. Matching two images is then equivalent to matching their semantic edge descriptors. We show that this method reaches state-of-the-art image retrieval performance on two multi-season environment-monitoring datasets: the CMU-Seasons and the Symphony Lake dataset. It also generalises to urban scenes on which it is on par with the current baselines NetVLAD and DELF.",
        "pdf_url": "http://arxiv.org/pdf/1910.12468v5.pdf",
        "date": "2021-04-01 00:00:00"
      },
      "author": [
        {
          "name": "Assia Benbihi"
        },
        {
          "name": "Stéphanie Aravecchia"
        },
        {
          "name": "Matthieu Geist"
        },
        {
          "name": "Cédric Pradalier"
        }
      ],
      "tag": [
        {
          "name": "cs.CV"
        }
      ]
    },
    {
      "paper": {
        "id": 1903.06262,
        "title": "Distance Preserving Grid Layouts",
        "abstract_content": "Distance preserving visualization techniques have emerged as one of the fundamental tools for data analysis. One example are the techniques that arrange data instances into two-dimensional grids so that the pairwise distances among the instances are preserved into the produced layouts. Currently, the state-of-the-art approaches produce such grids by solving assignment problems or using permutations to optimize cost functions. Although precise, such strategies are computationally expensive, limited to small datasets or being dependent on specialized hardware to speed up the process. In this paper, we present a new technique, called Distance-preserving Grid (DGrid), that employs a binary space partitioning process in combination with multidimensional projections to create orthogonal regular grid layouts. Our results show that DGrid is as precise as the existing state-of-the-art techniques whereas requiring only a fraction of the running time and computational resources.",
        "pdf_url": "http://arxiv.org/pdf/1903.06262v3.pdf",
        "date": "2021-04-01 00:00:00"
      },
      "author": [
        {
          "name": "Gladys Hilasaca"
        },
        {
          "name": "Fernando V. Paulovich"
        }
      ],
      "tag": [
        {
          "name": "cs.CV"
        }
      ]
    },
    {
      "paper": {
        "id": 1810.02897,
        "title": "CDF Transform-and-Shift: An effective way to deal with datasets of\n  inhomogeneous cluster densities",
        "abstract_content": "The problem of inhomogeneous cluster densities has been a long-standing issue for distance-based and density-based algorithms in clustering and anomaly detection. These algorithms implicitly assume that all clusters have approximately the same density. As a result, they often exhibit a bias towards dense clusters in the presence of sparse clusters. Many remedies have been suggested; yet, we show that they are partial solutions which do not address the issue satisfactorily. To match the implicit assumption, we propose to transform a given dataset such that the transformed clusters have approximately the same density while all regions of locally low density become globally low density -- homogenising cluster density while preserving the cluster structure of the dataset. We show that this can be achieved by using a new multi-dimensional Cumulative Distribution Function in a transform-and-shift method. The method can be applied to every dataset, before the dataset is used in many existing algorithms to match their implicit assumption without algorithmic modification. We show that the proposed method performs better than existing remedies.",
        "pdf_url": "http://arxiv.org/pdf/1810.02897v2.pdf",
        "date": "2021-04-01 00:00:00"
      },
      "author": [
        {
          "name": "Ye Zhu"
        },
        {
          "name": "Kai Ming Ting"
        },
        {
          "name": "Mark Carman"
        },
        {
          "name": "Maia Angelova"
        }
      ],
      "tag": [
        {
          "name": "cs.LG"
        },
        {
          "name": "cs.AI"
        },
        {
          "name": "cs.CV"
        },
        {
          "name": "stat.ML"
        }
      ]
    }
  ],
  "message": "数据获取成功"
}
```

# API（模糊查询）
> 状态码

| code | message                 |
| ---- | ----------------------- |
| 211  | 数据获取成功      |
| 212  | 数据获取失败      |
| 213  | 数据修改成功      |
| 214  | 数据修改失败      |
| 215  | 数据添加成功      |
| 216  | 数据添加失败      |
| 217  | 数据删除成功      |
| 218  | 数据删除失败      |


## paper----title

### 基本说明
| 接口地址 | http://localhost:8080/api/paper              |
| -------- | -------------------------------------------- |
| 返回格式 | JSON                                         |
| 请求方式 | POST                                         |
| 请求示例 | http://localhost:8080/api/paper?title=Emotion&limitStart=0&limitEnd=4 |

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
| date | String | 日期,paper按日期由新到旧 |
| author | String | 作者 |
| tag | String | 标签 |

### JSON返回示例
```json
{
  "code": 211,
  "paper": [
    {
      "paper": {
        "id": 1402.5047,
        "title": "Real-time Automatic Emotion Recognition from Body Gestures",
        "abstract_content": "Although psychological research indicates that bodily expressions convey important affective information, to date research in emotion recognition focused mainly on facial expression or voice analysis. In this paper we propose an approach to realtime automatic emotion recognition from body movements. A set of postural, kinematic, and geometrical features are extracted from sequences 3D skeletons and fed to a multi-class SVM classifier. The proposed method has been assessed on data acquired through two different systems: a professionalgrade optical motion capture system, and Microsoft Kinect. The system has been assessed on a \"six emotions\" recognition problem, and using a leave-one-subject-out cross validation strategy, reached an overall recognition rate of 61.3% which is very close to the recognition rate of 61.9% obtained by human observers. To provide further testing of the system, two games were developed, where one or two users have to interact to understand and express emotions with their body.",
        "pdf_url": "http://arxiv.org/pdf/1402.5047v1.pdf",
        "date": "2014-02-20 00:00:00"
      },
      "author": [
        {
          "name": "Stefano Piana"
        },
        {
          "name": "Alessandra Staglianò"
        },
        {
          "name": "Francesca Odone"
        },
        {
          "name": "Alessandro Verri"
        },
        {
          "name": "Antonio Camurri"
        }
      ],
      "tag": [
        {
          "name": "cs.HC"
        },
        {
          "name": "cs.CV"
        }
      ]
    },
    {
      "paper": {
        "id": 1309.2853,
        "title": "General Purpose Textual Sentiment Analysis and Emotion Detection Tools",
        "abstract_content": "Textual sentiment analysis and emotion detection consists in retrieving the sentiment or emotion carried by a text or document. This task can be useful in many domains: opinion mining, prediction, feedbacks, etc. However, building a general purpose tool for doing sentiment analysis and emotion detection raises a number of issues, theoretical issues like the dependence to the domain or to the language but also pratical issues like the emotion representation for interoperability. In this paper we present our sentiment/emotion analysis tools, the way we propose to circumvent the di culties and the applications they are used for.",
        "pdf_url": "http://arxiv.org/pdf/1309.2853v1.pdf",
        "date": "2013-09-11 00:00:00"
      },
      "author": [
        {
          "name": "Alexandre Denis"
        },
        {
          "name": "Samuel Cruz-Lara"
        },
        {
          "name": "Nadia Bellalem"
        }
      ],
      "tag": [
        {
          "name": "cs.CL"
        }
      ]
    },
    {
      "paper": {
        "id": 1303.1761,
        "title": "Improving Automatic Emotion Recognition from speech using Rhythm and\n  Temporal feature",
        "abstract_content": "This paper is devoted to improve automatic emotion recognition from speech by incorporating rhythm and temporal features. Research on automatic emotion recognition so far has mostly been based on applying features like MFCCs, pitch and energy or intensity. The idea focuses on borrowing rhythm features from linguistic and phonetic analysis and applying them to the speech signal on the basis of acoustic knowledge only. In addition to this we exploit a set of temporal and loudness features. A segmentation unit is employed in starting to separate the voiced/unvoiced and silence parts and features are explored on different segments. Thereafter different classifiers are used for classification. After selecting the top features using an IGR filter we are able to achieve a recognition rate of 80.60 % on the Berlin Emotion Database for the speaker dependent framework.",
        "pdf_url": "http://arxiv.org/pdf/1303.1761v1.pdf",
        "date": "2013-03-07 00:00:00"
      },
      "author": [
        {
          "name": "Mayank Bhargava"
        },
        {
          "name": "Tim Polzehl"
        }
      ],
      "tag": [
        {
          "name": "cs.CV"
        }
      ]
    },
    {
      "paper": {
        "id": 1203.2293,
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
      ]
    }
  ],
  "message": "数据获取成功"
}
```

## paper----author

### 基本说明
| 接口地址 | http://localhost:8080/api/paper              |
| -------- | -------------------------------------------- |
| 返回格式 | JSON                                         |
| 请求方式 | POST                                         |
| 请求示例 | http://localhost:8080/api/paper?author=Xu&limitStart=0&limitEnd=4 |

### 请求参数说明
> limitStart 与 limitEnd 的意义是将结果分页，例如 0,20
> 就是将结果的第 1 个到第 20 个取出来
> limitEnd 可以超过结果数


| 名称 | 类型 | 必填 | 说明      |
| ---- | ---- | ---- | ----------- |
| author   | String  | 是  | 模糊作者 |
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
| date | String | 日期,paper按日期由新到旧 |
| author | String | 作者 |
| tag | String | 标签 |


### JSON返回示例
```json
{
  "code": 211,
  "paper": [
    {
      "paper": {
        "id": 1712.09913,
        "title": "Visualizing the Loss Landscape of Neural Nets",
        "abstract_content": "Neural network training relies on our ability to find \"good\" minimizers of highly non-convex loss functions. It is well-known that certain network architecture designs (e.g., skip connections) produce loss functions that train easier, and well-chosen training parameters (batch size, learning rate, optimizer) produce minimizers that generalize better. However, the reasons for these differences, and their effects on the underlying loss landscape, are not well understood. In this paper, we explore the structure of neural loss functions, and the effect of loss landscapes on generalization, using a range of visualization methods. First, we introduce a simple \"filter normalization\" method that helps us visualize loss function curvature and make meaningful side-by-side comparisons between loss functions. Then, using a variety of visualizations, we explore how network architecture affects the loss landscape, and how training parameters affect the shape of minimizers.",
        "pdf_url": "http://arxiv.org/pdf/1712.09913v3.pdf",
        "date": "2018-11-07 00:00:00"
      },
      "author": [
        {
          "name": "Hao Li"
        },
        {
          "name": "Zheng Xu"
        },
        {
          "name": "Gavin Taylor"
        },
        {
          "name": "Christoph Studer"
        },
        {
          "name": "Tom Goldstein"
        }
      ],
      "tag": [
        {
          "name": "cs.LG"
        }
      ]
    },
    {
      "paper": {
        "id": 1502.03044,
        "title": "Show, Attend and Tell: Neural Image Caption Generation with Visual\n  Attention",
        "abstract_content": "Inspired by recent work in machine translation and object detection, we introduce an attention based model that automatically learns to describe the content of images. We describe how we can train this model in a deterministic manner using standard backpropagation techniques and stochastically by maximizing a variational lower bound. We also show through visualization how the model is able to automatically learn to fix its gaze on salient objects while generating the corresponding words in the output sequence. We validate the use of attention with state-of-the-art performance on three benchmark datasets: Flickr8k, Flickr30k and MS COCO.",
        "pdf_url": "http://arxiv.org/pdf/1502.03044v3.pdf",
        "date": "2016-04-19 00:00:00"
      },
      "author": [
        {
          "name": "Kelvin Xu"
        },
        {
          "name": "Jimmy Ba"
        },
        {
          "name": "Ryan Kiros"
        },
        {
          "name": "Kyunghyun Cho"
        },
        {
          "name": "Aaron Courville"
        },
        {
          "name": "Ruslan Salakhutdinov"
        },
        {
          "name": "Richard Zemel"
        },
        {
          "name": "Yoshua Bengio"
        }
      ],
      "tag": [
        {
          "name": "cs.LG"
        }
      ]
    },
    {
      "paper": {
        "id": 1406.2661,
        "title": "Generative Adversarial Networks",
        "abstract_content": "We propose a new framework for estimating generative models via an adversarial process, in which we simultaneously train two models: a generative model G that captures the data distribution, and a discriminative model D that estimates the probability that a sample came from the training data rather than G. The training procedure for G is to maximize the probability of D making a mistake. This framework corresponds to a minimax two-player game. In the space of arbitrary functions G and D, a unique solution exists, with G recovering the training data distribution and D equal to 1/2 everywhere. In the case where G and D are defined by multilayer perceptrons, the entire system can be trained with backpropagation. There is no need for any Markov chains or unrolled approximate inference networks during either training or generation of samples. Experiments demonstrate the potential of the framework through qualitative and quantitative evaluation of the generated samples.",
        "pdf_url": "http://arxiv.org/pdf/1406.2661v1.pdf",
        "date": "2014-06-10 00:00:00"
      },
      "author": [
        {
          "name": "Ian J. Goodfellow"
        },
        {
          "name": "Jean Pouget-Abadie"
        },
        {
          "name": "Mehdi Mirza"
        },
        {
          "name": "Bing Xu"
        },
        {
          "name": "David Warde-Farley"
        },
        {
          "name": "Sherjil Ozair"
        },
        {
          "name": "Aaron Courville"
        },
        {
          "name": "Yoshua Bengio"
        }
      ],
      "tag": [
        {
          "name": "stat.ML"
        }
      ]
    },
    {
      "paper": {
        "id": 1405.0601,
        "title": "Supervised Descent Method for Solving Nonlinear Least Squares Problems\n  in Computer Vision",
        "abstract_content": "Many computer vision problems (e.g., camera calibration, image alignment, structure from motion) are solved with nonlinear optimization methods. It is generally accepted that second order descent methods are the most robust, fast, and reliable approaches for nonlinear optimization of a general smooth function. However, in the context of computer vision, second order descent methods have two main drawbacks: (1) the function might not be analytically differentiable and numerical approximations are impractical, and (2) the Hessian may be large and not positive definite. To address these issues, this paper proposes generic descent maps, which are average \"descent directions\" and rescaling factors learned in a supervised fashion. Using generic descent maps, we derive a practical algorithm - Supervised Descent Method (SDM) - for minimizing Nonlinear Least Squares (NLS) problems. During training, SDM learns a sequence of decent maps that minimize the NLS. In testing, SDM minimizes the NLS objective using the learned descent maps without computing the Jacobian or the Hessian. We prove the conditions under which the SDM is guaranteed to converge. We illustrate the effectiveness and accuracy of SDM in three computer vision problems: rigid image alignment, non-rigid image alignment, and 3D pose estimation. In particular, we show how SDM achieves state-of-the-art performance in the problem of facial feature detection. The code has been made available at www.humansensing.cs.cmu.edu/intraface.",
        "pdf_url": "http://arxiv.org/pdf/1405.0601v1.pdf",
        "date": "2014-05-03 00:00:00"
      },
      "author": [
        {
          "name": "Xuehan Xiong"
        },
        {
          "name": "Fernando De la Torre"
        }
      ],
      "tag": [
        {
          "name": "cs.CV"
        }
      ]
    }
  ],
  "message": "数据获取成功"
}
```

## paper----tag&title
### 基本说明
| 接口地址 | http://localhost:8080/api/paper              |
| -------- | -------------------------------------------- |
| 返回格式 | JSON                                         |
| 请求方式 | POST                                         |
| 请求示例 | http://localhost:8080/api/paper?tag=stat.ME&title=Da&limitStart=0&limitEnd=4 |

### 请求参数说明
> limitStart 与 limitEnd 的意义是将结果分页，例如 0,20
> 就是将结果的第 1 个到第 20 个取出来
> limitEnd 可以超过结果数

| 名称 | 类型 | 必填 | 说明      |
| ---- | ---- | ---- | ----------- |
| tag   | String  | 是  | 精确标签 |
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
| date | String | 日期,paper按日期由新到旧 |
| author | String | 作者 |
| tag | String | 标签 |

### JSON返回示例
```json
{
  "code": 211,
  "paper": [
    {
      "paper": {
        "id": 2104.00673,
        "title": "Cross-validation: what does it estimate and how well does it do it?",
        "abstract_content": "Cross-validation is a widely-used technique to estimate prediction error, but its behavior is complex and not fully understood. Ideally, one would like to think that cross-validation estimates the prediction error for the model at hand, fit to the training data. We prove that this is not the case for the linear model fit by ordinary least squares; rather it estimates the average prediction error of models fit on other unseen training sets drawn from the same population. We further show that this phenomenon occurs for most popular estimates of prediction error, including data splitting, bootstrapping, and Mallow's Cp. Next, the standard confidence intervals for prediction error derived from cross-validation may have coverage far below the desired level. Because each data point is used for both training and testing, there are correlations among the measured accuracies for each fold, and so the usual estimate of variance is too small. We introduce a nested cross-validation scheme to estimate this variance more accurately, and show empirically that this modification leads to intervals with approximately correct coverage in many examples where traditional cross-validation intervals fail. Lastly, our analysis also shows that when producing confidence intervals for prediction accuracy with simple data splitting, one should not re-fit the model on the combined data, since this invalidates the confidence intervals.",
        "pdf_url": "http://arxiv.org/pdf/2104.00673v1.pdf",
        "date": "2021-04-01 00:00:00"
      },
      "author": [
        {
          "name": "Stephen Bates"
        },
        {
          "name": "Trevor Hastie"
        },
        {
          "name": "Robert Tibshirani"
        }
      ],
      "tag": [
        {
          "name": "stat.ME"
        },
        {
          "name": "math.ST"
        },
        {
          "name": "stat.CO"
        },
        {
          "name": "stat.ML"
        },
        {
          "name": "stat.TH"
        }
      ]
    },
    {
      "paper": {
        "id": 2103.16041,
        "title": "Scalable Statistical Inference of Photometric Redshift via Data\n  Subsampling",
        "abstract_content": "Handling big data has largely been a major bottleneck in traditional statistical models. Consequently, when accurate point prediction is the primary target, machine learning models are often preferred over their statistical counterparts for bigger problems. But full probabilistic statistical models often outperform other models in quantifying uncertainties associated with model predictions. We develop a data-driven statistical modeling framework that combines the uncertainties from an ensemble of statistical models learned on smaller subsets of data carefully chosen to account for imbalances in the input space. We demonstrate this method on a photometric redshift estimation problem in cosmology, which seeks to infer a distribution of the redshift -- the stretching effect in observing the light of far-away galaxies -- given multivariate color information observed for an object in the sky. Our proposed method performs balanced partitioning, graph-based data subsampling across the partitions, and training of an ensemble of Gaussian process models.",
        "pdf_url": "http://arxiv.org/pdf/2103.16041v2.pdf",
        "date": "2021-04-01 00:00:00"
      },
      "author": [
        {
          "name": "Arindam Fadikar"
        },
        {
          "name": "Stefan M. Wild"
        },
        {
          "name": "Jonas Chaves-Montero"
        }
      ],
      "tag": [
        {
          "name": "stat.ME"
        },
        {
          "name": "cs.LG"
        }
      ]
    },
    {
      "paper": {
        "id": 2005.09301,
        "title": "Fast cross-validation for multi-penalty ridge regression",
        "abstract_content": "High-dimensional prediction with multiple data types needs to account for potentially strong differences in predictive signal. Ridge regression is a simple model for high-dimensional data that has challenged the predictive performance of many more complex models and learners, and that allows inclusion of data type specific penalties. The largest challenge for multi-penalty ridge is to optimize these penalties efficiently in a cross-validation (CV) setting, in particular for GLM and Cox ridge regression, which require an additional estimation loop by iterative weighted least squares (IWLS). Our main contribution is a computationally very efficient formula for the multi-penalty, sample-weighted hat-matrix, as used in the IWLS algorithm. As a result, nearly all computations are in low-dimensional space, rendering a speed-up of several orders of magnitude. We developed a flexible framework that facilitates multiple types of response, unpenalized covariates, several performance criteria and repeated CV. Extensions to paired and preferential data types are included and illustrated on several cancer genomics survival prediction problems. Moreover, we present similar computational shortcuts for maximum marginal likelihood and Bayesian probit regression. The corresponding R-package, multiridge, serves as a versatile standalone tool, but also as a fast benchmark for other more complex models and multi-view learners.",
        "pdf_url": "http://arxiv.org/pdf/2005.09301v2.pdf",
        "date": "2021-04-01 00:00:00"
      },
      "author": [
        {
          "name": "Mark A. van de Wiel"
        },
        {
          "name": "Mirrelijn M. van Nee"
        },
        {
          "name": "Armin Rauschenberger"
        }
      ],
      "tag": [
        {
          "name": "stat.ME"
        },
        {
          "name": "stat.CO"
        },
        {
          "name": "stat.ML"
        }
      ]
    },
    {
      "paper": {
        "id": 1810.08316,
        "title": "Heteroskedastic PCA: Algorithm, Optimality, and Applications",
        "abstract_content": "A general framework for principal component analysis (PCA) in the presence of heteroskedastic noise is introduced. We propose an algorithm called HeteroPCA, which involves iteratively imputing the diagonal entries of the sample covariance matrix to remove estimation bias due to heteroskedasticity. This procedure is computationally efficient and provably optimal under the generalized spiked covariance model. A key technical step is a deterministic robust perturbation analysis on singular subspaces, which can be of independent interest. The effectiveness of the proposed algorithm is demonstrated in a suite of problems in high-dimensional statistics, including singular value decomposition (SVD) under heteroskedastic noise, Poisson PCA, and SVD for heteroskedastic and incomplete data.",
        "pdf_url": "http://arxiv.org/pdf/1810.08316v3.pdf",
        "date": "2021-04-01 00:00:00"
      },
      "author": [
        {
          "name": "Anru R. Zhang"
        },
        {
          "name": "T. Tony Cai"
        },
        {
          "name": "Yihong Wu"
        }
      ],
      "tag": [
        {
          "name": "math.ST"
        },
        {
          "name": "stat.CO"
        },
        {
          "name": "stat.ME"
        },
        {
          "name": "stat.ML"
        },
        {
          "name": "stat.TH"
        }
      ]
    }
  ],
  "message": "数据获取成功"
}
```

# API（修改）
##  author----id
### 基本说明
| 接口地址 | http://localhost:8080/api/edit              |
| -------- | -------------------------------------------- |
| 返回格式 | JSON                                         |
| 请求方式 | POST                                         |
| 请求示例 | http://localhost:8080/api/edit?id=2104.00683&oldAuthor=Ye Yuan&newAuthor=Tom |

### 请求参数说明
| 名称 | 类型 | 必填 | 说明      |
| ---- | ---- | ---- | ----------- |
| id   | double  | 是  | paper 的 id |
| oldAuthor   | String  | 是  | 旧作者名(精确) |
| newAuthor   | String  | 是  | 新作者名(精确) |

### 返回参数说明
| 名称  | 类型 | 说明   |
| ------- | ------ | -------- |
| code    | int    | 状态码 |
| message | String | 状态信息 |
| affectedAuthorRows   | int | 此次修改影响行数 |

### JSON返回示例
```json
{
    "affectedAuthorRows": 1,
    "code": 213,
    "message": "数据修改成功"
}
```

##  tag----id
### 基本说明
| 接口地址 | http://localhost:8080/api/edit              |
| -------- | -------------------------------------------- |
| 返回格式 | JSON                                         |
| 请求方式 | POST                                         |
| 请求示例 | http://localhost:8080/api/edit?id=2104.00683&oldTag=cs.CV&newTag=cs.Tom |

### 请求参数说明
| 名称 | 类型 | 必填 | 说明      |
| ---- | ---- | ---- | ----------- |
| id   | double  | 是  | paper 的 id |
| oldTag   | String  | 是  | 旧标签名(精确) |
| newTag   | String  | 是  | 新标签名(精确) |

### 返回参数说明
| 名称  | 类型 | 说明   |
| ------- | ------ | -------- |
| code    | int    | 状态码 |
| message | String | 状态信息 |
| affectedTagRows   | int | 此次修改影响行数 |

### JSON返回示例
```json
{
    "affectedTagRows": 1,
    "code": 213,
    "message": "数据修改成功"
}
```

##  title----id
### 基本说明
| 接口地址 | http://localhost:8080/api/edit              |
| -------- | -------------------------------------------- |
| 返回格式 | JSON                                         |
| 请求方式 | POST                                         |
| 请求示例 | http://localhost:8080/api/edit?id=2104.00683&title=Tom |

### 请求参数说明
| 名称 | 类型 | 必填 | 说明      |
| ---- | ---- | ---- | ----------- |
| id   | double  | 是  | paper 的 id |
| title   | String  | 是  | 新标题名(精确) |

### 返回参数说明
| 名称  | 类型 | 说明   |
| ------- | ------ | -------- |
| code    | int    | 状态码 |
| message | String | 状态信息 |
| affectedTitleRows   | int | 此次修改影响行数 |

### JSON返回示例
```json
{
  "code": 213,
  "affectedTitleRows": 1,
  "message": "数据修改成功"
}
```

## abstract----id
### 基本说明
| 接口地址 | http://localhost:8080/api/edit              |
| -------- | -------------------------------------------- |
| 返回格式 | JSON                                         |
| 请求方式 | POST                                         |
| 请求示例 | http://localhost:8080/api/edit?id=2104.00683&newAbstract=Tom |

### 请求参数说明
| 名称 | 类型 | 必填 | 说明      |
| ---- | ---- | ---- | ----------- |
| id   | double  | 是  | paper 的 id |
| newAbstract   | String  | 是  | 新摘要(精确) |

### 返回参数说明
| 名称  | 类型 | 说明   |
| ------- | ------ | -------- |
| code    | int    | 状态码 |
| message | String | 状态信息 |
| affectedTitleRows   | int | 此次修改影响行数 |

### JSON返回示例
```json
{
  "code": 213,
  "message": "数据修改成功",
  "affectedAbstractRows": 1
}
```

## url----id
### 基本说明
| 接口地址 | http://localhost:8080/api/edit              |
| -------- | -------------------------------------------- |
| 返回格式 | JSON                                         |
| 请求方式 | POST                                         |
| 请求示例 | http://localhost:8080/api/edit?id=2104.00683&newUrl=http://example.com |

### 请求参数说明
| 名称 | 类型 | 必填 | 说明      |
| ---- | ---- | ---- | ----------- |
| id   | double  | 是  | paper 的 id |
| newUrl   | String  | 是  | 新PDF链接(精确) |

### 返回参数说明
| 名称  | 类型 | 说明   |
| ------- | ------ | -------- |
| code    | int    | 状态码 |
| message | String | 状态信息 |
| affectedUrlRows   | int | 此次修改影响行数 |

### JSON返回示例
```json
{
  "code": 213,
  "message": "数据修改成功",
  "affectedUrlRows": 1
}
```

## date----id
### 基本说明
| 接口地址 | http://localhost:8080/api/edit              |
| -------- | -------------------------------------------- |
| 返回格式 | JSON                                         |
| 请求方式 | POST                                         |
| 请求示例 | http://localhost:8080/api/edit?id=2104.00683&newDate=2021-04-07 |

### 请求参数说明
| 名称 | 类型 | 必填 | 说明      |
| ---- | ---- | ---- | ----------- |
| id   | double  | 是  | paper 的 id |
| newDate   | String  | 是  | 新日期(精确) |

### 返回参数说明
| 名称  | 类型 | 说明   |
| ------- | ------ | -------- |
| code    | int    | 状态码 |
| message | String | 状态信息 |
| affectedDateRows   | int | 此次修改影响行数 |

### JSON返回示例
```json
{
  "code": 213,
  "message": "数据修改成功",
  "affectedDateRows": 1
}
```

# API（删除）
## tag----id
### 基本说明
| 接口地址 | http://localhost:8080/api/delete              |
| -------- | -------------------------------------------- |
| 返回格式 | JSON                                         |
| 请求方式 | POST                                         |
| 请求示例 | http://localhost:8080/api/delete?id=2104.00683&tag=cs.CV |

### 请求参数说明
| 名称 | 类型 | 必填 | 说明      |
| ---- | ---- | ---- | ----------- |
| id   | double  | 是  | paper 的 id |
| tag   | String  | 是  | 标签(精确) |

### 返回参数说明
| 名称  | 类型 | 说明   |
| ------- | ------ | -------- |
| code    | int    | 状态码 |
| message | String | 状态信息 |
| affectedTagRows   | int | 此次修改影响行数 |

### JSON返回示例
```json
{
  "code": 217,
  "message": "数据删除成功",
  "affectedTagRows": 1
}
```

## author----id
### 基本说明
| 接口地址 | http://localhost:8080/api/delete              |
| -------- | -------------------------------------------- |
| 返回格式 | JSON                                         |
| 请求方式 | POST                                         |
| 请求示例 | http://localhost:8080/api/delete?id=2104.00683&author=Ye Yuan |

### 请求参数说明
| 名称 | 类型 | 必填 | 说明      |
| ---- | ---- | ---- | ----------- |
| id   | double  | 是  | paper 的 id |
| author   | String  | 是  | 作者(精确) |

### 返回参数说明
| 名称  | 类型 | 说明   |
| ------- | ------ | -------- |
| code    | int    | 状态码 |
| message | String | 状态信息 |
| affectedAuthorRows   | int | 此次修改影响行数 |

### JSON返回示例
```json
{
  "code": 217,
  "message": "数据删除成功",
  "affectedAuthorRows": 1
}
```

## paper----id
### 基本说明
| 接口地址 | http://localhost:8080/api/delete              |
| -------- | -------------------------------------------- |
| 返回格式 | JSON                                         |
| 请求方式 | POST                                         |
| 请求示例 | http://localhost:8080/api/delete?id=2104.00683 |

### 请求参数说明
| 名称 | 类型 | 必填 | 说明      |
| ---- | ---- | ---- | ----------- |
| id   | double  | 是  | paper 的 id |

### 返回参数说明
| 名称  | 类型 | 说明   |
| ------- | ------ | -------- |
| code    | int    | 状态码 |
| message | String | 状态信息 |
| affectedPaperRows   | int | 此次修改影响行数 |

### JSON返回示例
```json
{
  "code": 217,
  "message": "数据删除成功",
  "affectedPaperRows": 5
}
```

# API（添加）
## tag----id
### 基本说明
| 接口地址 | http://localhost:8080/api/add              |
| -------- | -------------------------------------------- |
| 返回格式 | JSON                                         |
| 请求方式 | POST                                         |
| 请求示例 | http://localhost:8080/api/add?id=2104.00683&tag=Tom |

### 请求参数说明
| 名称 | 类型 | 必填 | 说明      |
| ---- | ---- | ---- | ----------- |
| id   | double  | 是  | paper 的 id |
| tag   | String  | 是  | 新标签 |

### 返回参数说明
| 名称  | 类型 | 说明   |
| ------- | ------ | -------- |
| code    | int    | 状态码 |
| message | String | 状态信息 |
| affectedTagRows   | int | 此次修改影响行数 |

### JSON返回示例
```json
{
  "code": 215,
  "message": "数据添加成功",
  "affectedTagRows": 1
}
```

## author----id
### 基本说明
| 接口地址 | http://localhost:8080/api/add              |
| -------- | -------------------------------------------- |
| 返回格式 | JSON                                         |
| 请求方式 | POST                                         |
| 请求示例 | http://localhost:8080/api/add?id=2104.00683&author=Tom |

### 请求参数说明
| 名称 | 类型 | 必填 | 说明      |
| ---- | ---- | ---- | ----------- |
| id   | double  | 是  | paper 的 id |
| author   | String  | 是  | 新作者 |

### 返回参数说明
| 名称  | 类型 | 说明   |
| ------- | ------ | -------- |
| code    | int    | 状态码 |
| message | String | 状态信息 |
| affectedAuthorRows   | int | 此次修改影响行数 |

### JSON返回示例
```json
{
  "code": 215,
  "message": "数据添加成功",
  "affectedAuthorRows": 1
}
```

## paper----id
### 基本说明
| 接口地址 | http://localhost:8080/api/add              |
| -------- | -------------------------------------------- |
| 返回格式 | JSON                                         |
| 请求方式 | POST                                         |
| 请求示例 | http://localhost:8080/api/add?id=2104.00683&title=Java&author=Tom&tag=cs.CV&abstractContent=ThisIsAbstract&url=http://example.com&date=2021-04-07 |

### 请求参数说明
> 注意：若添加 paper 有多个 tag 、多个 author 时
> 将第二个开始的 tag/author 
> 用 add ----> tag 和 add ----> author 接口

| 名称 | 类型 | 必填 | 说明      |
| ---- | ---- | ---- | ----------- |
| id   | double  | 是  | paper 的 id |
| title   | String  | 是  | 标题 |
| author   | String  | 是  | 作者 |
| tag   | String  | 是  | 标签 |
| abstractContent   | String  | 是  | 摘要 |
| url   | String  | 是  | PDF链接 |
| date   | String  | 是  | 日期 |

### 返回参数说明
| 名称  | 类型 | 说明   |
| ------- | ------ | -------- |
| code    | int    | 状态码 |
| message | String | 状态信息 |
| affectedPaperRows   | int | 此次修改影响行数 |

### JSON返回示例
```json
{
  "code": 215,
  "message": "数据添加成功",
  "affectedPaperRows": 7
}
```

# user
## 修改密码
### 基本说明
| 接口地址 | http://localhost:8080/api/user/password    |
| -------- | -------------------------------------------- |
| 返回格式 | JSON                                         |
| 请求方式 | POST                                         |
| 请求示例 | http://localhost:8080/api/user/password?username=tom&password=123a |

### 请求参数说明
| 名称 | 类型 | 必填 | 说明      |
| ---- | ---- | ---- | ----------- |
| username   | String  | 是  | 用户名 |
| password   | String  | 是  | 密码 |

### 返回参数说明
| 名称  | 类型 | 说明   |
| ------- | ------ | -------- |
| code    | int    | 状态码 |
| message | String | 状态信息 |
| affectedUserRows   | int | 此次修改影响行数 |

### JSON返回示例
```json
{
  "code": 213,
  "message": "数据添加成功",
  "affectedUserRows": 1
}
```
