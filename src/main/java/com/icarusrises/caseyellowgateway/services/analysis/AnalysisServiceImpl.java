package com.icarusrises.caseyellowgateway.services.analysis;

import com.icarusrises.caseyellowgateway.domain.analysis.model.*;
import com.icarusrises.caseyellowgateway.services.infrastrucre.RequestHandler;
import com.icarusrises.caseyellowgateway.services.infrastrucre.RetrofitBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import retrofit2.Retrofit;

import javax.annotation.PostConstruct;

@Service
public class AnalysisServiceImpl implements AnalysisService {

    @Value("${analysis_url}")
    private String analysisUrl;

    private RequestHandler requestHandler;
    private AnalysisRequests analysisRequests;

    @PostConstruct
    public void init() {
        Retrofit retrofit = RetrofitBuilder.Retrofit(analysisUrl)
                                           .build();

        analysisRequests = retrofit.create(AnalysisRequests.class);
    }

    @Autowired
    public void setRequestHandler(RequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }

    @Override
    public OcrResponse ocrRequest(GoogleVisionRequest googleVisionRequest) {
        return requestHandler.execute(analysisRequests.ocrRequest(googleVisionRequest));
    }

    @Override
    public ImageClassificationResult classifyImage(String identifier, VisionRequest visionRequest) {
        return requestHandler.execute(analysisRequests.classifyImage(identifier, visionRequest.getImage().getMd5(), visionRequest));
    }

    @Override
    public DescriptionMatch isDescriptionExist(String user, String identifier, boolean startTest, GoogleVisionRequest visionRequest) {
        return requestHandler.execute(analysisRequests.isDescriptionExist(user, identifier, startTest, visionRequest));
    }

    @Override
    public HTMLParserResult retrieveResultFromHtml(String identifier, HTMLParserRequest htmlParserRequest) {
        return requestHandler.execute(analysisRequests.retrieveResultFromHtml(identifier, htmlParserRequest));
    }

    @Override
    public void startButtonSuccessfullyFound(String user, String identifier, int x, int y, VisionRequest visionRequest) {
        requestHandler.execute(analysisRequests.startButtonSuccessfullyFound(user, identifier, x, y, visionRequest));
    }

    @Override
    public void startButtonFailed(String user, String identifier, int x, int y, VisionRequest visionRequest) {
        requestHandler.execute(analysisRequests.startButtonFailed(user, identifier, x, y, visionRequest));
    }
}
