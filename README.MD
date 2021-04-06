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
| id   | double | paper 的 id,由新到旧 |

### JSON返回示例
```json
{
    "code": 211,
    "id": [
        2104.00673,
        2103.16041,
        2103.11175,
        2101.09271
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

### JSON返回示例
```json
{
    "code": 211,
    "paper": [
        {
            "id": 2104.00683,
            "title": "SimPoE: Simulated Character Control for 3D Human Pose Estimation",
            "abstract_content": "Accurate estimation of 3D human motion from monocular video requires modeling both kinematics (body motion without physical forces) and dynamics (motion with physical forces). To demonstrate this, we present SimPoE, a Simulation-based approach for 3D human Pose Estimation, which integrates image-based kinematic inference and physics-based dynamics modeling. SimPoE learns a policy that takes as input the current-frame pose estimate and the next image frame to control a physically-simulated character to output the next-frame pose estimate. The policy contains a learnable kinematic pose refinement unit that uses 2D keypoints to iteratively refine its kinematic pose estimate of the next frame. Based on this refined kinematic pose, the policy learns to compute dynamics-based control (e.g., joint torques) of the character to advance the current-frame pose estimate to the pose estimate of the next frame. This design couples the kinematic pose refinement unit with the dynamics-based control generation unit, which are learned jointly with reinforcement learning to achieve accurate and physically-plausible pose estimation. Furthermore, we propose a meta-control mechanism that dynamically adjusts the character's dynamics parameters based on the character state to attain more accurate pose estimates. Experiments on large-scale motion datasets demonstrate that our approach establishes the new state of the art in pose accuracy while ensuring physical plausibility.",
            "pdf_url": "http://arxiv.org/pdf/2104.00683v1.pdf",
            "date": "2021-04-01 00:00:00"
        },
        {
            "id": 2104.00676,
            "title": "Is Label Smoothing Truly Incompatible with Knowledge Distillation: An\n  Empirical Study",
            "abstract_content": "This work aims to empirically clarify a recently discovered perspective that label smoothing is incompatible with knowledge distillation. We begin by introducing the motivation behind on how this incompatibility is raised, i.e., label smoothing erases relative information between teacher logits. We provide a novel connection on how label smoothing affects distributions of semantically similar and dissimilar classes. Then we propose a metric to quantitatively measure the degree of erased information in sample's representation. After that, we study its one-sidedness and imperfection of the incompatibility view through massive analyses, visualizations and comprehensive experiments on Image Classification, Binary Networks, and Neural Machine Translation. Finally, we broadly discuss several circumstances wherein label smoothing will indeed lose its effectiveness. Project page: http://zhiqiangshen.com/projects/LS_and_KD/index.html.",
            "pdf_url": "http://arxiv.org/pdf/2104.00676v1.pdf",
            "date": "2021-04-01 00:00:00"
        },
        {
            "id": 2104.00671,
            "title": "TRS: Transferability Reduced Ensemble via Encouraging Gradient Diversity\n  and Model Smoothness",
            "abstract_content": "Adversarial Transferability is an intriguing property of adversarial examples -- a perturbation that is crafted against one model is also effective against another model, which may arise from a different model family or training process. To better protect ML systems against adversarial attacks, several questions are raised: what are the sufficient conditions for adversarial transferability? Is it possible to bound such transferability? Is there a way to reduce the transferability in order to improve the robustness of an ensemble ML model? To answer these questions, we first theoretically analyze sufficient conditions for transferability between models and propose a practical algorithm to reduce transferability within an ensemble to improve its robustness. Our theoretical analysis shows only the orthogonality between gradients of different models is not enough to ensure low adversarial transferability: the model smoothness is also an important factor. In particular, we provide a lower/upper bound of adversarial transferability based on model gradient similarity for low risk classifiers based on gradient orthogonality and model smoothness. We demonstrate that under the condition of gradient orthogonality, smoother classifiers will guarantee lower adversarial transferability. Furthermore, we propose an effective Transferability Reduced Smooth-ensemble(TRS) training strategy to train a robust ensemble with low transferability by enforcing model smoothness and gradient orthogonality between base models. We conduct extensive experiments on TRS by comparing with other state-of-the-art baselines on different datasets, showing that the proposed TRS outperforms all baselines significantly. We believe our analysis on adversarial transferability will inspire future research towards developing robust ML models taking these adversarial transferability properties into account.",
            "pdf_url": "http://arxiv.org/pdf/2104.00671v1.pdf",
            "date": "2021-04-01 00:00:00"
        },
        {
            "id": 2008.06677,
            "title": "Preferential Bayesian optimisation with Skew Gaussian Processes",
            "abstract_content": "Preferential Bayesian optimisation (PBO) deals with optimisation problems where the objective function can only be accessed via preference judgments, such as \"this is better than that\" between two candidate solutions (like in A/B tests or recommender systems). The state-of-the-art approach to PBO uses a Gaussian process to model the preference function and a Bernoulli likelihood to model the observed pairwise comparisons. Laplace's method is then employed to compute posterior inferences and, in particular, to build an appropriate acquisition function. In this paper, we prove that the true posterior distribution of the preference function is a Skew Gaussian Process (SkewGP), with highly skewed pairwise marginals and, thus, show that Laplace's method usually provides a very poor approximation. We then derive an efficient method to compute the exact SkewGP posterior and use it as surrogate model for PBO employing standard acquisition functions (Upper Credible Bound, etc.). We illustrate the benefits of our exact PBO-SkewGP in a variety of experiments, by showing that it consistently outperforms PBO based on Laplace's approximation both in terms of convergence speed and computational time. We also show that our framework can be extended to deal with mixed preferential-categorical BO, where binary judgments (valid or non-valid) together with preference judgments are available.",
            "pdf_url": "http://arxiv.org/pdf/2008.06677v3.pdf",
            "date": "2021-04-01 00:00:00"
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

### JSON返回示例
```json
{
  "code": 211,
  "paper": [
    {
      "id": 1402.5047,
      "title": "Real-time Automatic Emotion Recognition from Body Gestures",
      "abstract_content": "Although psychological research indicates that bodily expressions convey important affective information, to date research in emotion recognition focused mainly on facial expression or voice analysis. In this paper we propose an approach to realtime automatic emotion recognition from body movements. A set of postural, kinematic, and geometrical features are extracted from sequences 3D skeletons and fed to a multi-class SVM classifier. The proposed method has been assessed on data acquired through two different systems: a professionalgrade optical motion capture system, and Microsoft Kinect. The system has been assessed on a \"six emotions\" recognition problem, and using a leave-one-subject-out cross validation strategy, reached an overall recognition rate of 61.3% which is very close to the recognition rate of 61.9% obtained by human observers. To provide further testing of the system, two games were developed, where one or two users have to interact to understand and express emotions with their body.",
      "pdf_url": "http://arxiv.org/pdf/1402.5047v1.pdf",
      "date": "2014-02-20 00:00:00"
    },
    {
      "id": 1309.2853,
      "title": "General Purpose Textual Sentiment Analysis and Emotion Detection Tools",
      "abstract_content": "Textual sentiment analysis and emotion detection consists in retrieving the sentiment or emotion carried by a text or document. This task can be useful in many domains: opinion mining, prediction, feedbacks, etc. However, building a general purpose tool for doing sentiment analysis and emotion detection raises a number of issues, theoretical issues like the dependence to the domain or to the language but also pratical issues like the emotion representation for interoperability. In this paper we present our sentiment/emotion analysis tools, the way we propose to circumvent the di culties and the applications they are used for.",
      "pdf_url": "http://arxiv.org/pdf/1309.2853v1.pdf",
      "date": "2013-09-11 00:00:00"
    },
    {
      "id": 1303.1761,
      "title": "Improving Automatic Emotion Recognition from speech using Rhythm and\n  Temporal feature",
      "abstract_content": "This paper is devoted to improve automatic emotion recognition from speech by incorporating rhythm and temporal features. Research on automatic emotion recognition so far has mostly been based on applying features like MFCCs, pitch and energy or intensity. The idea focuses on borrowing rhythm features from linguistic and phonetic analysis and applying them to the speech signal on the basis of acoustic knowledge only. In addition to this we exploit a set of temporal and loudness features. A segmentation unit is employed in starting to separate the voiced/unvoiced and silence parts and features are explored on different segments. Thereafter different classifiers are used for classification. After selecting the top features using an IGR filter we are able to achieve a recognition rate of 80.60 % on the Berlin Emotion Database for the speaker dependent framework.",
      "pdf_url": "http://arxiv.org/pdf/1303.1761v1.pdf",
      "date": "2013-03-07 00:00:00"
    },
    {
      "id": 1203.2293,
      "title": "Categories of Emotion names in Web retrieved texts",
      "abstract_content": "The categorization of emotion names, i.e., the grouping of emotion words that have similar emotional connotations together, is a key tool of Social Psychology used to explore people's knowledge about emotions. Without exception, the studies following that research line were based on the gauging of the perceived similarity between emotion names by the participants of the experiments. Here we propose and examine a new approach to study the categories of emotion names - the similarities between target emotion names are obtained by comparing the contexts in which they appear in texts retrieved from the World Wide Web. This comparison does not account for any explicit semantic information; it simply counts the number of common words or lexical items used in the contexts. This procedure allows us to write the entries of the similarity matrix as dot products in a linear vector space of contexts. The properties of this matrix were then explored using Multidimensional Scaling Analysis and Hierarchical Clustering. Our main findings, namely, the underlying dimension of the emotion space and the categories of emotion names, were consistent with those based on people's judgments of emotion names similarities.",
      "pdf_url": "http://arxiv.org/pdf/1203.2293v1.pdf",
      "date": "2012-03-11 00:00:00"
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
| 请求示例 | http://localhost:8080/api/paper?author=Xu&limitStart=0&limitEnd=5 |

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
| id   | double | paper 的 id,由新到旧 |


### JSON返回示例
```json
{
  "code": 211,
  "id": [
    1712.09913,
    1502.03044,
    1406.2661,
    1405.0601
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

### JSON返回示例
```json
{
    "code": 211,
    "paper": [
        {
            "id": 2104.00673,
            "title": "Cross-validation: what does it estimate and how well does it do it?",
            "abstract_content": "Cross-validation is a widely-used technique to estimate prediction error, but its behavior is complex and not fully understood. Ideally, one would like to think that cross-validation estimates the prediction error for the model at hand, fit to the training data. We prove that this is not the case for the linear model fit by ordinary least squares; rather it estimates the average prediction error of models fit on other unseen training sets drawn from the same population. We further show that this phenomenon occurs for most popular estimates of prediction error, including data splitting, bootstrapping, and Mallow's Cp. Next, the standard confidence intervals for prediction error derived from cross-validation may have coverage far below the desired level. Because each data point is used for both training and testing, there are correlations among the measured accuracies for each fold, and so the usual estimate of variance is too small. We introduce a nested cross-validation scheme to estimate this variance more accurately, and show empirically that this modification leads to intervals with approximately correct coverage in many examples where traditional cross-validation intervals fail. Lastly, our analysis also shows that when producing confidence intervals for prediction accuracy with simple data splitting, one should not re-fit the model on the combined data, since this invalidates the confidence intervals.",
            "pdf_url": "http://arxiv.org/pdf/2104.00673v1.pdf",
            "date": "2021-04-01 00:00:00"
        },
        {
            "id": 2103.16041,
            "title": "Scalable Statistical Inference of Photometric Redshift via Data\n  Subsampling",
            "abstract_content": "Handling big data has largely been a major bottleneck in traditional statistical models. Consequently, when accurate point prediction is the primary target, machine learning models are often preferred over their statistical counterparts for bigger problems. But full probabilistic statistical models often outperform other models in quantifying uncertainties associated with model predictions. We develop a data-driven statistical modeling framework that combines the uncertainties from an ensemble of statistical models learned on smaller subsets of data carefully chosen to account for imbalances in the input space. We demonstrate this method on a photometric redshift estimation problem in cosmology, which seeks to infer a distribution of the redshift -- the stretching effect in observing the light of far-away galaxies -- given multivariate color information observed for an object in the sky. Our proposed method performs balanced partitioning, graph-based data subsampling across the partitions, and training of an ensemble of Gaussian process models.",
            "pdf_url": "http://arxiv.org/pdf/2103.16041v2.pdf",
            "date": "2021-04-01 00:00:00"
        },
        {
            "id": 2005.09301,
            "title": "Fast cross-validation for multi-penalty ridge regression",
            "abstract_content": "High-dimensional prediction with multiple data types needs to account for potentially strong differences in predictive signal. Ridge regression is a simple model for high-dimensional data that has challenged the predictive performance of many more complex models and learners, and that allows inclusion of data type specific penalties. The largest challenge for multi-penalty ridge is to optimize these penalties efficiently in a cross-validation (CV) setting, in particular for GLM and Cox ridge regression, which require an additional estimation loop by iterative weighted least squares (IWLS). Our main contribution is a computationally very efficient formula for the multi-penalty, sample-weighted hat-matrix, as used in the IWLS algorithm. As a result, nearly all computations are in low-dimensional space, rendering a speed-up of several orders of magnitude. We developed a flexible framework that facilitates multiple types of response, unpenalized covariates, several performance criteria and repeated CV. Extensions to paired and preferential data types are included and illustrated on several cancer genomics survival prediction problems. Moreover, we present similar computational shortcuts for maximum marginal likelihood and Bayesian probit regression. The corresponding R-package, multiridge, serves as a versatile standalone tool, but also as a fast benchmark for other more complex models and multi-view learners.",
            "pdf_url": "http://arxiv.org/pdf/2005.09301v2.pdf",
            "date": "2021-04-01 00:00:00"
        },
        {
            "id": 1810.08316,
            "title": "Heteroskedastic PCA: Algorithm, Optimality, and Applications",
            "abstract_content": "A general framework for principal component analysis (PCA) in the presence of heteroskedastic noise is introduced. We propose an algorithm called HeteroPCA, which involves iteratively imputing the diagonal entries of the sample covariance matrix to remove estimation bias due to heteroskedasticity. This procedure is computationally efficient and provably optimal under the generalized spiked covariance model. A key technical step is a deterministic robust perturbation analysis on singular subspaces, which can be of independent interest. The effectiveness of the proposed algorithm is demonstrated in a suite of problems in high-dimensional statistics, including singular value decomposition (SVD) under heteroskedastic noise, Poisson PCA, and SVD for heteroskedastic and incomplete data.",
            "pdf_url": "http://arxiv.org/pdf/1810.08316v3.pdf",
            "date": "2021-04-01 00:00:00"
        }
    ],
    "message": "数据获取成功"
}
```