package com.edu.signalAlgorithm.service.Impl;

import com.edu.signalAlgorithm.domain.algorithmCallName;
import com.edu.signalAlgorithm.domain.timeDomainFeatures;
import com.edu.signalAlgorithm.proto.GreeterGrpc;
import com.edu.signalAlgorithm.proto.HelloProto;
import com.edu.signalAlgorithm.service.HelloService;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HelloServiceImpl implements HelloService {
    @GrpcClient("grpc-server")
    private GreeterGrpc.GreeterBlockingStub helloStub;

    private List<timeDomainFeatures> ListTDF = new ArrayList<>();

    @Override
    public List<?> selectAlgorithmCall(String name) {

        if(name.equals(algorithmCallName.TIME_DOMAIN_FEATURES)){
            return TDFService(name);
        }
        if(name.equals(algorithmCallName.VARIATIONAL_MODE_DECOMPOSITION)){
            return null;
        }
        if(name.equals(algorithmCallName.EMPIRICAL_MODE_DECOMPOSITION)){
            return null;
        }
        if(name.equals(algorithmCallName.FAST_FOURIER_TRANSFORM)){
            return null;
        }
        if(name.equals(algorithmCallName.CONTINUOUS_WAVELET_TRANSFORM)){
            return null;
        }
        if(name.equals(algorithmCallName.ENVELOPE_SPECTRUM_ANALYSIS)){
            return null;
        }
        List<String> strings = new ArrayList<>();
        strings.add("没了呀");
        return strings;
    }

    @Override
    public List<timeDomainFeatures> TDFService(String name){

        HelloProto.HelloRequest request = HelloProto.HelloRequest.newBuilder().setName(name).build();
        HelloProto.HelloReply response = helloStub.sayHello(request);

        String message = response.getMessage();
        if(message.equals("success")){
            System.out.println(message);
            List<HelloProto.TimeDomainFeatures> tdfList = response.getTdfList();
            for(HelloProto.TimeDomainFeatures domainFeatures:tdfList){
                double mean = domainFeatures.getMean();
                double std = domainFeatures.getStd();
                double rootAmplitude = domainFeatures.getRootAmplitude();
                double rms = domainFeatures.getRms();
                double peakToPeak = domainFeatures.getPeakToPeak();
                double skewness = domainFeatures.getSkewness();
                double kurtosis = domainFeatures.getKurtosis();
                double crestFactor = domainFeatures.getCrestFactor();
                double clearanceFactor = domainFeatures.getClearanceFactor();
                double shapeFactor = domainFeatures.getShapeFactor();
                double impulseFactor = domainFeatures.getImpulseFactor();
                timeDomainFeatures timeDomainFeatures1 = new timeDomainFeatures(mean,std,rootAmplitude,rms,peakToPeak
                        ,skewness,kurtosis,crestFactor,clearanceFactor,shapeFactor,impulseFactor);
                ListTDF.add(timeDomainFeatures1);
            }
            return ListTDF;
        }
        System.out.println("false!");
        return null;
    }
}
