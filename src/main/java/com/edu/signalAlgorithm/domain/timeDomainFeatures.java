package com.edu.signalAlgorithm.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class timeDomainFeatures {
    public double mean;             //1_均值（平均幅值）
    public double std;              //2_标准差
    public double rootAmplitude;    //3_方根幅值
    public double rms;              //4_RMS均方根
    public double peakToPeak;       //5_峰峰值
    public double skewness;         //6_偏度 skewness
    public double kurtosis;         //7_峭度 Kurtosis
    public double crestFactor;      //8_峰值因子 Crest Factor
    public double clearanceFactor;  //9_裕度因子  Clearance Factor
    public double shapeFactor;      //10_波形因子 Shape Factor
    public double impulseFactor;    //11_脉冲指数 Impulse Factor

}
