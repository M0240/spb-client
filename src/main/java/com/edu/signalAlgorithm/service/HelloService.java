package com.edu.signalAlgorithm.service;

import com.edu.signalAlgorithm.domain.timeDomainFeatures;

import java.util.List;

public interface HelloService {
    //判断返回算法类型
    public List<?> selectAlgorithmCall(String name);
    //返回时域特征
    public List<timeDomainFeatures> TDFService(String name);
    //返回频域特征
    //返回FFT
    //返回CWT
}
